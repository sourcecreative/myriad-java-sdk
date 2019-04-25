package io.sourcecreative.myriad.client.model.loyalty;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.sourcecreative.myriad.client.model.customer.Customer;
import io.sourcecreative.myriad.client.model.voucher.CodeConfig;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
@ToString
public class Loyalty {
	// if client specifies a card code
	private String code;
	
	// auto generate code if code is not specified
	private CodeConfig codeConfig;
	
	// initial points
	private int points;

	// member
	private Customer customer;
	
	@Singular("metadataEntry")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Map<String, Object> metadata;

}
