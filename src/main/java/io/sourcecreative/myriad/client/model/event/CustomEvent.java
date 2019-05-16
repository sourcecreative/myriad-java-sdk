package io.sourcecreative.myriad.client.model.event;

import java.util.Map;

import io.sourcecreative.myriad.client.model.customer.Customer;
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
@Getter
@Builder
@ToString
public class CustomEvent {
	@NonNull
	private String event;
	
	// who performs the event
	@NonNull
	private Customer customer;
	
	@Singular("metadataEntry")
	private Map<String, Object> metadata;
}
