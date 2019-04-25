package io.sourcecreative.myriad.client.model.campaign;

import java.util.List;

import io.sourcecreative.myriad.client.model.rule.RuleResponse;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class GiftCampaignResponse extends CampaignResponse {
	@NonNull
	private Integer totalSupply;

	// validation rules if any
	private List<RuleResponse> rules;

}
