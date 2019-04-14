package io.sourcecreative.myriad.client.model.campaign;

import io.sourcecreative.myriad.client.model.PatchAction;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ActivateCampaign {
	private PatchAction op = PatchAction.REPLACE;
	
	private String path = "/status";
	
	private CampaignStatus value;

	private boolean activated;
	
	@Builder
	public static ActivateCampaign of(boolean activated) {
		ActivateCampaign ac = new ActivateCampaign();
		ac.value = activated?CampaignStatus.ACTIVE:CampaignStatus.INACTIVE;
		return ac;
	}
}
