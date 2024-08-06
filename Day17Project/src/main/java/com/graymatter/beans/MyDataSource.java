package com.graymatter.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;


@Component


public class MyDataSource {

	private String driver;
	private String url;
	private String uname;
	private String pwd;
	
	@PostConstruct
	public void setup() {
		driver = "com.mysql.cj.jdbc.Driver";
		url = "jdbc:mysql://localhost:3306/graymatterdb";
		uname = "root";
		pwd = "password";
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uname, pwd);
		System.out.println("Connection established!");
		return con;
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Connection closed!");
	}
	
}
