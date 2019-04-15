package io.sourcecreative.myriad.client.model.campaign;

import org.junit.Test;

public class AddVoucherToCampaignTest {

	@Test(expected = IllegalArgumentException.class)
	public void test() {
		AddVoucherToCampaign.builder()
			.code("")
			.category("New Customer").build();
	}

}
