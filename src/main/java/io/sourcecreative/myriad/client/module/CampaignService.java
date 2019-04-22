package io.sourcecreative.myriad.client.module;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.sourcecreative.myriad.client.api.MyriadApi;
import io.sourcecreative.myriad.client.model.campaign.ActivateCampaign;
import io.sourcecreative.myriad.client.model.campaign.AddRulesToCampaign;
import io.sourcecreative.myriad.client.model.campaign.AddVoucherToCampaign;
import io.sourcecreative.myriad.client.model.campaign.Campaign;
import io.sourcecreative.myriad.client.model.campaign.CampaignResponse;
import io.sourcecreative.myriad.client.model.campaign.ImportVouchersToCampaign;
import io.sourcecreative.myriad.client.model.campaign.PaginatedCampaignsResponse;
import io.sourcecreative.myriad.client.model.campaign.UpdateCampaign;

public class CampaignService extends Service {

	public CampaignService(MyriadApi api, ObjectMapper objectMapper) {
		super(api, objectMapper);
	}

	public RemoteCall<CampaignResponse> create(Campaign campaign) {
		return RemoteCall.of(api.createCampaign(campaign));
	}
	
	public RemoteCall<CampaignResponse> addVoucher(String campaignId, AddVoucherToCampaign addVoucher) {
		return RemoteCall.of(api.addVoucherToCampaign(campaignId, addVoucher));
	}

	public RemoteCall<CampaignResponse> findById(String campaignId) {
		return RemoteCall.of(api.getCampaign(campaignId));
	}

	public RemoteCall<PaginatedCampaignsResponse> list(Map<String, Object> filter) {
		return RemoteCall.of(api.listCampaigns(filter));
	}

	public RemoteCall<CampaignResponse> update(String campaignId, UpdateCampaign updateCampaign) {
		return RemoteCall.of(api.updateCampaign(campaignId, updateCampaign));
	}

	public RemoteCall<CampaignResponse> activate(String campaignId, ActivateCampaign activateCampaign) {
		return RemoteCall.of(api.activateCampaign(campaignId, activateCampaign));
	}

	public RemoteCall<Void> delete(String campaignId) {
		return RemoteCall.of(api.deleteCampaign(campaignId));
	}

	public RemoteCall<CampaignResponse> importVouchers(String campaignId, ImportVouchersToCampaign importVouchers) {
		return RemoteCall.of(api.importVouchersToCampaign(campaignId, importVouchers));
	}

	public RemoteCall<CampaignResponse> attachRules(String campaignId, AddRulesToCampaign addRules) {
		return RemoteCall.of(api.attachRulesToCampaign(campaignId, addRules));
	}

	public RemoteCall<Void> detachRules(String campaignId) {
		return RemoteCall.of(api.detachRulesFromCampaign(campaignId));
	}

	public RemoteCall<Void> detachRule(String campaignId, String ruleId) {
		return RemoteCall.of(api.detachRuleFromCampaign(campaignId, ruleId));
	}

}
