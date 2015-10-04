package com.practicaljava.lesson32.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class HelloWorldBean {
	public HelloWorldBean() {
		// TODO Auto-generated constructor stub
	}
	
    public String sayHello(){
        return "Hello World!";
    }
}
