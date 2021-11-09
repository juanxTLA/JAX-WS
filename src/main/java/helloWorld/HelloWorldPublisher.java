package helloWorld;

import javax.xml.ws.Endpoint;
 
//Endpoint publisher
public class HelloWorldPublisher{
 
	public static void main(String[] args) {
	   Endpoint.publish("http://localhost:8080/hello", new HelloWorldImpl());
    }
 
}