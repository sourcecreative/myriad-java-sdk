package io.sourcecreative.myriad.client.model.voucher;

import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
@ToString
public class CreateVoucher {
	// if campaignId is provided, the campaign must be AUTO_UPDATE type
	private String campaignId;
	// client may provide a code
	private String code;

	@JsonUnwrapped
	private VoucherConfig config;

	@Singular("metadata")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Map<String, Object> metadata;
}
