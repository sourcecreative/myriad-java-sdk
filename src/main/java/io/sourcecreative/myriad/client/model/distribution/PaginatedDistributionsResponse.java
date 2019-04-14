package io.sourcecreative.myriad.client.model.distribution;

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
public class PaginatedDistributionsResponse {
	private Integer total;
	
	private Integer page;
	
	private Integer size;
	
	private List<DistributionResponse> distributions;

}
