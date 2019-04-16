package io.sourcecreative.myriad.client.model.campaign;

import java.util.Date;
import java.util.List;
import java.util.Map;

import io.sourcecreative.myriad.client.model.promotion.TierResponse;
import io.sourcecreative.myriad.client.model.validation.RuleResponse;
import io.sourcecreative.myriad.client.model.voucher.VoucherResponse;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class CampaignResponse {
	@NonNull
	private String id;
	
	@NonNull
	private Date updatedAt;

	@NonNull
	private String name;

	private CampaignType type;

	private String description;

	private Integer totalSupply;

	private Integer maxSupply;
	
	@NonNull
	private CampaignStatus status;
	
	@NonNull
	private Date effective;

	private Date expiry;

	// voucher definition if this is a VOUCHER campaign
	private VoucherResponse voucher;
	
	// promotion definition if this is a PROMOTION campaign
	private List<TierResponse> promotion;

	// validation rules if any
	private List<RuleResponse> rules;

	// campaign metadata if any
	private Map<String, Object> metadata;
		
}
