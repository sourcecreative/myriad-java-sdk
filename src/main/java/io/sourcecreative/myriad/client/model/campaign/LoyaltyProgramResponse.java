package io.sourcecreative.myriad.client.model.campaign;

import java.util.List;

import io.sourcecreative.myriad.client.model.rule.Rule;
import io.sourcecreative.myriad.client.model.voucher.CodeConfig;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class LoyaltyProgramResponse extends CampaignResponse {
	// symbol of the points
	@NonNull
	private String symbol;
	
	// name of the points
	@NonNull
	private String name;

	// used to generate membership code
	private CodeConfig codeConfig;
	
	// reward rules
	private List<Rule> rules;

}
