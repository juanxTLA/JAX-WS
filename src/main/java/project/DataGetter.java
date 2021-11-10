package project;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface DataGetter {
    @WebMethod String displayStatus(int id);
    @WebMethod void setStatus(String status, int id);
}
