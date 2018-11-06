package ro.jdmx.orx.win;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Main {

	public static void main(String[] args) {
		String host = "127.0.0.1";
		int port = 1099;
		try { 
			Hello obj = new Hello(); 
			IHello stub = (IHello) UnicastRemoteObject.exportObject(obj, 0);  
			Registry registry = LocateRegistry.getRegistry(host, port); 
			registry.bind("Hello", stub);  
			System.err.println("Server ready"); 
		} catch (Exception e) { 
			System.err.println("Server exception: " + e.toString()); 
			e.printStackTrace(); 
		} 
	}

}
