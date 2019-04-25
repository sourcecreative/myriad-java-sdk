package io.sourcecreative.myriad.client.api;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class APIError extends RuntimeException {
	private static final long serialVersionUID = 1871082617076449419L;
	
	private Integer code;
	private String key;
	
	@Builder
	private APIError(int code, String key, String message) {
		super(message);
		this.code = code;
		this.key = key;
	}
}
