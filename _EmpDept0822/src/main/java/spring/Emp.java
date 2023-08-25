package spring;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Emp {
	private int empno;
	@NotBlank
	private String ename;
	@NotBlank
	private String job;
	private int mgr;
	private Date hiredate;
	
	private double sal;
	private double comm;
	private int deptno;
}
