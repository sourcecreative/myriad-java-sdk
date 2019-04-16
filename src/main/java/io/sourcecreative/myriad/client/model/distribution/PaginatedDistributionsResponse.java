package io.sourcecreative.myriad.client.model.distribution;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class PaginatedDistributionsResponse {
	@NonNull
	private Integer total;
	
	@NonNull
	private Integer page;
	
	@NonNull
	private Integer size;
	
	@NonNull
	private List<DistributionResponse> distributions;

}
