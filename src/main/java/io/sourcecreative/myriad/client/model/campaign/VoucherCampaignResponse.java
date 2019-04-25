package io.sourcecreative.myriad.client.model.campaign;

import java.util.List;

import io.sourcecreative.myriad.client.model.rule.RuleResponse;
import io.sourcecreative.myriad.client.model.voucher.VoucherConfig;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class VoucherCampaignResponse extends CampaignResponse {
	@NonNull
	private Integer totalSupply;

	private Integer maxSupply;
	
	@NonNull
	// voucher definition if this is a VOUCHER campaign
	private VoucherConfig voucher;
	
	// validation rules if any
	private List<RuleResponse> rules;

}
