package io.sourcecreative.myriad.client.model.campaign;

import java.util.Date;
import java.util.List;
import java.util.Map;

import io.sourcecreative.myriad.client.model.promotion.Tier;
import io.sourcecreative.myriad.client.model.voucher.Voucher;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

@Getter
@Builder
@ToString
public class UpdateCampaign {

	private CampaignType type;

	private String description;
	
	private Integer totalSupply;
	
	private Boolean mintable;
	
	private String category;
	
	private Date effective;

	private Date expiry;
	
	private Voucher voucher;
	
	@Singular("tier")
	private List<Tier> promotion;

	@Singular("metadataEntry")
	private Map<String, Object> metadata;

}
