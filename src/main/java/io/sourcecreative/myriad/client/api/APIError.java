package io.sourcecreative.myriad.client.api;

import java.io.IOException;

public class APIError extends RuntimeException {
	private static final long serialVersionUID = 1871082617076449419L;
	
	private int code;
	
	public APIError() {
		super();
	}
	
	public APIError(int code, String message) {
		super(message);
		this.code = code;
	}
		
	public APIError(Throwable cause) {
		super(cause);
		
		if (cause instanceof IOException) {
			this.code = 408;
		} else {
			this.code = 500;
		}
	}
	
	public int getCode() {
		return code;
	}
}
