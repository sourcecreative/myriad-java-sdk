package io.sourcecreative.myriad.client.model.campaign;

import java.util.List;

import io.sourcecreative.myriad.client.model.promotion.Tier;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class PromotionCampaignResponse extends CampaignResponse {
	private List<Tier> promotion;

}
