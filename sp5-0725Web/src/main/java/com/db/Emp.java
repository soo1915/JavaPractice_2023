package com.db;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Emp {
	int empno;
	String ename;
	int sal;
	String job;
}
