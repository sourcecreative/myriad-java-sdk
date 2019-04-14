package io.sourcecreative.myriad.client.model.redemption;

import java.util.Map;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class OrderResponse {
	// system generated id representing this order
	private String id;
	
	// sourceId is the order number from client app
	private String sourceId;
	
	// total amount for the order
	private Integer amount;
	
	// discounts applied
	private Integer discountAmount;
	
	// other information that client app wants to save
	private Map<String, Object> metadata;

}
