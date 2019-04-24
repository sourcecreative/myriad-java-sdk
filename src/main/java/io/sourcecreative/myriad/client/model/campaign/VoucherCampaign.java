package io.sourcecreative.myriad.client.model.campaign;

import io.sourcecreative.myriad.client.model.voucher.VoucherConfig;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class VoucherCampaign extends Campaign {
	// total supply of vouchers
	@NonNull
	private Integer totalSupply;
	
	// if maxSupply is provided, this is the maximum number of vouchers
	// that can be minted. maxSupply=null means unlimited supply
	private Integer maxSupply;
		
	// voucher definition
	private VoucherConfig voucher;

}
