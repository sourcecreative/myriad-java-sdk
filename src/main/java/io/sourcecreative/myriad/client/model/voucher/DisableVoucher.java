package io.sourcecreative.myriad.client.model.voucher;

import io.sourcecreative.myriad.client.model.PatchAction;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class DisableVoucher {
	private PatchAction op = PatchAction.REPLACE;
	
	private String path = "/status";
	
	private VoucherStatus value = VoucherStatus.DISABLED;
	
	private boolean enabled;
	
	@Builder
	public static DisableVoucher of() {
		DisableVoucher ev = new DisableVoucher();
		ev.value = VoucherStatus.DISABLED;
		return ev;
	}

}
