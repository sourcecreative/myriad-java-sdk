package io.sourcecreative.myriad.client.module;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.sourcecreative.myriad.client.api.MyriadApi;
import io.sourcecreative.myriad.client.model.distribution.DistributeOneOffVouchers;
import io.sourcecreative.myriad.client.model.distribution.DistributeVouchers;
import io.sourcecreative.myriad.client.model.distribution.DistributeVouchersBySegment;
import io.sourcecreative.myriad.client.model.distribution.DistributionsResponse;
import io.sourcecreative.myriad.client.model.distribution.PaginatedDistributionsResponse;

public class DistributionService extends Service {

	DistributionService(MyriadApi api, ObjectMapper objectMapper) {
		super(api, objectMapper);
	}

	public RemoteCall<DistributionsResponse> distribute(DistributeVouchers distributeVouchers) {
		return RemoteCall.of(api.distributeVouchers(distributeVouchers));
	}

	public RemoteCall<PaginatedDistributionsResponse> distributeBySegment(DistributeVouchersBySegment distributionRequest) {
		return RemoteCall.of(api.distributeVouchersBySegment(distributionRequest));
	}
	
	public RemoteCall<DistributionsResponse> distribute(DistributeOneOffVouchers oneOffVouchers) {
		return RemoteCall.of(api.distributeOneOffVouchers(oneOffVouchers));
	}
	
	public RemoteCall<PaginatedDistributionsResponse> list(Map<String,Object> filter) {
		return RemoteCall.of(api.listDistributions(filter));
	}

}
