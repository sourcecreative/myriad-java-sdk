package io.sourcecreative.myriad.client.model.customer;

import java.util.Map;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class CustomerResponse {
	private String id;
	
	private String appId;
	
	// unique
	private String sourceId;

	private String name;
	
	private String idCardNo;
	
	private String email;
	
	private String phone;
	
	private String wallet;
	
	private Address address;

	private Map<String, Object> metadata;

}
