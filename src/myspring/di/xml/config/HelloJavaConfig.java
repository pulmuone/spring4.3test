package myspring.di.xml.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import myspring.di.xml.ConsolePrinter;
import myspring.di.xml.Hello;
import myspring.di.xml.Printer;
import myspring.di.xml.StringPrinter;

@Configuration
public class HelloJavaConfig {
	@Bean
	public Hello hello() {
		Hello hello = new Hello();
		hello.setName("Java컨피그");
		hello.setPrinter(printer());
		return hello;
	}
	
	@Bean
	@Qualifier("sPrinter")
	public Printer printer() {
		Printer printer = new StringPrinter();
		return printer;
	}
	
	@Bean
	@Qualifier("cPrinter")
	public Printer cPrinter() {
		Printer printer = new ConsolePrinter();
		return printer;
	}
}