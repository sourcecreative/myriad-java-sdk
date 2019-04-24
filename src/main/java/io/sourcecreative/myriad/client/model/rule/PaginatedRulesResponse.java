package io.sourcecreative.myriad.client.model.rule;

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
public class PaginatedRulesResponse {
	private Integer total;
	
	private Integer page;
	
	private Integer size;
	
	// including custom rules and system rules
	private List<RuleResponse> rules;
}
