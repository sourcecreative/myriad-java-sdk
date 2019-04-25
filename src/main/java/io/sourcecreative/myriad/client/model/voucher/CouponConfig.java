package io.sourcecreative.myriad.client.model.voucher;

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
public class CouponConfig {
	@NonNull
	private Discount discount;

	// max redemption quantity
	@Builder.Default
	private Integer redemption = 1;

	private CodeConfig codeConfig;

}
