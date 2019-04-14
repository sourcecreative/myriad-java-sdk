package io.sourcecreative.myriad.client;

import java.io.IOException;
import java.lang.annotation.Annotation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import io.sourcecreative.myriad.client.api.APIError;
import io.sourcecreative.myriad.client.api.MyriadApi;
import io.sourcecreative.myriad.client.module.CampaignModule;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class MyriadClient {
  private final String httpScheme;
  
  private MyriadApi api;
  private Retrofit retrofit;
  
  private CampaignModule campaignModule;
  
  private MyriadClient(Builder builder) {
    if (builder.appSecret == null)
      throw new IllegalArgumentException("App token must be defined.");


    if (builder.appId == null)
      throw new IllegalArgumentException("App ID must be defined.");

    this.httpScheme = createHttpScheme(builder);
    this.api = createRetrofitService(builder);
    

    // create modules
    this.campaignModule = new CampaignModule(api);
	  
  }
  
  private ObjectMapper createObjectMapper(Builder builder) {
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

  private String createHttpScheme(Builder builder) {
    if (builder.secure) {
      return Constants.SCHEME_HTTPS;
    } else {
      return Constants.SCHEME_HTTP;
    }
  }

  private MyriadApi createRetrofitService(Builder builder) {
	OkHttpClient.Builder okClientBuilder = new OkHttpClient.Builder();
	okClientBuilder.addInterceptor(headerInterceptor(builder))
		.addInterceptor(new HttpLoggingInterceptor().setLevel(builder.logLevel))
		.addInterceptor(errorInterceptor());

	Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
		.baseUrl(String.format("%s://%s", httpScheme, builder.endpoint==null?Constants.ENDPOINT_MYRIAD:builder.endpoint))
		.addConverterFactory(JacksonConverterFactory.create(createObjectMapper(builder)))
		.client(okClientBuilder.build());
	retrofit = retrofitBuilder.build();
    return retrofit.create(MyriadApi.class);
  }

  private Interceptor headerInterceptor(final Builder builder) {
    return new Interceptor() {
      @Override
      public okhttp3.Response intercept(Chain chain) throws IOException {
    	  okhttp3.Request request = chain.request();
    	  okhttp3.Headers headers = request.headers().newBuilder()
    			  .add(Constants.HTTP_HEADER_APP_ID, builder.appId)
    			  .add(Constants.HTTP_HEADER_APP_TOKEN, builder.secure?builder.appSecret:"")
    			  .add(Constants.HTTP_HEADER_MYRIAD_CHANNEL, Constants.MYRIAD_CHANNEL_NAME)
    			  .add(Constants.HTTP_HEADER_MYRIAD_API_VERSION, builder.apiVersion.getValue())
    			  .build();
    	  request = request.newBuilder().headers(headers).build();
    	  return chain.proceed(request);
      }
    };
  }
  
  private Interceptor errorInterceptor() {
	  return new Interceptor() {
		  @Override
		  public okhttp3.Response intercept(Chain chain) throws IOException {
			  okhttp3.Request request = chain.request();
              okhttp3.Response response = chain.proceed(request);
              if (response.isSuccessful())
            	  return response;
              Converter<ResponseBody, APIError> converter = retrofit.responseBodyConverter(APIError.class, new Annotation[0]);
              APIError error = converter.convert(response.body());
              throw error;
		  }
	  };
  }

  
  public static class Builder {

    String appSecret;

    String appId;

    String endpoint;

    boolean secure;

    Level logLevel = Level.NONE;

    ApiVersion apiVersion = ApiVersion.lastest();

    public Builder() {
      this.secure = true;
    }

    public Builder setAppSecret(String appSecret) {
      if (appSecret == null) {
        throw new IllegalArgumentException("Cannot call setAppSecret() with null.");
      }

      this.appSecret = appSecret;
      return this;
    }

    public Builder setAppId(String appId) {
      if (appId == null) {
        throw new IllegalArgumentException("Cannot call setAppId() with null.");
      }

      this.appId = appId;
      return this;
    }

    public Builder setEndpoint(String remoteUrl) {
      if (remoteUrl == null) {
        throw new IllegalArgumentException("Cannot call setEndpoint() with null.");
      }

      this.endpoint = remoteUrl;
      return this;
    }

    public Builder setLogLevel(Level logLevel) {
      if (logLevel == null) {
        throw new IllegalArgumentException("Cannot call setLogLevel() with null.");
      }

      this.logLevel = logLevel;
      return this;
    }

    public Builder withSSL() {
      this.secure = true;
      return this;
    }

    public Builder withoutSSL() {
      this.secure = false;
      return this;
    }

    public Builder apiVersion(ApiVersion version) {
      if (version == null)
    	  throw new IllegalArgumentException("Unspecified API version");
      this.apiVersion = version;
      return this;
    }

    public MyriadClient build() {
      return new MyriadClient(this);
    }

  }


}
