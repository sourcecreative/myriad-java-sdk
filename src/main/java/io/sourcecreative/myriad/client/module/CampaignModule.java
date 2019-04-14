package io.sourcecreative.myriad.client.module;

import java.io.IOException;

import io.sourcecreative.myriad.client.api.APIError;
import io.sourcecreative.myriad.client.api.MyriadApi;
import io.sourcecreative.myriad.client.model.campaign.CampaignResponse;
import io.sourcecreative.myriad.client.model.campaign.CreateCampaign;
import io.sourcecreative.myriad.client.module.CampaignModule.ExtAsync;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CampaignModule extends Module<ExtAsync> {
	
	public CampaignModule(MyriadApi api) {
		super(api);
	}
	
	public CampaignResponse create(CreateCampaign createCampaign) {
		Call<CampaignResponse> call = api.createCampaign(createCampaign);
		try {
			Response<CampaignResponse> response = call.execute();
			return response.body(); 			
		} catch(IOException e) {
			throw APIError.builder().code(500)
				.message("Server error")
				.details(e.getMessage())
				.build();
		} 
	}
	
	public class ExtAsync extends Module.Async {
		
		public void create(CreateCampaign createCampaign, Callback<CampaignResponse> callback) {
			api.createCampaign(createCampaign).enqueue(callback);
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
