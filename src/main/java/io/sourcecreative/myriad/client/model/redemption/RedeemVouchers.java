package io.sourcecreative.myriad.client.model.redemption;

import java.util.List;
import java.util.Map;

import io.sourcecreative.myriad.client.model.customer.Customer;
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
public class RedeemVouchers {
	
	private Customer customer;
	
	private Order order;
	
	private List<String> voucherCodes;
	
	@Singular("metadata")
	private Map<String, Object> metadata;

}
