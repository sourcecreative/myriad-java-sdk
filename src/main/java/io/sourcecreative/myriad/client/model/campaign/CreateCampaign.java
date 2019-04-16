package io.sourcecreative.myriad.client.model.campaign;

import java.util.Date;
import java.util.List;
import java.util.Map;

import io.sourcecreative.myriad.client.model.Tier;
import io.sourcecreative.myriad.client.model.VoucherDefinition;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

@Getter
@Builder
@ToString
public class CreateCampaign {
	// campaign name
	@NonNull
	private String name;
	
	@NonNull
	private CampaignType type;

	private String description;

	// total supply of vouchers
	// Null means unlimited
	private Integer totalSupply;
	
	// if voucher supply is unlimited, voucher is always mintable
	@NonNull @Builder.Default
	private Boolean mintable = true;
	
	private String category;

	@NonNull
	private Date effective;

	private Date expiry;

	// voucher definition
	private VoucherDefinition voucher;
	
	// promotion tiers when campaign type is PROMOTION
	@Singular("tier")
	private List<Tier> promotion;
	
	@Singular("metadataEntry")
	private Map<String, Object> metadata;

}
