package io.sourcecreative.myriad.client.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import io.sourcecreative.myriad.client.model.campaign.CampaignResponse;
import io.sourcecreative.myriad.client.model.campaign.CampaignType;
import io.sourcecreative.myriad.client.model.campaign.CouponCampaignResponse;
import io.sourcecreative.myriad.client.model.campaign.GiftCampaignResponse;
import io.sourcecreative.myriad.client.model.campaign.LoyaltyProgramResponse;
import io.sourcecreative.myriad.client.model.campaign.PrepaidCardCampaignResponse;
import io.sourcecreative.myriad.client.model.campaign.PromotionCampaignResponse;

public class CampaignResponseDeserializer  extends JsonDeserializer<CampaignResponse> {

	@Override
	public CampaignResponse deserialize(JsonParser jsonParser, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		
		JsonNode node = jsonParser.getCodec().readTree(jsonParser);
		
		// parse campaign type
		CampaignType campaignType = CampaignType.valueOf(node.get("type").asText());
		
		CampaignResponse result = null;
		
		if (campaignType.equals(CampaignType.COUPON)) {
			result = jsonParser.getCodec().readValue(jsonParser, CouponCampaignResponse.class);
		} else if (campaignType.equals(CampaignType.PROMOTION)) {
			result = jsonParser.getCodec().readValue(jsonParser, PromotionCampaignResponse.class);
		} else if (campaignType.equals(CampaignType.LOYALTY)) {
			result = jsonParser.getCodec().readValue(jsonParser, LoyaltyProgramResponse.class);
		} else if (campaignType.equals(CampaignType.GIFT)){
			result = jsonParser.getCodec().readValue(jsonParser, GiftCampaignResponse.class);
		} else if (campaignType.equals(CampaignType.PREPAID)) {
			result = jsonParser.getCodec().readValue(jsonParser, PrepaidCardCampaignResponse.class);			
		} else {
			throw new RuntimeException("Unsupported campaign type");
		}
		
		return result;
	}

}
