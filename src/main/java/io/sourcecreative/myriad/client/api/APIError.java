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
@Builder
@ToString
public class APIError extends RuntimeException {
	private static final long serialVersionUID = 1871082617076449419L;
	
	private Integer code;
	private String message;
	private String key;
    private String details;    
}
