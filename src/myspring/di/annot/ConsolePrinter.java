package myspring.di.annot;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
 * <bean id="" class="" scope="" />
 */
@Component
@Scope("singleton")
public class ConsolePrinter implements Printer {
	public void print(String message) {
		System.out.println(message);
	}
}
