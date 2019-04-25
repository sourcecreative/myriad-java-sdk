package io.sourcecreative.myriad.client.model.campaign;

import io.sourcecreative.myriad.client.model.voucher.CouponConfig;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@ToString
public class UpdateVoucherCampaign extends UpdateCampaign {
	
	private Integer totalSupply;
	
	private Integer maxSupply;

	private CouponConfig voucher;

}
