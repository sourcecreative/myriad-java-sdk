package io.sourcecreative.myriad.client.model.customer;

import java.util.List;
import java.util.Map;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@ToString
public class UpdateCustomers {
	
	@Singular("customer")
	private List<Customer> customers;
	
	@Singular("metadataEntry")
	private Map<String, Object> metadata;

}
