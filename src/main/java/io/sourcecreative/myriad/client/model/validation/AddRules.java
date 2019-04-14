package io.sourcecreative.myriad.client.model.validation;

import java.util.List;

import org.junit.Rule;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@ToString
public class AddRules {
	// assign rules to campaign - if a rule does not exist, create and assign
	private List<Rule> rules;
}
