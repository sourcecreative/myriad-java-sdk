package io.sourcecreative.myriad.client.model;

import io.sourcecreative.myriad.client.model.voucher.CodeConfig;
import io.sourcecreative.myriad.client.model.voucher.Discount;
import io.sourcecreative.myriad.client.model.voucher.VoucherType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
@ToString
public class VoucherDefinition {
	private VoucherType type;
	
	// when type is COUPON
	private Discount discount;

	// max redemption quantity
	@Builder.Default
	private Integer redemption = 1;

	private CodeConfig codeConfig;

}
