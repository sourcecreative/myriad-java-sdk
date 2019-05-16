package io.sourcecreative.myriad.client.model.redemption;

import java.util.Map;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@ToString
public class OrderItem {
	private String productId;
	private String skuId;
	private Integer quantity;
	private Integer price;
	private Integer amount;
	@Singular("metadataEntry")
	private Map<String,Object> metadata;

}
