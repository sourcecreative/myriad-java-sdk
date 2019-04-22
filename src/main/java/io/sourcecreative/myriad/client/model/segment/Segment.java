package io.sourcecreative.myriad.client.model.segment;

import java.util.Map;

import io.sourcecreative.myriad.client.model.validation.Rule;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@ToString
public class Segment {
	@NonNull
	private String name;
	
	private String description;
	
	// Use a rule to automatically segment customers 
	@NonNull
	private Rule filter;
	
	@Singular("metadata")
	private Map<String, Object> metadata;	

}
