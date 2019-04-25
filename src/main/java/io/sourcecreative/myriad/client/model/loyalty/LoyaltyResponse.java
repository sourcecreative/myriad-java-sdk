package io.sourcecreative.myriad.client.model.loyalty;

import java.util.Date;
import java.util.List;
import java.util.Map;

import io.sourcecreative.myriad.client.model.customer.CustomerResponse;
import io.sourcecreative.myriad.client.model.rule.RuleResponse;
import io.sourcecreative.myriad.client.model.voucher.CodeConfig;
import io.sourcecreative.myriad.client.model.voucher.VoucherStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class LoyaltyResponse {
	private String campaignId;

	private String code;
	
	private CodeConfig codeConfig;
		
	private int points;
	
	private int balance;
	
	// to whom the voucher was distributed
	private CustomerResponse customer;

//	  private VoucherRedemptionResponse redemption;

	private Map<String, Object> metadata;

	// reward rules if any
	private List<RuleResponse> rules;

//	private Boolean isReferralCode;

//	private String referrerId;

	private Date updatedAt;

}
