package io.sourcecreative.myriad.client.model.campaign;

import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class PaginatedCampaignsResponse {
	// total campaigns
	@NonNull
	private Integer total;
	
	// current page
	@NonNull
	private Integer page;
	
	// page size
	@NonNull
	private Integer size;

	@NonNull
	private List<CampaignResponse> campaigns;
	
//	public static PaginatedCampaignsResponse of(Integer total, Integer page, Integer size, List<CampaignResponse> campaigns) {
//		return new PaginatedCampaignsResponse(total,page,size,campaigns);
//	}

}
