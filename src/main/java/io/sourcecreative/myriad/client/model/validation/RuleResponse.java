package io.sourcecreative.myriad.client.model.validation;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class RuleResponse {
	private String id;
	
	// rule name, e.g., "order amount limit"
	// name must be unique in the app scope
	private String name;
	
	// a description of the rule, e.g. "if order amount is greater than $30 then pass"
	private String description;
	
	// condition of the rule, e.g. "order.amount > 30"
	private String condition;
	
	private int priority;

}
