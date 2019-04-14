package io.sourcecreative.myriad.client.model.voucher;

import io.sourcecreative.myriad.client.model.PatchAction;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class EnableVoucher {
	private PatchAction op = PatchAction.REPLACE;
	
	private String path = "/status";
	
	private VoucherStatus value = VoucherStatus.DISABLED;
	
	private boolean enabled;
	
	@Builder
	public static EnableVoucher of(boolean enabled) {
		EnableVoucher ev = new EnableVoucher();
		ev.value = enabled ? VoucherStatus.ENABLED : VoucherStatus.DISABLED;
		return ev;
	}

}
