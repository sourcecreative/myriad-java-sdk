package io.sourcecreative.myriad.client.model.campaign;

import java.util.Map;

import io.sourcecreative.myriad.client.model.voucher.VoucherConfig;
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
public class CreateCampaign {
	// campaign name
	private String name;
	
	private CampaignType type;

	private String description;

	private Integer vouchersCount;

	private VoucherConfig voucher;

	@Singular("metadata")
	private Map<String, Object> metadata;

}
