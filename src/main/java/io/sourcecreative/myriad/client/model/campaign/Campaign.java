package io.sourcecreative.myriad.client.model.campaign;

import java.util.Date;
import java.util.Map;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@SuperBuilder
@ToString
abstract public class Campaign {
	// campaign name
	@NonNull
	private String name;
	
	private String description;

	private String category;

	@NonNull
	private Date effective;

	private Date expiry;
	
	@Singular("metadataEntry")
	private Map<String, Object> metadata;
	
	public abstract CampaignType getType();

}
