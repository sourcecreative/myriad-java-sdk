package io.sourcecreative.myriad.client.model.campaign;

import java.math.BigDecimal;
import java.util.List;

import io.sourcecreative.myriad.client.model.rule.RuleResponse;
import io.sourcecreative.myriad.client.model.voucher.CodeConfig;
import io.sourcecreative.myriad.client.model.voucher.Discount;
import io.sourcecreative.myriad.client.model.voucher.VoucherType;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class VoucherCampaignResponse extends CampaignResponse {
	
	private boolean autoUpdate;

	@NonNull
	private VoucherType voucherType;
	
	// max redemption quantity
	private Integer redemption;

	private CodeConfig codeConfig;
			
	// discount for DISCOUNT voucher
	private Discount discount;

	// prepaid card value
	private BigDecimal amount;
		
	// redemption rules if any
	private List<RuleResponse> rules;
		
	// earning rules for Loyalty Program
	private List<RuleResponse> earningRules;

}
