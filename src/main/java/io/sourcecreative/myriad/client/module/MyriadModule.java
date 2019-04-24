package io.sourcecreative.myriad.client.module;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.sourcecreative.myriad.client.api.MyriadApi;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

public class MyriadModule {
	@Getter
	private CampaignService campaignService;
	
	@Getter
	private VoucherService voucherService;
	
	@Getter
	private CustomerService customerService;
	
	@Getter
	private DistributionService distributionService;
	
	@Getter
	private RedemptionService redemptionService;
	
	@Builder
	private MyriadModule(@NonNull MyriadApi myriadApi, @NonNull ObjectMapper objectMapper) {
		init(myriadApi,objectMapper);
	}
	
	private void init(MyriadApi myriadApi, ObjectMapper objectMapper) {
		// init services
		campaignService = new CampaignService(myriadApi, objectMapper);
		voucherService = new VoucherService(myriadApi, objectMapper);
		customerService = new CustomerService(myriadApi, objectMapper);
	}
	
}
