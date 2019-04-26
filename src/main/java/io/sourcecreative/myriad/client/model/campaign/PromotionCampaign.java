package io.sourcecreative.myriad.client.model.campaign;

import java.util.List;

import io.sourcecreative.myriad.client.model.promotion.Tier;
import lombok.Getter;
import lombok.Singular;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class PromotionCampaign extends Campaign {
	// promotion tiers when campaign type is PROMOTION
	@Singular("tier")
	private List<Tier> promotion;

	@Override
	public CampaignType getType() {
		return CampaignType.PROMOTION;
	}
}
