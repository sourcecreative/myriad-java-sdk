package io.sourcecreative.myriad.client;

import lombok.Getter;

@Getter
public enum ApiVersion {
  V1("V1");	
	
  private final String value;

  ApiVersion(String value) {
    this.value = value;
  }
  
  public static ApiVersion lastest() {
	return V1;
  }
}
