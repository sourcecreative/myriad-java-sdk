package io.sourcecreative.myriad.client.model.rule;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Builder
@Getter
@ToString
public class Rule {
	// rule name, e.g., "order amount limit"
	// name must be unique in the app scope
	@NonNull
	private String name;
	
	// a description of the rule, e.g. "if order amount is greater than $30 then pass"
	@NonNull
	private String description;
	
	// condition of the rule, e.g. "order.amount > 30"
	// use MVEL expression
	@NonNull
	private String condition;
	
	// actions when condition is met
	// use MVEL expression
	private String action;
	
	@Builder.Default
	private int priority = 1;	

}
