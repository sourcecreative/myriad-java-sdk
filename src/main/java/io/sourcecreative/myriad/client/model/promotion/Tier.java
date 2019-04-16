package io.sourcecreative.myriad.client.model.promotion;

import java.util.Map;
import java.util.Set;

import io.sourcecreative.myriad.client.model.validation.Rule;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Tier {
	private String name;
	private String description;
	
	// validation rule including actions for this tier
	@Singular("rule")
	private Set<Rule> rules;
	
	@Singular("metadataEntry")
	private Map<String,Object> metadata;
}
