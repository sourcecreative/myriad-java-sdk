package io.sourcecreative.myriad.client.model.event;

import java.util.Date;
import java.util.Map;

import io.sourcecreative.myriad.client.model.customer.Customer;
import lombok.Getter;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

@Getter
@ToString
public class CustomEventResponse {
	@NonNull
	private String id;
	
	@NonNull
	private Date updatedAt;
	
	@NonNull
	private String event;
	
	@NonNull
	private Customer customer;
	
	@Singular("metadataEntry")
	private Map<String, Object> metadata;

}
