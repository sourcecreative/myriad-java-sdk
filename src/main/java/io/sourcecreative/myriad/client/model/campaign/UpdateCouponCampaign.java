package io.sourcecreative.myriad.client.model.campaign;

import io.sourcecreative.myriad.client.model.voucher.VoucherConfig;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@ToString
public class UpdateCouponCampaign extends UpdateCampaign {
	
	private Integer totalSupply;
	
	private Integer maxSupply;

	private VoucherConfig coupon;

}
