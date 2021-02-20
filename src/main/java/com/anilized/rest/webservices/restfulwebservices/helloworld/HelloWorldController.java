package com.anilized.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	//GET
	//URI - /hello-world
	//method - "Hello World!"
	@GetMapping(path = "/hello-world")
	public String helloWorld(){
		return "Hello World!";
	}
	
	//hello-world-bean
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean(){
		return new HelloWorldBean("Hello World");
	}
	
	@GetMapping(path = "/hello-world-bean/path-var/{name}")
	public HelloWorldPathVar helloWorldPathVar(@PathVariable String name){
		return new HelloWorldPathVar(String.format("Hello World, %s", name ));
	}

}
