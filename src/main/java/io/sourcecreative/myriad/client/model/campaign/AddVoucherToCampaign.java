package io.sourcecreative.myriad.client.model.campaign;

import java.util.Map;

import com.google.common.base.Strings;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@ToString
public class AddVoucherToCampaign {
	// voucher category
	private String category;
	
	private String code;

	@Singular("metadata")
	private Map<String, Object> metadata;
	
	@Builder
	private AddVoucherToCampaign(final String code) {
		if (Strings.isNullOrEmpty(code))
			throw new IllegalArgumentException("code cannot be null or empty");
		this.code = code;
	}

}
