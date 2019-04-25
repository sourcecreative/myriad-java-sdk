package io.sourcecreative.myriad.client.model.campaign;

import java.util.List;

import io.sourcecreative.myriad.client.model.rule.RuleResponse;
import io.sourcecreative.myriad.client.model.voucher.CouponConfig;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class CouponCampaignResponse extends CampaignResponse {
	@NonNull
	private Integer totalSupply;

	private Integer maxSupply;
	
	@NonNull
	// voucher definition if this is a VOUCHER campaign
	private CouponConfig voucher;
	
	// validation rules if any
	private List<RuleResponse> rules;

}
