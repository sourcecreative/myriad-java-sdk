package io.sourcecreative.myriad.client.model.distribution;

import java.util.Map;

import io.sourcecreative.myriad.client.model.segment.Segment;
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
public class DistributeVouchersBySegment {
	@NonNull
	private String campaignId;

	@NonNull
	private Channel channel;
	
	// how many to be distributed to the customer
	@Builder.Default
	private int countPerCustomer = 1;

	@NonNull
	private Segment segment;

	@Singular("metadataEntry")
	private Map<String, Object> metadata;

}
