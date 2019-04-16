package io.sourcecreative.myriad.client.model.customer;

import java.util.Map;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@ToString
public class Customer {
	// sourceId is mandatory
	@NonNull
	private String sourceId;

	private String name;
	
	private String idCardNo;
	
	// wallet address is required if delivery via blockchain
	// voucher must be a crypto asset to be distributed via blockchain
	private String wallet;
	
	// email is required if delivery via email
	private String email;
	
	// phone is required if delivery channel is SMS
	private String phone;
	
	// address is required if delivery via courier
	private Address address;

	@Singular("metadataEntry")
	private Map<String, Object> metadata;
	
}
