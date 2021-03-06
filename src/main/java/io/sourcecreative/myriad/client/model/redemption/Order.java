package io.sourcecreative.myriad.client.model.redemption;

import java.util.List;
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
	
	private String customerId;
	
	private String referrerId;
	
	// total amount for the order
	@NonNull
	private Integer amount;
	
	@Singular
	private List<OrderItem> items;
	
	@Singular("metadataEntry")
	private Map<String, Object> metadata;
}
