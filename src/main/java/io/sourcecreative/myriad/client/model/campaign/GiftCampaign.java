package io.sourcecreative.myriad.client.model.campaign;

import io.sourcecreative.myriad.client.model.voucher.VoucherType;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class GiftCampaign extends VoucherCampaign {
	// what product to be used as gift
	@NonNull
	private String productId;

	@Override
	public VoucherType getVoucherType() {
		return VoucherType.GIFT;
	}
}
