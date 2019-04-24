package io.sourcecreative.myriad.client.model.campaign;

import java.util.List;

import io.sourcecreative.myriad.client.model.promotion.Tier;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@ToString
public class UpdatePromotionCampaign extends UpdateCampaign {
	@Singular("tier")
	private List<Tier> promotion;


}
