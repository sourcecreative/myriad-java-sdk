package io.sourcecreative.myriad.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.mvel.MVELRule;
import org.junit.BeforeClass;
import org.junit.Test;

import io.sourcecreative.myriad.client.model.campaign.CampaignResponse;
import io.sourcecreative.myriad.client.model.campaign.CampaignType;
import io.sourcecreative.myriad.client.model.campaign.CouponCampaign;
import io.sourcecreative.myriad.client.model.campaign.VoucherCampaign;
import io.sourcecreative.myriad.client.model.campaign.VoucherCampaignResponse;
import io.sourcecreative.myriad.client.model.rule.Rule;
import io.sourcecreative.myriad.client.model.voucher.Discount;
import io.sourcecreative.myriad.client.model.voucher.VoucherType;
import okhttp3.logging.HttpLoggingInterceptor.Level;

public class MyriadClientTest {
	private static MyriadClient myriad;

	@BeforeClass
	public static void init() {
		myriad = MyriadClient.create(ConnectionConfig.builder()
				.baseUrl("http://68bb4ace-cb7e-4124-a50a-331c0b537b4c.mock.pstmn.io")
				.appId("appid")
				.appSecret("appsecret")
				.logLevel(Level.BODY)
				.build());
	}

	@Test
	public void test() {
//		Condition c = new MVELCondition("campaign.name == 'XMAS-PROMO'");
	
		VoucherCampaign campaign = CouponCampaign.builder()
				.name("XMAS-PROMO")
				.totalSupply(100)
				.category("New Customer")
				.effective(Date.valueOf("2019-04-15"))
				.discount(Discount.amountOff(1000))
				.rule(Rule.builder()
						.name("total order amount limit")
						.condition("amount >= 30")
						.build())
				.build();
		
		// sync execution
		VoucherCampaignResponse response = (VoucherCampaignResponse)myriad.campaigns().create(campaign).send();
		assertEquals(response.getVoucherType(), VoucherType.COUPON);
		assertEquals(response.getDiscount().getAmountOff().intValue(), 100);

		// validate
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
		facts.put("amount", 100);
		rulesEngine.check(rules, facts).forEach((k,v)->{
			assertTrue(v);
		});
	}

}
