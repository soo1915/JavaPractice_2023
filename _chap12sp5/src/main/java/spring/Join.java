package spring;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Join {

	@NotBlank
	@Size(min = 4)
	private String userid;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	@Size(min = 8)
	private String userpw1;
	@NotBlank
	private String userpw2;
	private boolean mailing;
}
