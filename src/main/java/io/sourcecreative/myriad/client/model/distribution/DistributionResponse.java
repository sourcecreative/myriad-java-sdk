package io.sourcecreative.myriad.client.model.distribution;

import java.util.Date;
import java.util.Map;

import io.sourcecreative.myriad.client.model.customer.CustomerResponse;
import io.sourcecreative.myriad.client.model.voucher.VoucherResponse;
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
public class DistributionResponse {
	// distribution id
	private String id;
	
	private Date createdAt;
	
	private DistributionStatus status;

	private Map<String, Object> metadata;

	@NonNull
	private Channel channel;
	
	@NonNull
	private CustomerResponse customer;
	
	// voucher to be distributed
	@NonNull
	private VoucherResponse voucher;
	
}
