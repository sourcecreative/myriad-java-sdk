package io.sourcecreative.myriad.client.model.campaign;

import java.math.BigDecimal;

import io.sourcecreative.myriad.client.model.voucher.VoucherType;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class PrepaidCardCampaign extends VoucherCampaign {
	// cash amount
	private BigDecimal amount;

	@Override
	public VoucherType getVoucherType() {
		return VoucherType.PREPAID_CARD;
	}
	
}
