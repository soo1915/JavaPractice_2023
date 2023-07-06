package backend0706;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeDto {
	int num;
	String name;
	String phone;
	String part;
	String content;
	String writedate;
}
