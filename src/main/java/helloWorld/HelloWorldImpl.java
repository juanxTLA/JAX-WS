package helloWorld;

import javax.jws.WebService;
 
//Service Implementation
@WebService(endpointInterface = "helloWorld.HelloWorld")
public class HelloWorldImpl implements HelloWorld{
 
	@Override
	public String HelloWorld(String name) {

		System.out.println(name + " says hello");
		return "Hello World " + name;
	}
 
}