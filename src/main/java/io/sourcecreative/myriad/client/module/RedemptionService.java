package io.sourcecreative.myriad.client.module;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.sourcecreative.myriad.client.api.MyriadApi;
import io.sourcecreative.myriad.client.model.redemption.PaginatedRedemptionsResponse;
import io.sourcecreative.myriad.client.model.redemption.RedeemVoucher;
import io.sourcecreative.myriad.client.model.redemption.RedeemVouchers;
import io.sourcecreative.myriad.client.model.redemption.RedemptionResponse;
import io.sourcecreative.myriad.client.model.redemption.RedemptionsResponse;

public class RedemptionService extends Service {

	RedemptionService(MyriadApi api, ObjectMapper objectMapper) {
		super(api, objectMapper);
	}
	
	public RemoteCall<RedemptionResponse> redeem(RedeemVoucher redeemVoucher) {
		return RemoteCall.of(api.redeemVoucher(redeemVoucher));
	}
	
	public RemoteCall<RedemptionsResponse> redeem(RedeemVouchers redeemVouchers) {
		return RemoteCall.of(api.redeemVouchers(redeemVouchers));
	}

	public RemoteCall<RedemptionResponse> findById(String redemptionId) {
		return RemoteCall.of(api.getRedemption(redemptionId));
	}
	
	public RemoteCall<PaginatedRedemptionsResponse> list(Map<String, Object> filter) {
		return RemoteCall.of(api.listRedemptions(filter));
	}
	
	public RemoteCall<PaginatedRedemptionsResponse> listByVoucher(String voucherId, Map<String, Object> filter) {
		return RemoteCall.of(api.listRedemptionsByVoucher(voucherId, filter));
	}
	
}
