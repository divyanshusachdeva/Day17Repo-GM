package com.graymatter.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Component

public class Order {

	@Value("${Order.orderId}")
	private int orderId;
	@Value("${Order.date}")
	private Date date;
	@Value("#{'${Order.itemList}'.split(',')}")
	private List<String> itemList;
	
	
}
