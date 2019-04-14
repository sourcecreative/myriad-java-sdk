package io.sourcecreative.myriad.client.model.distribution;

import java.util.Date;
import java.util.List;
import java.util.Map;

import io.sourcecreative.myriad.client.model.customer.CustomerResponse;
import io.sourcecreative.myriad.client.model.voucher.VoucherResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class DistributionResponse {
	private String id;
	
	private Date createdAt;

	private Map<String, Object> metadata;

	private String channel;
	
	private CustomerResponse customer;
	
	// vouchers to be distributed in this distribution batch
	private List<VoucherResponse> vouchers;
	
}
