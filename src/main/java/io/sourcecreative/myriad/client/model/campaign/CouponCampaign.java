package io.sourcecreative.myriad.client.model.campaign;

import io.sourcecreative.myriad.client.model.voucher.Discount;
import io.sourcecreative.myriad.client.model.voucher.VoucherType;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class CouponCampaign extends VoucherCampaign {
	@NonNull
	private Discount discount;

	@Override
	public VoucherType getVoucherType() {
		return VoucherType.COUPON;
	}
	
	
}
