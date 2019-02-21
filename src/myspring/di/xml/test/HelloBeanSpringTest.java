package myspring.di.xml.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Ignore;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/spring_beans.xml")
public class HelloBeanSpringTest {
	
	@Autowired
	@Qualifier("helloC")
	Hello hello;
		
	@Resource(name="sPrinter")
	Printer Printer;
	
	@Autowired
	DataSource dataSource;
	
	@Test
	public void jdbc() {
		try {
			System.out.println(dataSource.getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	@Test
	public void hello2() {
		assertEquals("Hello 생성자", hello.sayHello());
		hello.print();
	}
	
	@Test @Ignore
	public void hello() {		
//		assertEquals("Hello Spring", hello.sayHello());
//		hello.print();
//		assertEquals("Hello Spring", Printer.toString());
	}	
}
