package io.sourcecreative.myriad.client.model.redemption;

import java.util.Date;
import java.util.Map;

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
public class RedemptionResponse {
	private String id;
	
	private Date createdAt;

	// who creates the redemption
	private String customerId;
	
	// the order that redemption is applied to
	private OrderResponse order;
	
	// the voucher used in this redemption
	private VoucherResponse voucher;
	
	// other information that client app wants to save
	private Map<String, Object> metadata;

}
