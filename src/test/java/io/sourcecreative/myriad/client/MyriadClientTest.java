package io.sourcecreative.myriad.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.jeasy.rules.api.Condition;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.mvel.MVELCondition;
import org.junit.BeforeClass;
import org.junit.Test;

import io.sourcecreative.myriad.client.model.campaign.CampaignType;
import io.sourcecreative.myriad.client.model.campaign.CouponCampaign;
import io.sourcecreative.myriad.client.model.campaign.CouponCampaignResponse;
import io.sourcecreative.myriad.client.model.voucher.CouponConfig;
import io.sourcecreative.myriad.client.model.voucher.Discount;
import okhttp3.logging.HttpLoggingInterceptor.Level;

public class MyriadClientTest {
	private static MyriadClient myriad;

	@BeforeClass
	public static void init() {
		myriad = MyriadClient.builder()
				.baseUrl("http://68bb4ace-cb7e-4124-a50a-331c0b537b4c.mock.pstmn.io")
				.appId("appid")
				.appSecret("appsecret")
				.logLevel(Level.BODY)
				.build();
	}

	@Test
	public void test() {
		Condition c = new MVELCondition("campaign.category == 'New Customer'");
//		Condition c = new MVELCondition("campaign.name == 'XMAS-PROMO'");
	
		CouponCampaign campaign = CouponCampaign.builder()
				.name("XMAS-PROMO")
				.type(CampaignType.GIFT)
				.totalSupply(100)
				.category("New Customer")
				.effective(Date.valueOf("2019-04-15"))
				.coupon(CouponConfig.builder().discount(Discount.amountOff(1000)).build()).build();

		// sync execution
		CouponCampaignResponse response = myriad.campaigns().create(campaign).send();
		assertEquals(response.getTotalSupply().intValue(), 100);
		// validate
		
		Facts facts = new Facts();
		facts.put("campaign", campaign);
		//facts.put("voucher", campaign.getVoucher());
		assertTrue(c.evaluate(facts));
	}

}
