package io.sourcecreative.myriad.client.model.distribution;

import java.util.List;
import java.util.Map;

import io.sourcecreative.myriad.client.model.customer.CustomerResponse;
import io.sourcecreative.myriad.client.model.voucher.Voucher;
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
@Getter
@Builder
@ToString
public class DistributeOneOffVouchers {
	@NonNull
	private Channel channel;
	
	@NonNull
	private Voucher voucher;
	
	// how many to be distributed to the customer
	@Builder.Default
	private Integer countPerCustomer = 1;

	// customers who receive voucher
	@NonNull @Singular("customer")
	private List<CustomerResponse> customers;

	@Singular("metadataEntry")
	private Map<String, Object> metadata;

}
