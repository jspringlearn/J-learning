package com.at.spring;

public class HelloWorld {
    private String name;
    public void setName(String name) {
    	System.out.println("do setname");
		this.name = name;
	}
    public void Hello() {
    	System.out.println("hello: "+ name);
    }
    public HelloWorld()
    {
    	System.out.println("HelloWord constor");
    }
}
