package io.sourcecreative.myriad.client.module;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.sourcecreative.myriad.client.api.MyriadApi;
import io.sourcecreative.myriad.client.model.registration.Registration;
import io.sourcecreative.myriad.client.model.registration.RegistrationResponse;

public class RegistrationService extends Service {

	RegistrationService(MyriadApi api, ObjectMapper objectMapper) {
		super(api, objectMapper);
	}

	public RemoteCall<RegistrationResponse> register(Registration registration) {
		return RemoteCall.of(api.register(registration));
	}
	
	public RemoteCall<Void> delete(String regId) {
		return RemoteCall.of(api.delete(regId));
	}
}
