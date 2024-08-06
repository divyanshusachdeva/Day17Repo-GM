package com.graymatter.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration

@ComponentScan("com.graymatter.beans")
@PropertySource("classpath:orderdata.properties")

public class OrderConfig {

}
