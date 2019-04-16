package io.sourcecreative.myriad.client.model.validation;

import io.sourcecreative.myriad.client.model.Rule;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class RuleResponse extends Rule {
	@NonNull
	private String id;
}
