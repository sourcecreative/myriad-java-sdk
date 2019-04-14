package io.sourcecreative.myriad.client.model.campaign;

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
public class PaginatedCampaignsResponse {
	// total campaigns
	private Integer total;
	
	// current page
	private Integer page;
	
	// page size
	private Integer size;

	private List<CampaignResponse> campaigns;
	
	public static PaginatedCampaignsResponse of(Integer total, Integer page, Integer size, List<CampaignResponse> campaigns) {
		return new PaginatedCampaignsResponse(total,page,size,campaigns);
	}

}
