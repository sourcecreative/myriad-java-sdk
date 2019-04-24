package io.sourcecreative.myriad.client.module;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.sourcecreative.myriad.client.api.MyriadApi;

public class DistributionService extends Service {

	DistributionService(MyriadApi api, ObjectMapper objectMapper) {
		super(api, objectMapper);
	}

}
