package io.sourcecreative.myriad.client.module;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.sourcecreative.myriad.client.api.MyriadApi;
import io.sourcecreative.myriad.client.model.rule.Rule;
import io.sourcecreative.myriad.client.model.voucher.CreateVoucher;
import io.sourcecreative.myriad.client.model.voucher.EnableVoucher;
import io.sourcecreative.myriad.client.model.voucher.PaginatedVouchersResponse;
import io.sourcecreative.myriad.client.model.voucher.UpdateVoucher;
import io.sourcecreative.myriad.client.model.voucher.VoucherResponse;

public class VoucherService extends Service {

	VoucherService(MyriadApi api, ObjectMapper objectMapper) {
		super(api, objectMapper);
	}
	
	public RemoteCall<VoucherResponse> create(CreateVoucher createVoucher) {
		return RemoteCall.of(api.createVoucher(createVoucher));
	}
	
	public RemoteCall<Void> create(List<CreateVoucher> vouchers) {
		return RemoteCall.of(api.importVouchers(vouchers));
	}

	public RemoteCall<VoucherResponse> findById(String voucherId) {
		return RemoteCall.of(api.getVoucher(voucherId));
	}
	
	public RemoteCall<VoucherResponse> update(String voucherId, UpdateVoucher voucher) {
		return RemoteCall.of(api.updateVoucher(voucherId, voucher));
	}
	
	public RemoteCall<Void> delete(String voucherId) {
		return RemoteCall.of(api.deleteVoucher(voucherId));
	}

	public RemoteCall<PaginatedVouchersResponse> list(Map<String, Object> filter) {
		return RemoteCall.of(api.listVouchers(filter));
	}

	public RemoteCall<VoucherResponse> enable(String voucherId, EnableVoucher enableVoucher) {
		return RemoteCall.of(api.enable(voucherId, enableVoucher));
	}
	
	public RemoteCall<VoucherResponse> attachRules(String voucherId, Set<Rule> rules) {
		return RemoteCall.of(api.attachRulesToVoucher(voucherId, rules));
	}
	  
	public RemoteCall<VoucherResponse> detachRules(String voucherId) {
		return RemoteCall.of(api.detachRulesFromVoucher(voucherId));
	}

	public RemoteCall<VoucherResponse> detachRule(String voucherId, String ruleId) {
		return RemoteCall.of(api.detachRuleFromVoucher(voucherId, ruleId));
	}

}
