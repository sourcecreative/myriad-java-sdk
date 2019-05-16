package io.sourcecreative.myriad.client.model.product;

import java.util.Map;

import io.sourcecreative.myriad.client.model.Currency;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class ProductResponse {
	private String id;
	//a unique product identifier from inventory system used for integration
	private String sourceId;
	
	@NonNull
	private String name;
	
	// H5-enabled product description
	private String description;
	
	private Integer price;
	
	private Currency currency;

	private Map<String, Object> metadata;

}
