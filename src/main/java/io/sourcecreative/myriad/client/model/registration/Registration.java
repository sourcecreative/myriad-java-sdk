package io.sourcecreative.myriad.client.model.registration;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@ToString
public class Registration {
	// client must provide a wallet address to receive rewards and identify itself
	@NonNull
	private String walletId;
	
	private String name;
	
	private String description;
	
	private String homeDomain;
}
