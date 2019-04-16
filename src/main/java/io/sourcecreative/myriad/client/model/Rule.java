package io.sourcecreative.myriad.client.model;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@ToString
public class Rule {
	// rule name, e.g., "order amount limit"
	// name must be unique in the app scope
	private String name;
	
	// a description of the rule, e.g. "if order amount is greater than $30 then pass"
	private String description;
	
	// condition of the rule, e.g. "order.amount > 30"
	// use MVEL expression
	private String condition;
	
	// actions when condition is met
	// use MVEL expression
	@Singular("action")
	private List<String> actions;
	
	@Builder.Default
	private int priority = 1;	

}
