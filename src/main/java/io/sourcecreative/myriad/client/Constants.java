package io.sourcecreative.myriad.client;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Constants {
  // HTTP constants
  public static final String SCHEME_HTTP = "http";
  public static final String SCHEME_HTTPS = "https";
  public static final String HTTP_HEADER_APP_ID = "X-App-Id";
  public static final String HTTP_HEADER_APP_TOKEN = "X-App-Token";
  public static final String HTTP_HEADER_MYRIAD_CHANNEL = "X-Myriad-Channel";
  public static final String MYRIAD_CHANNEL_NAME = "Java-SDK";
  public static final String HTTP_HEADER_MYRIAD_API_VERSION = "X-Myriad-API-Version";

  // Configuration
  public static final String MYRIAD_ENDPOINT_BASE_URL = "https://myriadapi.sourcecreative.io/v1/";
  public static final String MYRIAD_ENDPOINT_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssXXX";
  public static final String MYRIAD_ENDPOINT_SECONDARY_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";

}
