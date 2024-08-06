package com.graymatter.beans;

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

public class Author {
	//@Value("Divyanshu")
	@Value("${Author.authorName}")
	private String authorName;
	//@Value("12490")
	@Value("${Author.authorId}")
	private String authorId;
	
}
