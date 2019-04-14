package io.sourcecreative.myriad.client.model.validation;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class RulesResponse {
	// campaign that rules apply to
	private String campaignId;
	
	// voucher that rules apply to
	private String voucherId;
	
	private List<RuleResponse> rules;

}
