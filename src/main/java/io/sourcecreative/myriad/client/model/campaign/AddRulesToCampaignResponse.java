package io.sourcecreative.myriad.client.model.campaign;

import java.util.List;

import io.sourcecreative.myriad.client.model.validation.RuleResponse;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class AddRulesToCampaignResponse extends CampaignResponse {
	private List<RuleResponse> rules;
}
