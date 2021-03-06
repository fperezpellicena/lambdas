package unit.com.lambdas.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode
public class User {

	private String name;

	private int age;

}
