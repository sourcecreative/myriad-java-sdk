package io.sourcecreative.myriad.client.model.campaign;

import java.util.Date;
import java.util.Map;

import lombok.Getter;
import lombok.Singular;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
abstract public class UpdateCampaign {

	private String description;
		
	private String category;
	
	private Date effective;

	private Date expiry;
		
	@Singular("metadataEntry")
	private Map<String, Object> metadata;

}
