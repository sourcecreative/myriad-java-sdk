package io.sourcecreative.myriad.client.model.promotion;

import java.util.Map;
import java.util.Set;

import io.sourcecreative.myriad.client.model.rule.RuleResponse;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class TierResponse {
	@NonNull
	private String id;
	
	@NonNull
	private String name;
	
	@NonNull
	private String description;
	
	private Set<RuleResponse> rules;
	
	private Map<String,Object> metadata;

}
