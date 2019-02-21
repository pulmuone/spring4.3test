package myspring.di.xml.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;
import myspring.di.xml.config.HelloJavaConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=HelloJavaConfig.class,
loader=AnnotationConfigContextLoader.class)
public class HelloJavaConfigTest {

	@Autowired
	Hello hello;
	
	@Autowired
	@Qualifier("sPrinter")
	Printer printer;
	
	@Test
	public void hello() {
		System.out.println(hello.sayHello());
		hello.print();
		System.out.println(printer.toString());
	}
	
}
