package io.sourcecreative.myriad.client.model.voucher;

import java.util.Date;
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
@Getter
@Builder
@ToString
public class UpdateVoucher {
	private String category;

	private Date effective;

	private Date expiry;

	@Singular("metadata")
	private Map<String, Object> metadata;

}
