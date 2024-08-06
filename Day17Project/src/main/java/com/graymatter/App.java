package com.graymatter;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

//import com.graymatter.beans.Book;
import com.graymatter.beans.Customer;
import com.graymatter.beans.DbUtils;
import com.graymatter.beans.MyDataSource;
//import com.graymatter.beans.Employee;
import com.graymatter.beans.Order;
import com.graymatter.beans.Regions;
//import com.graymatter.config.BookConfig;
import com.graymatter.config.OrderConfig;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException
    {
//        ApplicationContext context = new ClassPathXmlApplicationContext("emp-bean.xml");
//        Employee emp = context.getBean(Employee.class);
//        System.out.println(emp);
 
//        ApplicationContext context = new AnnotationConfigApplicationContext(BookConfig.class);
//        Book book = (Book) context.getBean("book");
//        System.out.println(book);
        
//    	
    	ApplicationContext context = new AnnotationConfigApplicationContext(OrderConfig.class);
//        Order order = (Order) context.getBean("order");
//        System.out.println(order);
//    	
//        Customer customer = (Customer) context.getBean("customer");
//        System.out.println(customer);
//      
    	
    	Connection con = null;
    	MyDataSource dataSource = (MyDataSource) context.getBean("myDataSource");
    	try {
			con = dataSource.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	
    	DbUtils dbUtils = (DbUtils) context.getBean("dbUtils");
    	dbUtils.setCon(con);
    	List<Regions> rList = dbUtils.getAll();
    	for(Regions r:rList)
    		System.out.println(r.getRname() + " " + r.getRid());
    	
    	
    
    // Add Region
    Regions reg = dbUtils.addRegion(new Regions(8, "Africaaa"));
    System.out.println(); 
    
    // Update Region
    Regions updatedRegion = dbUtils.updateRegion(new Regions(8, "Africa"));
    System.out.println("Updated Region: " + updatedRegion);
    
    //Delete Region
    dbUtils.deleteRegion(8);
    System.out.println("Deleted Region with ID 8");
    
    
    
    }
    
}
