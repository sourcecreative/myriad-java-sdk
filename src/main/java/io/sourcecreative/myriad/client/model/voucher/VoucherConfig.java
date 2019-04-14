package io.sourcecreative.myriad.client.model.voucher;

import java.util.Date;

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
public class VoucherConfig {
	private VoucherType type;

	// the category the voucher belongs to
	private String category;
	
	// when type is COUPON
	private Discount discount;

	private Date effective;

	private Date expiry;

	// max redemption quantity
	private Integer redemption;

	private CodeConfig codeConfig;

}
