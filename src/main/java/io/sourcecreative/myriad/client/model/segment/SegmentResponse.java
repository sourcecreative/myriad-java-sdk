package io.sourcecreative.myriad.client.model.segment;

import java.util.Date;
import java.util.Map;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class SegmentResponse {
	private String id;
	
	private String name;
	
	// number of customers
	private Integer customerCount;

	private Date createdAt;
	
	private Map<String, Object> metadata;	

}
