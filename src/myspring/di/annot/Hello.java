package myspring.di.annot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("helloA")
public class Hello {
	//<property name="name" value="어노테이션"/>
	//@Value("어노테이션")
	String name;

	//@Autowired
	//@Qualifier("stringPrinter")
	//<property name="printer" ref="stringPrinter"/>
//	@Resource(name="${printer1}")
	Printer printer;

	public String sayHello() {
		return "Hello " + name;
	}

	public void print() {
		this.printer.print(sayHello());
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
	
	@Autowired
	public Hello(@Value("어노테이션") String name,
			@Qualifier("consolePrinter") Printer printer) {
		this.name = name;
		this.printer = printer;
	}
}


