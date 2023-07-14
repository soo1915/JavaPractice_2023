package com.db;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Emp {

	private int empno;
	private String ename;
	private String job;
	private int sal;
}
