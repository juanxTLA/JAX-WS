package project;
import javax.jws.WebService;
import java.sql.Array;

@WebService(endpointInterface = "project.DataGetter")
public class WindowServer implements DataGetter {
    public Window officeWindow1 = new Window(0,"open");
    public Window officeWindow2 = new Window(1, "closed but not locked");

    public Window[] windowArray = {officeWindow1, officeWindow2};
    @Override
    public String displayStatus(int id){
        String output = "";
        //System.out.println("at display status");
        for(int i = 0; i < windowArray.length; i++)
        {
            if(windowArray[i].id == id)
            {
                output += "Window " + windowArray[i].id + " is " + windowArray[i].state;
            }
        }
        return output;
    }
}
