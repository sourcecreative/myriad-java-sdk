package io.sourcecreative.myriad.client.model;

import java.util.Map;
import java.util.Set;

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
	
	@Singular("rule")
	private Set<Rule> rules;
	
	@Singular("metadataEntry")
	private Map<String,Object> metadata;
}
