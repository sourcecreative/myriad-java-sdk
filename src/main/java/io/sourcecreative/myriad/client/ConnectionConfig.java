package io.sourcecreative.myriad.client;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Accessors;
import okhttp3.logging.HttpLoggingInterceptor.Level;

@Accessors(fluent = true)
@Getter
@Builder
public class ConnectionConfig {
	@Builder.Default
	private String baseUrl = Constants.MYRIAD_ENDPOINT_BASE_URL;

	@NonNull
	private final String appId;

	@NonNull
	private final String appSecret;

	@Builder.Default
	private Level logLevel = Level.BASIC;

}
