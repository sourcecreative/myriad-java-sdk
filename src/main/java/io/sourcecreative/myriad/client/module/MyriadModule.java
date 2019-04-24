package io.sourcecreative.myriad.client.module;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.sourcecreative.myriad.client.api.MyriadApi;
import lombok.Builder;
import lombok.NonNull;

public class MyriadModule {
	private CampaignService campaignService;
	
	@Builder
	private MyriadModule(@NonNull MyriadApi myriadApi, @NonNull ObjectMapper objectMapper) {
		init(myriadApi,objectMapper);
	}
	
	private void init(MyriadApi myriadApi, ObjectMapper objectMapper) {
		// init services
		campaignService = new CampaignService(myriadApi, objectMapper);
	}
	
	public CampaignService getCampaignService() {
		return campaignService;
	}
}
