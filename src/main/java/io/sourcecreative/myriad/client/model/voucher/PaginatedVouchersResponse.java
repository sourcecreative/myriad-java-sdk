package io.sourcecreative.myriad.client.model.voucher;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class PaginatedVouchersResponse {
	private Integer total;

	// current page
	private Integer page;

	// page size
	private Integer size;

	private List<VoucherResponse> vouchers;
	
	public static PaginatedVouchersResponse of(Integer total, Integer page, Integer size, List<VoucherResponse> vouchers) {
		return new PaginatedVouchersResponse(total,page,size,vouchers);
	}

}
