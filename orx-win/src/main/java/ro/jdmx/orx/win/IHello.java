package ro.jdmx.orx.win;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IHello extends Remote {
	void printMsg() throws RemoteException;
}
