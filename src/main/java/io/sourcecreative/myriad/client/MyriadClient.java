package io.sourcecreative.myriad.client;

import java.io.IOException;

import org.assertj.core.util.Strings;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import io.sourcecreative.myriad.client.api.APIError;
import io.sourcecreative.myriad.client.api.MyriadApi;
import io.sourcecreative.myriad.client.json.CampaignResponseDeserializer;
import io.sourcecreative.myriad.client.model.campaign.CampaignResponse;
import io.sourcecreative.myriad.client.module.CampaignService;
import io.sourcecreative.myriad.client.module.CustomerService;
import io.sourcecreative.myriad.client.module.DistributionService;
import io.sourcecreative.myriad.client.module.MyriadModule;
import io.sourcecreative.myriad.client.module.RedemptionService;
import io.sourcecreative.myriad.client.module.SegmentService;
import io.sourcecreative.myriad.client.module.VoucherService;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Accessors;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Accessors(fluent = true)
public class MyriadClient {
	@Getter
	private final String baseUrl;

	@Getter
	private final String appId;

	@Getter
	private final String appSecret;

	@Getter
	private Level logLevel;
	
	private MyriadModule module;
	
	@Builder
	private MyriadClient(@NonNull String baseUrl, @NonNull String appId, 
			@NonNull String appSecret, @NonNull Level logLevel) {
		
		if (Strings.isNullOrEmpty(appSecret))
			throw new IllegalArgumentException("App token must be defined.");

		if (Strings.isNullOrEmpty(appId))
			throw new IllegalArgumentException("App ID must be defined.");
		
		this.appId = appId;
		this.appSecret = appSecret;
		this.baseUrl = baseUrl;
		this.logLevel = logLevel;
		
		ObjectMapper mapper = initObjectMapper();
		module = MyriadModule.builder()
				.myriadApi(initMyriadApi(mapper))
				.objectMapper(mapper)
				.build();
		
	}
	
	private ObjectMapper initObjectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

		SimpleModule jsonModule = new SimpleModule();
		jsonModule.addDeserializer(CampaignResponse.class, new CampaignResponseDeserializer());
		
//    jsonParsingModule.addSerializer(Date.class, new DateSerializer(Constants.ENDPOINT_DATE_FORMAT));
//    jsonParsingModule.addDeserializer(Date.class, new DateDeserializer(Constants.ENDPOINT_DATE_FORMAT, Constants.ENDPOINT_SECONDARY_DATE_FORMAT));
//    jsonParsingModule.addDeserializer(CampaignsResponse.class, new CampaignsResponseDeserializer(builder.apiVersion));
//    jsonParsingModule.addDeserializer(VouchersResponse.class, new VouchersResponseDeserializer(builder.apiVersion));
		
		mapper.registerModule(jsonModule);
		return mapper;
	}
	
	private OkHttpClient initOkHttpClient(ObjectMapper mapper) {
		OkHttpClient.Builder okClientBuilder = new OkHttpClient.Builder();
		
		okClientBuilder.addInterceptor(new Interceptor() {
			@Override
			public okhttp3.Response intercept(Chain chain) throws IOException {
				okhttp3.Request request = chain.request();
				okhttp3.Headers headers = request.headers().newBuilder().add(Constants.HTTP_HEADER_APP_ID, appId)
						.add(Constants.HTTP_HEADER_APP_TOKEN, appSecret)
						.add(Constants.HTTP_HEADER_MYRIAD_CHANNEL, Constants.MYRIAD_CHANNEL_NAME)
						.build();
				request = request.newBuilder().headers(headers).build();
				return chain.proceed(request);
			}
		});
		
		okClientBuilder.addInterceptor(new HttpLoggingInterceptor().setLevel(logLevel));
		
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
				.baseUrl(baseUrl)
				.addConverterFactory(JacksonConverterFactory.create(objectMapper))
				.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
				.client(okHttpClient).build();		
	}
	
	private MyriadApi initMyriadApi(ObjectMapper mapper) {
		return initRetrofit(initOkHttpClient(mapper), mapper).create(MyriadApi.class);
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
