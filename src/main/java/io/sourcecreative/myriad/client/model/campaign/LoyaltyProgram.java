package io.sourcecreative.myriad.client.model.campaign;

import io.sourcecreative.myriad.client.model.voucher.CodeConfig;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class LoyaltyProgram extends Campaign {
	// symbol of the points
	@NonNull
	private String symbol;
	
	// name of the points
	@NonNull
	private String name;

	// used to generate membership code
	private CodeConfig codeConfig;

}
