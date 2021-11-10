package project;
import javax.jws.WebService;
import java.sql.Array;


@WebService(endpointInterface = "project.DataGetter")
public class DoorServer implements DataGetter {
    /*Insert functions to handle sensors, they can be whatever and return whatever we want*/
    public Door receptionDoor = new Door(0,"open");
    public Door intoOfficeDoor = new Door(1, "open");

    public Door[] doorArray = {receptionDoor, intoOfficeDoor};
    @Override
    public String displayStatus(int id){
        String output = "";
        //System.out.println("at display status");
        for(int i = 0; i < doorArray.length; i++)
        {
            if(doorArray[i].id == id)
            {
                output += "Door is " + doorArray[i].state;
            }
        }

        return output;
    }

    @Override
    public void setStatus(String status, int id){
        for(int i = 0; i < doorArray.length; i++)
        {
            if(doorArray[i].id == id)
            {
                doorArray[i].state = status;
            }
        }
    }
}