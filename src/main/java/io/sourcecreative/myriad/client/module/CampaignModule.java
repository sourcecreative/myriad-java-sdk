package io.sourcecreative.myriad.client.module;

import java.util.Map;

import io.sourcecreative.myriad.client.api.MyriadApi;
import io.sourcecreative.myriad.client.model.campaign.ActivateCampaign;
import io.sourcecreative.myriad.client.model.campaign.AddRulesToCampaignResponse;
import io.sourcecreative.myriad.client.model.campaign.AddVoucherToCampaign;
import io.sourcecreative.myriad.client.model.campaign.CampaignResponse;
import io.sourcecreative.myriad.client.model.campaign.CreateCampaign;
import io.sourcecreative.myriad.client.model.campaign.ImportVouchersToCampaign;
import io.sourcecreative.myriad.client.model.campaign.PaginatedCampaignsResponse;
import io.sourcecreative.myriad.client.model.campaign.UpdateCampaign;
import io.sourcecreative.myriad.client.model.validation.AddRules;
import io.sourcecreative.myriad.client.module.CampaignModule.ExtAsync;
import retrofit2.Callback;

public class CampaignModule extends Module<ExtAsync> {

	public CampaignModule(MyriadApi api) {
		super(api);
	}

	public CampaignResponse create(CreateCampaign createCampaign) {
		return new ExecutionHandler<CampaignResponse>().handle(api.createCampaign(createCampaign));
	}

	public CampaignResponse addVoucher(String campaignId, AddVoucherToCampaign addVoucher) {
		return new ExecutionHandler<CampaignResponse>().handle(api.addVoucherToCampaign(campaignId, addVoucher));
	}

	public CampaignResponse findById(String campaignId) {
		return new ExecutionHandler<CampaignResponse>().handle(api.getCampaign(campaignId));
	}

	public PaginatedCampaignsResponse list(Map<String, Object> filter) {
		return new ExecutionHandler<PaginatedCampaignsResponse>().handle(api.listCampaigns(filter));
	}

	public CampaignResponse update(String campaignId, UpdateCampaign updateCampaign) {
		return new ExecutionHandler<CampaignResponse>().handle(api.updateCampaign(campaignId, updateCampaign));
	}

	public CampaignResponse activate(String campaignId, ActivateCampaign activateCampaign) {
		return new ExecutionHandler<CampaignResponse>().handle(api.activateCampaign(campaignId, activateCampaign));
	}

	public Void delete(String campaignId) {
		return new ExecutionHandler<Void>().handle(api.deleteCampaign(campaignId));
	}

	public CampaignResponse importVouchers(String campaignId, ImportVouchersToCampaign importVouchers) {
		return new ExecutionHandler<CampaignResponse>()
				.handle(api.importVouchersToCampaign(campaignId, importVouchers));
	}

	public AddRulesToCampaignResponse attachRules(String campaignId, AddRules addRules) {
		return new ExecutionHandler<AddRulesToCampaignResponse>()
				.handle(api.attachRulesToCampaign(campaignId, addRules));
	}

	public Void detachRules(String campaignId) {
		return new ExecutionHandler<Void>().handle(api.detachRulesFromCampaign(campaignId));
	}

	public Void detachRule(String campaignId, String ruleId) {
		return new ExecutionHandler<Void>().handle(api.detachRuleFromCampaign(campaignId, ruleId));
	}

	public class ExtAsync extends Module.Async {

		public void create(CreateCampaign createCampaign, Callback<CampaignResponse> callback) {
			api.createCampaign(createCampaign).enqueue(callback);
		}
		
		public void addVoucher(String campaignId, AddVoucherToCampaign addVoucher, 
				Callback<CampaignResponse> callback) {
			api.addVoucherToCampaign(campaignId, addVoucher).enqueue(callback);
		}

		public void findById(String campaignId, Callback<CampaignResponse> cb) {
			api.getCampaign(campaignId).enqueue(cb);
		}

		public void list(Map<String, Object> filter, Callback<PaginatedCampaignsResponse> cb) {
			api.listCampaigns(filter).enqueue(cb);
		}

		public void update(String campaignId, UpdateCampaign updateCampaign, Callback<CampaignResponse> cb) {
			api.updateCampaign(campaignId, updateCampaign).enqueue(cb);
		}

		public void activate(String campaignId, ActivateCampaign activateCampaign, Callback<CampaignResponse> cb) {
			api.activateCampaign(campaignId, activateCampaign).enqueue(cb);
		}

		public void delete(String campaignId, Callback<Void> cb) {
			api.deleteCampaign(campaignId).enqueue(cb);
		}

		public void importVouchers(String campaignId, ImportVouchersToCampaign importVouchers, 
				Callback<CampaignResponse> cb) {
			api.importVouchersToCampaign(campaignId, importVouchers).enqueue(cb);
		}

		public void attachRules(String campaignId, AddRules addRules, Callback<AddRulesToCampaignResponse> cb) {
			api.attachRulesToCampaign(campaignId, addRules).enqueue(cb);
		}

		public void detachRules(String campaignId, Callback<Void> cb) {
			api.detachRulesFromCampaign(campaignId).enqueue(cb);
		}

		public void detachRule(String campaignId, String ruleId, Callback<Void> cb) {
			api.detachRuleFromCampaign(campaignId, ruleId).enqueue(cb);
		}

	}

	@Override
	ExtAsync newAsync() {
		return new ExtAsync();
	}

	@Override
	public ExtAsync async() {
		return extAsync;
	}

}
