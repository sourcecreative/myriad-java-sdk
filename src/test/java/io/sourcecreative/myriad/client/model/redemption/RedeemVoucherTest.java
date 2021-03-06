package io.sourcecreative.myriad.client.model.redemption;

import static org.junit.Assert.assertEquals;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.mvel.MVELRule;
import org.junit.BeforeClass;
import org.junit.Test;

import io.sourcecreative.myriad.client.ConnectionConfig;
import io.sourcecreative.myriad.client.MyriadClient;
import io.sourcecreative.myriad.client.model.campaign.VoucherCampaignResponse;
import io.sourcecreative.myriad.client.model.customer.Customer;
import io.sourcecreative.myriad.client.model.voucher.CreateVoucher;
import io.sourcecreative.myriad.client.model.voucher.VoucherResponse;
import okhttp3.logging.HttpLoggingInterceptor.Level;

public class RedeemVoucherTest {
	private MyriadClient myriad;
	private VoucherCampaignResponse campaign;
	
	@BeforeClass
	public void init() {
		myriad = MyriadClient.create(ConnectionConfig.builder()
				.baseUrl("http://68bb4ace-cb7e-4124-a50a-331c0b537b4c.mock.pstmn.io")
				.appId("appid")
				.appSecret("appsecret")
				.logLevel(Level.BODY)
				.build());
		campaign = (VoucherCampaignResponse)myriad.campaigns().findById("1").send();
	}
	
	@Test
	public void test() {
		// create a voucher
		CreateVoucher createVoucher = CreateVoucher.builder()
				.campaignId("1")
				.code("ABCDEF")
				.build();
		VoucherResponse voucher = myriad.vouchers().create(createVoucher).send();
		assertEquals(voucher.getCampaignId(), "1");
		
		// create request
		RedeemVoucher redeemVoucher = RedeemVoucher.builder()
			.voucherCode("ABCDEF")
			.customer(Customer.builder().sourceId("123456").build())
			.order(Order.builder().amount(12000).metadataEntry("sku", "sku0009").build())
			.build();
		
		//List<Rule> voucher.getRules()
		
		Rules rules = new Rules();
		campaign.getRules().forEach(r->{
			rules.register(new MVELRule()
					.name(r.getName())
					.description(r.getDescription())
					.priority(r.getPriority())
					.when(r.getCondition()));
		});
		RulesEngine rulesEngine = new DefaultRulesEngine();
		Facts facts = new Facts();
		facts.put("redemption", redeemVoucher);
		rulesEngine.check(rules, facts);
		
	}
	
}
