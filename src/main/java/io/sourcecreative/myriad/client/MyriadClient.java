package io.sourcecreative.myriad.client;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import io.sourcecreative.myriad.client.api.APIError;
import io.sourcecreative.myriad.client.api.MyriadApi;
import io.sourcecreative.myriad.client.api.MyriadApiBuilder;
import io.sourcecreative.myriad.client.json.CampaignResponseDeserializer;
import io.sourcecreative.myriad.client.model.campaign.CampaignResponse;
import io.sourcecreative.myriad.client.module.CampaignService;
import io.sourcecreative.myriad.client.module.CustomerService;
import io.sourcecreative.myriad.client.module.DistributionService;
import io.sourcecreative.myriad.client.module.MyriadModule;
import io.sourcecreative.myriad.client.module.RedemptionService;
import io.sourcecreative.myriad.client.module.SegmentService;
import io.sourcecreative.myriad.client.module.VoucherService;
import lombok.NonNull;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class MyriadClient {

	private ConnectionConfig config;
	
	private MyriadModule module;
	
	private MyriadClient(ConnectionConfig config) {
		this.config = config;
	}
	
	public static MyriadClient create(@NonNull ConnectionConfig config) {
		MyriadClient client = new MyriadClient(config);
		
		ObjectMapper mapper = client.initObjectMapper();
		
		client.module = MyriadModule.builder()
				.myriadApi(client.initMyriadApi(mapper))
				.objectMapper(mapper)
				.build();
		
		return client;
	}
	
	public static MyriadClient create(@NonNull ConnectionConfig config, MyriadApiBuilder apiProvider) {
		MyriadClient client = new MyriadClient(config);
		
		ObjectMapper mapper = client.initObjectMapper();
		
		client.module = MyriadModule.builder()
				.myriadApi(client.initMyriadApi(mapper, apiProvider))
				.objectMapper(mapper)
				.build();
		
		return client;		
	}
	
	private ObjectMapper initObjectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

		SimpleModule jsonModule = new SimpleModule();
		jsonModule.addDeserializer(CampaignResponse.class, new CampaignResponseDeserializer());
				
		mapper.registerModule(jsonModule);
		return mapper;
	}
	
	private OkHttpClient initOkHttpClient(ObjectMapper mapper) {
		OkHttpClient.Builder okClientBuilder = new OkHttpClient.Builder();
		
		okClientBuilder.addInterceptor(new Interceptor() {
			@Override
			public okhttp3.Response intercept(Chain chain) throws IOException {
				okhttp3.Request request = chain.request();
				okhttp3.Headers headers = request.headers().newBuilder()
						.add(Constants.HTTP_HEADER_APP_ID, config.appId())
						.add(Constants.HTTP_HEADER_APP_TOKEN, config.appSecret())
						.add(Constants.HTTP_HEADER_MYRIAD_CHANNEL, Constants.MYRIAD_CHANNEL_NAME)
						.build();
				request = request.newBuilder().headers(headers).build();
				return chain.proceed(request);
			}
		});
		
		okClientBuilder.addInterceptor(new HttpLoggingInterceptor().setLevel(config.logLevel()));
		
		okClientBuilder.addInterceptor(new Interceptor() {
			@Override
			public okhttp3.Response intercept(Chain chain) throws IOException {
				okhttp3.Request request = chain.request();
				okhttp3.Response response = chain.proceed(request);
				if (response.isSuccessful())
					return response;
				// convert error response to APIError and throw
				throw mapper.readValue(response.body().charStream(), APIError.class);
			}
		});
		
		return okClientBuilder.build();
	}
	
	private Retrofit initRetrofit(OkHttpClient okHttpClient, ObjectMapper objectMapper) {
		return new Retrofit.Builder()
				.baseUrl(config.baseUrl())
				.addConverterFactory(JacksonConverterFactory.create(objectMapper))
				.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
				.client(okHttpClient).build();		
	}
	
	private MyriadApi initMyriadApi(ObjectMapper mapper) {
		return initMyriadApi(mapper, null);
	}
	
	private MyriadApi initMyriadApi(ObjectMapper mapper, MyriadApiBuilder apiProvider) {
		Retrofit retrofit = initRetrofit(initOkHttpClient(mapper), mapper);
		if (apiProvider == null)
			return retrofit.create(MyriadApi.class);
		else {
			// use a builder to create retrofit instance
			return apiProvider.build(retrofit);
		}
	}
	

	/// helper functions

	public CampaignService campaigns() {
		return module.getCampaignService();
	}
	
	public VoucherService vouchers() {
		return module.getVoucherService();
	}
	
	public CustomerService customers() {
		return module.getCustomerService();
	}
	
	public DistributionService distributions() {
		return module.getDistributionService();
	}
	
	public RedemptionService redemptions() {
		return module.getRedemptionService();
	}
	
	public SegmentService segments() {
		return module.getSegmentService();
	}

}
