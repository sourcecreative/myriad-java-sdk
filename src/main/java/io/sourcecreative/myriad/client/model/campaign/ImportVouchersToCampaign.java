package io.sourcecreative.myriad.client.model.campaign;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

@Getter
@Builder
@ToString
public class ImportVouchersToCampaign {
	@Singular("voucher")
	private List<AddVoucherToCampaign> vouchers;
}
