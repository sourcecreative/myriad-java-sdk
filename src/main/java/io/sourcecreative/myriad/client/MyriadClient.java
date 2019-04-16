package io.sourcecreative.myriad.client;

import java.io.IOException;

import org.assertj.core.util.Strings;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import io.sourcecreative.myriad.client.api.APIError;
import io.sourcecreative.myriad.client.api.MyriadApi;
import io.sourcecreative.myriad.client.module.CampaignModule;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Builder
@Accessors(fluent = true)
public class MyriadClient {
	@Getter
	private final String baseUrl;

	@Getter
	private final String appId;

	@Getter
	private final String appSecret;

	@Getter @Builder.Default
	private final Level logLevel = Level.NONE;

	// TODO: ignore this field in the builder
	private final CampaignModule campaignModule;

	@Builder
	private MyriadClient(String baseUrl, String appId, String appSecret, Level logLevel) {
		
		if (Strings.isNullOrEmpty(appSecret))
			throw new IllegalArgumentException("App token must be defined.");

		if (Strings.isNullOrEmpty(appId))
			throw new IllegalArgumentException("App ID must be defined.");
		
		this.appId = appId;
		this.appSecret = appSecret;
		this.baseUrl = baseUrl;
		this.logLevel = logLevel;

		MyriadApi api = createRetrofitService(this.baseUrl, this.appId, this.appSecret);

		// create modules
		this.campaignModule = new CampaignModule(api);
		
		// other modules
	}
	
	public CampaignModule campaigns() {
		return campaignModule;
	}

	private ObjectMapper createObjectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

//    SimpleModule jsonParsingModule = new SimpleModule();
//    jsonParsingModule.addSerializer(Date.class, new DateSerializer(Constants.ENDPOINT_DATE_FORMAT));
//    jsonParsingModule.addDeserializer(Date.class, new DateDeserializer(Constants.ENDPOINT_DATE_FORMAT, Constants.ENDPOINT_SECONDARY_DATE_FORMAT));
//    jsonParsingModule.addDeserializer(CampaignsResponse.class, new CampaignsResponseDeserializer(builder.apiVersion));
//    jsonParsingModule.addDeserializer(VouchersResponse.class, new VouchersResponseDeserializer(builder.apiVersion));
//    mapper.registerModule(jsonParsingModule);
		return mapper;
	}

	private MyriadApi createRetrofitService(final String baseUrl, final String appid, final String secret) {
		OkHttpClient.Builder okClientBuilder = new OkHttpClient.Builder();
		
		okClientBuilder.addInterceptor(new Interceptor() {
			@Override
			public okhttp3.Response intercept(Chain chain) throws IOException {
				okhttp3.Request request = chain.request();
				okhttp3.Headers headers = request.headers().newBuilder().add(Constants.HTTP_HEADER_APP_ID, appid)
						.add(Constants.HTTP_HEADER_APP_TOKEN, secret)
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
				throw new ObjectMapper().readValue(response.body().charStream(), APIError.class);
			}
		});

		Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
				.baseUrl(baseUrl)
				.addConverterFactory(JacksonConverterFactory.create(createObjectMapper()))
				.client(okClientBuilder.build());
		
		return retrofitBuilder.build().create(MyriadApi.class);
	}

	/*
	 * 
	 * public static class Builder {
	 * 
	 * String appSecret;
	 * 
	 * String appId;
	 * 
	 * String endpoint;
	 * 
	 * boolean secure;
	 * 
	 * Level logLevel = Level.NONE;
	 * 
	 * ApiVersion apiVersion = ApiVersion.lastest();
	 * 
	 * public Builder() { this.secure = true; }
	 * 
	 * public Builder setAppSecret(String appSecret) { if (appSecret == null) {
	 * throw new IllegalArgumentException("Cannot call setAppSecret() with null.");
	 * }
	 * 
	 * this.appSecret = appSecret; return this; }
	 * 
	 * public Builder setAppId(String appId) { if (appId == null) { throw new
	 * IllegalArgumentException("Cannot call setAppId() with null."); }
	 * 
	 * this.appId = appId; return this; }
	 * 
	 * public Builder setEndpoint(String remoteUrl) { if (remoteUrl == null) { throw
	 * new IllegalArgumentException("Cannot call setEndpoint() with null."); }
	 * 
	 * this.endpoint = remoteUrl; return this; }
	 * 
	 * public Builder setLogLevel(Level logLevel) { if (logLevel == null) { throw
	 * new IllegalArgumentException("Cannot call setLogLevel() with null."); }
	 * 
	 * this.logLevel = logLevel; return this; }
	 * 
	 * public Builder withSSL() { this.secure = true; return this; }
	 * 
	 * public Builder withoutSSL() { this.secure = false; return this; }
	 * 
	 * public Builder apiVersion(ApiVersion version) { if (version == null) throw
	 * new IllegalArgumentException("Unspecified API version"); this.apiVersion =
	 * version; return this; }
	 * 
	 * public MyriadClient build() { return new MyriadClient(this); }
	 * 
	 * }
	 */

}
