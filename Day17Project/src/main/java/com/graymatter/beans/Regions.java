package com.graymatter.beans;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString


public class Regions {

	private int rid;
	private String rname;
	
}
