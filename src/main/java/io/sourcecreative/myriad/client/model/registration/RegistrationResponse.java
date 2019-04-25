package io.sourcecreative.myriad.client.model.registration;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class RegistrationResponse {
	// Myriad ID used to identify the client
	@NonNull
	private String id;
	
	@NonNull
	private String walletId;
	
	private String name;
	
	private String description;
	
	private String homeDomain;
	
	@NonNull
	private RegistrationStatus status;
}
