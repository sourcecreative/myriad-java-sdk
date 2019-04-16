package io.sourcecreative.myriad.client.model.customer;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
@ToString
public class Address {
	private String street;

	private String city;

	private String state;

	private String country;

	private String postalCode;
}
