package io.sourcecreative.myriad.client.model.campaign;

import java.util.Date;
import java.util.Map;

import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public abstract class CampaignResponse {
	@NonNull
	private String id;
	
	@NonNull
	private Date updatedAt;

	@NonNull
	private String name;

	private CampaignType type;

	private String description;
	
	@NonNull
	private CampaignStatus status;
	
	@NonNull
	private Date effective;

	private Date expiry;

	// campaign metadata if any
	private Map<String, Object> metadata;
		
}
