package io.sourcecreative.myriad.client.model.campaign;

import java.util.List;

import io.sourcecreative.myriad.client.model.rule.RuleResponse;
import io.sourcecreative.myriad.client.model.voucher.CouponConfig;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Singular;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class CouponCampaign extends Campaign {
	// total supply of vouchers
	@NonNull
	private Integer totalSupply;
	
	// if maxSupply is provided, this is the maximum number of vouchers
	// that can be minted. maxSupply=null means unlimited supply
	private Integer maxSupply;
		
	// voucher definition
	private CouponConfig coupon;
	
	@Builder.Default
	private final CampaignType type = CampaignType.COUPON;

	// redemption rules if any
	@Singular("rule")
	private List<RuleResponse> rules;
	
}
