package io.sourcecreative.myriad.client.model.campaign;

import java.util.List;

import io.sourcecreative.myriad.client.model.rule.RuleResponse;
import io.sourcecreative.myriad.client.model.voucher.CodeConfig;
import lombok.Getter;
import lombok.Singular;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class PrepaidCardCampaign extends Campaign {
	private Integer totalSupply;
	
	// amount in cent
	private int amount;
	
	// 1 means one-time use
	private Integer redemption;
	
	private CodeConfig codeConfig;

	// redemption rules if any
	@Singular("rule")
	private List<RuleResponse> rules;

}
