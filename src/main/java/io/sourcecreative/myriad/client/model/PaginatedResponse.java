package io.sourcecreative.myriad.client.model;

import java.util.List;

import lombok.NonNull;
import lombok.Value;

@Value
public class PaginatedResponse<T> {
	@NonNull
	private final Integer total;
	
	@NonNull
	private final Integer page;
	
	@NonNull
	private final Integer size;

	@NonNull
	private final List<T> items;
}
