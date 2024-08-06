package com.graymatter.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Component
public class Customer {
	
	@Value("${Customer.name}")
	private String name;
	@Value("${Customer.id}")
	private int id;
	@Value("${Customer.mobile}")
	private String mobile;
	@Value("${Customer.email}")
	private String email;
	
	@Autowired
	private Order order;

}
