package io.sourcecreative.myriad.client.model.campaign;

import io.sourcecreative.myriad.client.model.PatchAction;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class ActivateCampaign {
	private final PatchAction op = PatchAction.REPLACE;
	
	private final String path = "/status";
	
	private CampaignStatus value;

	private boolean activated;
	
	public static ActivateCampaign of(boolean activated) {
		ActivateCampaign ac = new ActivateCampaign();
		ac.value = activated?CampaignStatus.ACTIVE:CampaignStatus.INACTIVE;
		ac.activated = activated;
		return ac;
	}
}
