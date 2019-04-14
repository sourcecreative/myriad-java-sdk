package io.sourcecreative.myriad.client.model.campaign;

import java.util.Date;
import java.util.Map;

import io.sourcecreative.myriad.client.model.voucher.VoucherConfig;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class CampaignResponse {
	private String id;
	
	private String name;

	private CampaignType type;

	private String description;

	private Integer vouchersCount;

	private VoucherConfig voucher;

	private Map<String, Object> metadata;

	private CampaignStatus status;

	private Date updatedAt;
		
}
