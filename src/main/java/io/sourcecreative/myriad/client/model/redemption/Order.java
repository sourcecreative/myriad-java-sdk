package io.sourcecreative.myriad.client.model.redemption;

import java.util.Map;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@ToString
public class Order {
	// sourceId is the order number from client app
	private String sourceId;
	
	// total amount for the order
	@NonNull
	private Integer amount;
	
	@Singular("metadata")
	private Map<String, Object> metadata;

}
