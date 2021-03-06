package io.sourcecreative.myriad.client.model.event;

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
public class PaginatedCustomEvents {
	private int total;
	
	private int page;
	
	private int size;
	
	private List<CustomEventResponse> events; 
}
