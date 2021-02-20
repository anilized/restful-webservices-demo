package com.anilized.rest.webservices.restfulwebservices.helloworld;

public class HelloWorldPathVar {
	
	private String name;
	
	public HelloWorldPathVar(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "HelloWorldPathVar [name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
