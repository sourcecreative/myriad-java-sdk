package io.sourcecreative.myriad.client.model.campaign;

import java.util.Map;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
@ToString
public class AddVoucherToCampaign {
	// voucher category
	private String category;
	
	private String code;

	@Singular("metadata")
	private Map<String, Object> metadata;

}
