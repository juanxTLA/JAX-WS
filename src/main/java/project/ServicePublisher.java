package project;


import javax.xml.ws.Endpoint;

public class ServicePublisher {
    public static void main(String[] args) {
        DoorServer doors = new DoorServer(); //this will be an array of doors
        WindowServer windows = new WindowServer();

        Endpoint.publish("http://localhost:8080/doors",doors);
        Endpoint.publish("http://localhost:8080/windows",windows);
    }
}
