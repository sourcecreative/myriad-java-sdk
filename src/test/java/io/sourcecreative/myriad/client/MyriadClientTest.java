package io.sourcecreative.myriad.client;

import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.jeasy.rules.api.Condition;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.mvel.MVELCondition;
import org.junit.Test;

import io.sourcecreative.myriad.client.model.VoucherDefinition;
import io.sourcecreative.myriad.client.model.campaign.ActivateCampaign;
import io.sourcecreative.myriad.client.model.campaign.CreateCampaign;

public class MyriadClientTest {

	@Test
	public void test() {
		//MyriadClient myriad = MyriadClient.builder().build();
//		myriad.campaigns().async().create(createCampaign, callback);
		System.out.println(ActivateCampaign.of(false).toString());
		//AddVoucherToCampaign.builder().code("").build();
		//AddRulesToCampaignResponse.;
		//fail("Not yet implemented");
		
		Condition c = new MVELCondition("campaign.category == 'New Customer'");
//		Condition c = new MVELCondition("campaign.name == 'XMAS-PROMO'");
		CreateCampaign campaign = CreateCampaign.builder()
				.name("XMAS-PROMO")
				.category("New Customer")
				.effective(Date.valueOf("2019-04-15"))
				.voucher(VoucherDefinition.builder().build()).build();
		System.out.println(campaign.getVoucher());
		Facts facts = new Facts();
		facts.put("campaign", campaign);
		//facts.put("voucher", campaign.getVoucher());
		assertTrue(c.evaluate(facts));
	}

}
