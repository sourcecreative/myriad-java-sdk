package io.sourcecreative.myriad.client.model.event;

public enum Events {

	CAMPAIGN_CREATED,
	CAMPAIGN_UPDATED,
	CAMPAIGN_DELETE,
	CAMPAIGN_ENABLED,
	CAMPAIGN_DISABLED,
		
	VOUCHER_ISSUED,
	VOUCHER_DISTRIBUTED,
	VOUCHER_REDEEMED,
		
	VALIDATION_RULES_ATTACHED,
	VALIDATION_RULES_DETACHED,

	VALIDATION_PASSED,
	VALIDATION_FAILED,

	CUSTOMER_CREATED,
	CUSTOMER_UPDATED,
	CUSTOMER_DELETED,
	CUSTOMER_REWARDED,
	
	REDEMPTION_SUCCEEDED,
	REDEMPTION_FAILED,
	
	ORDER_CREATED,
	ORDER_UPDATED,
	ORDER_PAID,
	ORDER_CANCELLED,
	
	PRODUCT_CREATED,
	PRODUCT_UPDATED,
	PRODUCT_DELETED,
	
	DISTRIBUTION_SENT,
	DISTRIBUTION_FAILED;
	
	
	
}
