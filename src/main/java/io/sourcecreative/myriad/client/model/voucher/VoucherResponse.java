package io.sourcecreative.myriad.client.model.voucher;

import java.util.Date;
import java.util.List;
import java.util.Map;

import io.sourcecreative.myriad.client.model.rule.RuleResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class VoucherResponse {
	private String campaignId;

	private String code;
	
	private VoucherConfig config;
	
	private VoucherStatus status;
	
	private int redeemedQuantity;
	
	// to whom the voucher was distributed

//	  private VoucherRedemptionResponse redemption;
	//
	private int rulesCount;

	private Map<String, Object> metadata;

	// validation rules if any
	private List<RuleResponse> rules;

//	private Boolean isReferralCode;

//	private String referrerId;

	private Date updatedAt;

}
