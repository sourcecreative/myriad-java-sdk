package io.sourcecreative.myriad.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.jeasy.rules.api.Condition;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.mvel.MVELCondition;
import org.junit.Test;

import io.sourcecreative.myriad.client.model.campaign.CampaignType;
import io.sourcecreative.myriad.client.model.campaign.VoucherCampaign;
import io.sourcecreative.myriad.client.model.campaign.VoucherCampaignResponse;
import io.sourcecreative.myriad.client.model.voucher.VoucherConfig;
import io.sourcecreative.myriad.client.model.voucher.VoucherType;
import okhttp3.logging.HttpLoggingInterceptor.Level;

public class MyriadClientTest {

	@Test
	public void test() {
		MyriadClient myriad = MyriadClient.builder()
				.baseUrl("http://68bb4ace-cb7e-4124-a50a-331c0b537b4c.mock.pstmn.io")
				.appId("appid")
				.appSecret("appsecret")
				.logLevel(Level.BODY)
				.build();
						
		Condition c = new MVELCondition("campaign.category == 'New Customer'");
//		Condition c = new MVELCondition("campaign.name == 'XMAS-PROMO'");
	
		VoucherCampaign campaign = VoucherCampaign.builder()
				.name("XMAS-PROMO")
				.type(CampaignType.VOUCHER)
				.totalSupply(100)
				.category("New Customer")
				.effective(Date.valueOf("2019-04-15"))
				.voucher(VoucherConfig.builder().type(VoucherType.COUPON).build()).build();

		// sync execution
		VoucherCampaignResponse response = myriad.campaigns().create(campaign).send();
		assertEquals(response.getTotalSupply().intValue(), 100);
		// validate
		
		Facts facts = new Facts();
		facts.put("campaign", campaign);
		//facts.put("voucher", campaign.getVoucher());
		assertTrue(c.evaluate(facts));
	}

}
