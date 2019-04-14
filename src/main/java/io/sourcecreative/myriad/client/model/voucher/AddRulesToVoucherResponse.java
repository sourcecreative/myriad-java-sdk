package io.sourcecreative.myriad.client.model.voucher;

import java.util.List;

import io.sourcecreative.myriad.client.model.validation.RuleResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class AddRulesToVoucherResponse extends VoucherResponse {
	// rules added to voucher override rules added to the linked campaign
	private List<RuleResponse> rules;

}
