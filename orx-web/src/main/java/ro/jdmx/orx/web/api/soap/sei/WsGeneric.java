package ro.jdmx.orx.web.api.soap.sei;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService(targetNamespace = "http://www.orx.jdmx.ro/")
@SOAPBinding(style=Style.DOCUMENT)
public interface WsGeneric {

    @WebMethod()
	String hello();
}
