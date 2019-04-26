package io.sourcecreative.myriad.client.model.campaign;

import java.util.List;

import io.sourcecreative.myriad.client.model.rule.Rule;
import io.sourcecreative.myriad.client.model.voucher.CodeConfig;
import io.sourcecreative.myriad.client.model.voucher.VoucherType;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Singular;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public abstract class VoucherCampaign extends Campaign {
	// total supply of vouchers
	@NonNull
	private Integer totalSupply;
	
	private boolean autoUpdate;
			
	// Null means unlimited
	@Builder.Default
	private Integer redemption = 1;

	// voucher code configuration
	private CodeConfig codeConfig;
		
	// redemption rules if any
	@Singular("rule")
	private List<Rule> rules;

	public abstract VoucherType getVoucherType();

	@Override
	public CampaignType getType() {
		return CampaignType.VOUCHER;
	}
}
