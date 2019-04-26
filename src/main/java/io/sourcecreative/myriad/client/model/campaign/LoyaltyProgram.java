package io.sourcecreative.myriad.client.model.campaign;

import java.util.List;

import io.sourcecreative.myriad.client.model.rule.Rule;
import io.sourcecreative.myriad.client.model.voucher.VoucherType;
import lombok.Getter;
import lombok.Singular;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class LoyaltyProgram extends VoucherCampaign {
	// where points can be used
	private String campaignId;
	
	// earning rules
	@Singular("earningRule")
	private List<Rule> earningRules;

	@Override
	public VoucherType getVoucherType() {
		return VoucherType.LOYALTY_CARD;
	}
}
