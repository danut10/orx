package ro.jdmx.orx.win;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Main {

	public static void main(String[] args) {
		try { 
			Hello obj = new Hello(); 
			Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);  
			Registry registry = LocateRegistry.getRegistry(); 
			registry.bind("Hello", stub);  
			System.err.println("Server ready"); 
		} catch (Exception e) { 
			System.err.println("Server exception: " + e.toString()); 
			e.printStackTrace(); 
		} 
	}

}
