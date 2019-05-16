package io.sourcecreative.myriad.client.model;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class PaginatedResponse<T> {
	@NonNull
	private Integer total;
	
	@NonNull
	private Integer page;
	
	@NonNull
	private Integer size;

	@NonNull
	private List<T> items;
}
