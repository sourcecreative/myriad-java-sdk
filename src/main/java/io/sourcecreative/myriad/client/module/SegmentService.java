package io.sourcecreative.myriad.client.module;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.sourcecreative.myriad.client.api.MyriadApi;
import io.sourcecreative.myriad.client.model.segment.PaginatedSegmentsResponse;
import io.sourcecreative.myriad.client.model.segment.Segment;
import io.sourcecreative.myriad.client.model.segment.SegmentResponse;

public class SegmentService extends Service {

	SegmentService(MyriadApi api, ObjectMapper objectMapper) {
		super(api, objectMapper);
	}
	
	public RemoteCall<SegmentResponse> create(Segment segment) {
		return RemoteCall.of(api.createSegment(segment));
	}

	public RemoteCall<SegmentResponse> findById(String segmentId) {
		return RemoteCall.of(api.getSegment(segmentId));
	}

	public RemoteCall<PaginatedSegmentsResponse> list(Map<String,Object> filter) {
		return RemoteCall.of(api.listSegments(filter));
	}

	public RemoteCall<Void> delete(String segmentId) {
		return RemoteCall.of(api.deleteSegment(segmentId));
	}
}
