package io.sourcecreative.myriad.client.model.campaign;

import java.util.List;

import io.sourcecreative.myriad.client.model.promotion.Tier;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class PromotionCampaignResponse extends CampaignResponse {
	private List<Tier> promotion;

}
