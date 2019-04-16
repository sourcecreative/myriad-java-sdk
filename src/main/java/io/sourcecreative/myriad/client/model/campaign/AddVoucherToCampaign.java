package io.sourcecreative.myriad.client.model.campaign;

import java.util.Map;

import com.google.common.base.Strings;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

@Builder
@Getter
@ToString
public class AddVoucherToCampaign {
	// voucher can override campaign.category
	private String category;
	
	@NonNull
	private final String code;

	// client may specify voucher metadata
	@Singular("metadataEntry")
	private Map<String, Object> metadata;
	
	@Builder
	private AddVoucherToCampaign(final String code) {
		if (Strings.isNullOrEmpty(code))
			throw new IllegalArgumentException("code cannot be null or empty");
		this.code = code;
	}

}
