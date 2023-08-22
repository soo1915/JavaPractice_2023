package spring;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Emp {
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private LocalDateTime hiredate;
	private double sal;
	private double comm;
	private int deptno;
}
