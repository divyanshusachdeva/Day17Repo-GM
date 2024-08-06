package com.graymatter.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


//@AllArgsConstructor
//@NoArgsConstructor
@Getter
@Setter
//@ToString

//@PropertySource("classpath:data.properties")

public class Employee {

	@Value("${Employee.empName}")
	private String empName;
	@Value("${Employee.empId}")
	private int empId;
	@Value("${Employee.empSal}")
	private double empSal;
//	@Autowired // this is by Type
	private Department department;
	
	public Employee(String empName, int empId, double empSal, @Autowired Department department) {
		super();
		this.empName = empName;
		this.empId = empId;
		this.empSal = empSal;
		this.department = department;
	}
	
	public Employee() {
		super();
	}
	
	
}
