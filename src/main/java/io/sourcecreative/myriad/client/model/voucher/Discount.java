package io.sourcecreative.myriad.client.model.voucher;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class Discount {
	private DiscountType type;
	private Integer amountOff;
	private Double percentOff;
	private Integer amountLimit;
	private Double unitOff;
	private String unitType;

	public static Discount from(DiscountType type, int value) {
		Discount discount = new Discount();
		discount.type = type;
		switch (type) {
		case AMOUNT:
			discount.amountOff = value;
			break;
		case PERCENT:
			discount.percentOff = value / 100.0;
			break;
		case UNIT:
			discount.unitOff = value / 100.0;
			break;
		default:
			throw new IllegalArgumentException("Unsupported discount type: " + type);
		}
		return discount;
	}

	public static Discount amountOff(int amountOff) {
		Discount discount = new Discount();
		discount.type = DiscountType.AMOUNT;
		discount.amountOff = amountOff;
		return discount;
	}

	public static Discount percentOff(double percentOff) {
		return percentOff(percentOff, null);
	}

	public static Discount percentOff(double percentOff, Integer amountLimit) {
		Discount discount = new Discount();
		discount.type = DiscountType.PERCENT;
		discount.percentOff = percentOff;
		discount.amountLimit = amountLimit;

		return discount;
	}

	public static Discount unitOff(double unitOff) {
		Discount discount = new Discount();
		discount.type = DiscountType.UNIT;
		discount.unitOff = unitOff;
		return discount;
	}

	public static Discount unitOff(double unitOff, String unitType) {
		Discount discount = new Discount();
		discount.type = DiscountType.UNIT;
		discount.unitOff = unitOff;
		discount.unitType = unitType;
		return discount;
	}

}
