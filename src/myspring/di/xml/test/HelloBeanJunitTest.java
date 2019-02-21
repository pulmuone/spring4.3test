package myspring.di.xml.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

public class HelloBeanJunitTest {

	private ApplicationContext context;
	
	@Before
	public void init() {
		context = new GenericXmlApplicationContext("config/spring_beans.xml");
	}
	
	@Test
	public void bean1() {
		Hello hello = (Hello) context.getBean("hello");
		assertEquals("Hello Spring", hello.sayHello());
		hello.print();
		
		Printer printer = (Printer) context.getBean("printer");
		System.out.println(printer.toString());
		assertEquals("Hello Spring", printer.toString());
	}
}
