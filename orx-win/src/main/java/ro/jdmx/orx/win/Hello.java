package ro.jdmx.orx.win;

import java.rmi.RemoteException;

public class Hello implements IHello {

	public void printMsg() throws RemoteException {
		System.out.println("This is an example RMI program"); 
		
	}
	
}
