package io.sourcecreative.myriad.client.model.campaign;

import java.util.Map;

import io.sourcecreative.myriad.client.model.VoucherDefinition;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

@Getter
@Builder
@ToString
public class UpdateCampaign {
	// update campaign if and only if campaign status is DRAFT
	private CampaignType type;

	private String description;
	
	private Integer vouchersCount;
	
	private VoucherDefinition voucher;

	@Singular("metadata")
	private Map<String, Object> metadata;

}
