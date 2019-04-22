package io.sourcecreative.myriad.client;

import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.jeasy.rules.api.Condition;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.mvel.MVELCondition;
import org.junit.Test;

import io.sourcecreative.myriad.client.model.campaign.Campaign;
import io.sourcecreative.myriad.client.model.campaign.CampaignResponse;
import io.sourcecreative.myriad.client.model.voucher.VoucherConfig;

public class MyriadClientTest {

	@Test
	public void test() {
		MyriadClient myriad = MyriadClient.builder().build();
						
		Condition c = new MVELCondition("campaign.category == 'New Customer'");
//		Condition c = new MVELCondition("campaign.name == 'XMAS-PROMO'");
	
		Campaign campaign = Campaign.builder()
				.name("XMAS-PROMO")
				.category("New Customer")
				.effective(Date.valueOf("2019-04-15"))
				.voucher(VoucherConfig.builder().build()).build();

		// sync execution
		//CampaignResponse response = myriad.campaigns().create(campaign).send();

		// validate
		
		Facts facts = new Facts();
		facts.put("campaign", campaign);
		//facts.put("voucher", campaign.getVoucher());
		assertTrue(c.evaluate(facts));
	}

}
