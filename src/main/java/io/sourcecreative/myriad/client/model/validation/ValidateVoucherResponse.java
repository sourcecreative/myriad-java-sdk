package io.sourcecreative.myriad.client.model.validation;

import io.sourcecreative.myriad.client.model.redemption.Order;
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
public class ValidateVoucherResponse {
	// is the voucher valid for the order
	private boolean valid;
		
	private VoucherResponse voucher;
	
	private Order order;
	
	// why voucher is not valid for this order
	private String reasons;
}
