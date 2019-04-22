package io.sourcecreative.myriad.client.model.campaign;

import java.util.Set;

import io.sourcecreative.myriad.client.model.validation.Rule;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@ToString
public class AddRulesToCampaign {
	// assign rules to campaign - if a rule does not exist, create and assign
	private Set<Rule> rules;
}
