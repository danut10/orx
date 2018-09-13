package ro.jdmx.orx.web.api.soap.impl;

import javax.jws.WebService;

import ro.jdmx.orx.web.api.soap.sei.WsGeneric;

@WebService(endpointInterface = "ro.jdmx.orx.web.api.soap.sei.WsGeneric")
public class WsGenericImpl implements WsGeneric {

	@Override
	public String hello() {
        return "Hello";
	}

}
