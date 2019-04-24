package io.sourcecreative.myriad.client.module;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.sourcecreative.myriad.client.api.MyriadApi;

public class VoucherService extends Service {

	VoucherService(MyriadApi api, ObjectMapper objectMapper) {
		super(api, objectMapper);
	}

}
