package project;
import javax.jws.WebService;
import java.sql.Array;

@WebService(endpointInterface = "project.DataGetter")
public class WindowServer implements DataGetter {
    public Window officeWindow1 = new Window(0,"open");
    public Window officeWindow2 = new Window(1, "open");

    public Window[] windowArray = {officeWindow1, officeWindow2};
    @Override
    public String displayStatus(int id){
        String output = "";
        //System.out.println("at display status");
        for (Window window : windowArray) {
            if (window.id == id) {
                output += "Window is " + window.state;
            }
        }
        return output;
    }

    @Override
    public void setStatus(String status, int id){
        for (Window window : windowArray) {
            if (window.id == id) {
                window.state = status;
            }
        }
    }
}
