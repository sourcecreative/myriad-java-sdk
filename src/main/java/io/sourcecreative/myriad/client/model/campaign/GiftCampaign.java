package io.sourcecreative.myriad.client.model.campaign;

import java.util.List;

import io.sourcecreative.myriad.client.model.rule.RuleResponse;
import lombok.Getter;
import lombok.NonNull;
import lombok.Singular;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class GiftCampaign extends Campaign {
	@NonNull
	private Integer totalSupply;

	// redemption rules if any
	@Singular("rule")
	private List<RuleResponse> rules;

}
