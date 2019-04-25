package io.sourcecreative.myriad.client.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import io.sourcecreative.myriad.client.model.campaign.CampaignResponse;
import io.sourcecreative.myriad.client.model.campaign.CampaignType;
import io.sourcecreative.myriad.client.model.campaign.LoyaltyProgramResponse;
import io.sourcecreative.myriad.client.model.campaign.PromotionCampaignResponse;
import io.sourcecreative.myriad.client.model.campaign.VoucherCampaignResponse;

public class CampaignResponseDeserializer  extends JsonDeserializer<CampaignResponse> {

	@Override
	public CampaignResponse deserialize(JsonParser jsonParser, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		
		JsonNode node = jsonParser.getCodec().readTree(jsonParser);
		// parse campaign type
		CampaignType campaignType = CampaignType.valueOf(node.get("type").asText());
		
		CampaignResponse result = null;
		
		if (campaignType.equals(CampaignType.VOUCHER)) {
			result = jsonParser.getCodec().readValue(jsonParser, VoucherCampaignResponse.class);
		} else if (campaignType.equals(CampaignType.PROMOTION)) {
			result = jsonParser.getCodec().readValue(jsonParser, PromotionCampaignResponse.class);
		} else if (campaignType.equals(CampaignType.LOYALTY)) {
			result = jsonParser.getCodec().readValue(jsonParser, LoyaltyProgramResponse.class);
		} else {
			throw new RuntimeException("Unknown Campaign Type");
		}
		
		return result;
	}

}
