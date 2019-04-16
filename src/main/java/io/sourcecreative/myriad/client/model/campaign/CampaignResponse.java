package io.sourcecreative.myriad.client.model.campaign;

import java.util.Date;
import java.util.List;
import java.util.Map;

import io.sourcecreative.myriad.client.model.VoucherDefinition;
import io.sourcecreative.myriad.client.model.validation.RuleResponse;
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
	private String name;

	private CampaignType type;

	private String description;

	@NonNull
	private Integer fixedCount;

	private VoucherDefinition voucher;

	private Map<String, Object> metadata;

	private CampaignStatus status;

	// validation rules
	private List<RuleResponse> rules;


	private Date updatedAt;
		
}
