package io.sourcecreative.myriad.client.model.segment;

import java.util.List;
import java.util.Map;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@ToString
public class CreateSegment {
	private String name;
	
	// caller must provide either a list of customer ids, or a customer filter that
	// defines which customers belong to this segment
	private List<String> customerIds;
	
	// caller must provide either a customer filter that defines which customers 
	// belong to this segment, or a list of customer ids
	private Map<String, Object> filter;
	
	@Singular("metadata")
	private Map<String, Object> metadata;	

}
