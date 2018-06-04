package com.rev.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rev.beans.AutoWiredBear;
import com.rev.beans.Bear;
import com.rev.beans.BearWithAutoByName;
import com.rev.beans.BearWithAutoByType;
import com.rev.beans.BearWithConstructor;
import com.rev.beans.BearWithSetter;

public class Driver {

	public static void main(String[] args) {
		// this will allow us to access ioc
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		funWithBears(ac);
		// close ac at the end
		((AbstractApplicationContext) ac).close();
	}

	public static void funWithBears(ApplicationContext ac) {
		Bear b1 = (BearWithSetter) ac.getBean("bearWithSetter");
		b1.methodInBear();
		
		Bear b2 = (BearWithConstructor) ac.getBean("bearWithConstructor");
		b2.methodInBear();
		
		Bear b3 = (BearWithAutoByName) ac.getBean("autoBearByName");
		b3.methodInBear();
		
		Bear b4 = (BearWithAutoByType) ac.getBean("autoBearByType");
		b4.methodInBear();
		
		Bear b5 = (AutoWiredBear) ac.getBean("autoWiredBear");
		b5.methodInBear();
		
		
	}
}
