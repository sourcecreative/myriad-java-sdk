package io.sourcecreative.myriad.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.jeasy.rules.api.Condition;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.mvel.MVELCondition;
import org.junit.Test;

import io.sourcecreative.myriad.client.model.campaign.Campaign;
import io.sourcecreative.myriad.client.model.campaign.CampaignResponse;
import io.sourcecreative.myriad.client.model.campaign.CampaignType;
import io.sourcecreative.myriad.client.model.voucher.VoucherConfig;
import okhttp3.logging.HttpLoggingInterceptor.Level;

public class MyriadClientTest {

	@Test
	public void test() {
		MyriadClient myriad = MyriadClient.builder()
				.baseUrl("http://72ec40ea-aeb2-43bb-9627-94f0f35e6c06.mock.pstmn.io")
				.appId("appid")
				.appSecret("appsecret")
				.logLevel(Level.BODY)
				.build();
						
		Condition c = new MVELCondition("campaign.category == 'New Customer'");
//		Condition c = new MVELCondition("campaign.name == 'XMAS-PROMO'");
	
		Campaign campaign = Campaign.builder()
				.name("XMAS-PROMO")
				.type(CampaignType.VOUCHER)
				.totalSupply(100)
				.category("New Customer")
				.effective(Date.valueOf("2019-04-15"))
				.voucher(VoucherConfig.builder().build()).build();

		// sync execution
		CampaignResponse response = myriad.campaigns().create(campaign).send();
		assertNotNull(response.getId());
		// validate
		
		Facts facts = new Facts();
		facts.put("campaign", campaign);
		//facts.put("voucher", campaign.getVoucher());
		assertTrue(c.evaluate(facts));
	}

}
