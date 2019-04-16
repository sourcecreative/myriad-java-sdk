package io.sourcecreative.myriad.client.model.distribution;

import java.util.List;
import java.util.Map;

import io.sourcecreative.myriad.client.model.customer.Customer;
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
public class DistributeVouchers {
	@NonNull
	private String campaignId;

	private Channel channel;
	
	// how many to be distributed to the customer
	@NonNull @Builder.Default
	private Integer countPerCustomer = 1;

	// customers who receive voucher. If this customer is not created, it will be saved before
	// vouchers are distributed to this customer. Customer's sourceId must be provided.
	@Singular("customer")
	private List<Customer> customers;

	@Singular("metadataEntry")
	private Map<String, Object> metadata;

}
