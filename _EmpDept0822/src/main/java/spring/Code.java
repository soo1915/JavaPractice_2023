package spring;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
@Builder
@NoArgsConstructor
@Setter
public class Code {

	private String code;
	private String label;	
	
}
