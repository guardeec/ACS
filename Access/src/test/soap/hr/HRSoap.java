
package soap.hr;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.7-b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "HRSoap", targetNamespace = "http://admin.client.services.server/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface HRSoap {


    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.Object
     */
    @WebMethod(operationName = "HRMethods")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "HRMethods", targetNamespace = "http://admin.client.services.server/", className = "soap.hr.HRMethods")
    @ResponseWrapper(localName = "HRMethodsResponse", targetNamespace = "http://admin.client.services.server/", className = "soap.hr.HRMethodsResponse")
    @Action(input = "http://admin.client.services.server/HRSoap/HRMethodsRequest", output = "http://admin.client.services.server/HRSoap/HRMethodsResponse")
    public Object hrMethods(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        EmployeeDATA arg1);

}
