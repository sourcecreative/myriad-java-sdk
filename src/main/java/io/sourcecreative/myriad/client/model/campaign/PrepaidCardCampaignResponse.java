package io.sourcecreative.myriad.client.model.campaign;

import java.util.List;

import io.sourcecreative.myriad.client.model.rule.RuleResponse;
import io.sourcecreative.myriad.client.model.voucher.CodeConfig;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class PrepaidCardCampaignResponse extends CampaignResponse {
	private Integer totalSupply;
	
	// amount in cent
	private int amount;
	
	// 1 means one-time use
	private Integer redemption;
	
	private CodeConfig codeConfig;
	
	// redemption rules
	private List<RuleResponse> rules;

}
