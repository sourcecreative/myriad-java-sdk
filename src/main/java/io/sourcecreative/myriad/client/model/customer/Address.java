package io.sourcecreative.myriad.client.model.customer;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

//@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
@ToString
public class Address {
	private String street;

	@NonNull
	private String city;

	@NonNull
	private String state;
	
	@NonNull
	private String country;

	private String postalCode;
}
