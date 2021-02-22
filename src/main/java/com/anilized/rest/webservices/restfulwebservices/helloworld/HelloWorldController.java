package com.anilized.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;
	
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
	
	@GetMapping(path = "/hello-world-internationalized")
	public String internationalizedHelloWorldBean(@RequestHeader(name="Accept-Language", required = false) Locale locale){
		return messageSource.getMessage("good.morning.message", null, locale);
	}

}
