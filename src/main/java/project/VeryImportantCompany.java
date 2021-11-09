package project;

import javax.xml.namespace.QName;
import java.net.URL;
import javax.xml.ws.Service;
import java.util.Scanner;

public class VeryImportantCompany {
    
    private Service doorService, windowService;
    
    public static void main(String[] args) throws Exception {
        
        URL doorServerURL = new URL("http://localhost:8080/doors?wsdl");
        QName doorServiceName = new QName("http://project/", "DoorServerService");
        VeryImportantCompanyApp ui = new VeryImportantCompanyApp();
        
        Scanner scanner = new Scanner(System.in);


        Service doorService = Service.create(doorServerURL,doorServiceName);
        DataGetter doorStatus = doorService.getPort(DataGetter.class);

        String s = scanner.next();
        while(!s.equals("exit")){
            int id = Integer.parseInt(s);
            if(id > 1 || id < 0){
                System.out.println("Sorry, input not recognized");
            }
            else {
                String doorDisplay = doorStatus.displayStatus(id);
                System.out.println(doorDisplay);
            }

            s = scanner.next();
        }
    }
}