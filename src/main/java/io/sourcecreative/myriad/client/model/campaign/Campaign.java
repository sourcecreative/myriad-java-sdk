package io.sourcecreative.myriad.client.model.campaign;

import java.util.Date;
import java.util.List;
import java.util.Map;

import io.sourcecreative.myriad.client.model.promotion.Tier;
import io.sourcecreative.myriad.client.model.voucher.VoucherConfig;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Campaign {
	// campaign name
	@NonNull
	private String name;
	
	@NonNull
	private CampaignType type;

	private String description;

	// total supply of vouchers
	@NonNull
	private Integer totalSupply;
	
	// if maxSupply is provided, this is the maximum number of vouchers
	// that can be minted. maxSupply=null means unlimited supply
	private Integer maxSupply;
		
	private String category;

	@NonNull
	private Date effective;

	private Date expiry;

	// voucher definition
	private VoucherConfig voucher;
	
	// promotion tiers when campaign type is PROMOTION
	@Singular("tier")
	private List<Tier> promotion;
	
	@Singular("metadataEntry")
	private Map<String, Object> metadata;

}
