package io.sourcecreative.myriad.client.module;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.sourcecreative.myriad.client.api.MyriadApi;
import lombok.Builder;
import lombok.NonNull;

@Builder
public class MyriadModule {
	@NonNull
	private MyriadApi myriadApi;
	
	@NonNull
	private ObjectMapper objectMapper;
	
	private CampaignService campaignService;
	
	@Builder
	private MyriadModule(MyriadApi api, ObjectMapper om) {
		this.myriadApi = api;
		this.objectMapper = om;
		
		init();
	}
	
	private void init() {
		campaignService = new CampaignService(myriadApi, objectMapper);
	}
	
	public CampaignService getCampaignService() {
		return campaignService;
	}
	

}
