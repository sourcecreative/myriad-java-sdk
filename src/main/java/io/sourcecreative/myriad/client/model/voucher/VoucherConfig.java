package io.sourcecreative.myriad.client.model.voucher;

import java.math.BigDecimal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
@ToString
public class VoucherConfig {
	@NonNull
	private VoucherType voucherType;
	
	// max redemption quantity
	@Builder.Default
	private Integer redemption = 1;

	private CodeConfig codeConfig;
			
	// discount for DISCOUNT voucher
	private Discount discount;

	// prepaid card value
	private BigDecimal amount;


}
