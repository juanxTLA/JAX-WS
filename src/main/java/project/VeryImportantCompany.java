package project;

import javax.xml.namespace.QName;
import java.net.URL;
import javax.xml.ws.Service;
import java.util.Scanner;

public class VeryImportantCompany {
    
    private Service doorService, windowService;
    private DataGetter doorStatus, windowStatus;
    private URL doorServerURL, windowServerURL;
    private QName doorServiceName, windowServiceName;



    public VeryImportantCompany() throws Exception{

        this.doorServerURL = new URL("http://localhost:8080/doors?wsdl");
        this.doorServiceName = new QName("http://project/", "DoorServerService");
        this.doorService = Service.create(doorServerURL,doorServiceName);
        this.doorStatus = doorService.getPort(DataGetter.class);

        this.windowServerURL = new URL("http://localhost:8080/windows?wsdl");
        this.windowServiceName = new QName("http://project/", "WindowServerService");
        this.windowService = Service.create(windowServerURL,windowServiceName);
        this.windowStatus = windowService.getPort(DataGetter.class);


    }

    public void updateData(String[] doorStates, String[]windowStates){
        String[] out = new String[2];
        for(int i = 0; i < 2; i++) {
            doorStatus.setStatus(doorStates[i],i);
            windowStatus.setStatus(windowStates[i],i);
        }
        /*out[0] = doorStatus.displayStatus(doorId);
        out[1] = windowStatus.displayStatus(windowId);*/

    }

    public String getDoorData(int id){
        return doorStatus.displayStatus(id);
    }

    public String getWindowData(int id){
        return windowStatus.displayStatus(id);
    }

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