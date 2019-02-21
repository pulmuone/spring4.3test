package myspring.di.xml.test;

import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

public class HelloBeanTest2 {
	@Test
	public void hellobean() {
		//1. Spring Container 생성
		BeanFactory factory = new GenericXmlApplicationContext("config/spring_beans.xml");
		
		//2. Bean을 요청한다.
		Hello hello = (Hello)factory.getBean("hello");
		Hello hello2 = factory.getBean("hello", Hello.class);
		
		//주소 비교
		assertSame(hello, hello2);
		
		//값 비교
		assertEquals("Hello Spring", hello.sayHello());
		hello.print();
		Printer printer = factory.getBean("sPrinter", Printer.class);
		
		assertEquals("Hello Spring", printer.toString());
	}
}
