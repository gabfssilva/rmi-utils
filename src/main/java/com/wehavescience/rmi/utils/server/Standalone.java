package com.wehavescience.rmi.utils.server;

import java.io.Serializable;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import com.wehavescience.rmi.utils.annotations.Server;
import com.wehavescience.rmi.utils.utils.DefaultUnicastRemoteObjectImpl;

/**
 * @author gabriel
 * 
 * Oct 23, 2013
 */
public class Standalone implements Serializable {
	private static final long serialVersionUID = -1942995922934818734L;

	@SuppressWarnings("rawtypes")
	private DefaultUnicastRemoteObjectImpl server;
	private Registry registry;

	private static Standalone standalone;

	private Standalone() {
	}

	public static <T extends Serializable> void init(Class<T> serverClass, String serverName, int port) throws Exception {
		checkoutServerInformations(serverClass);

		if (standalone == null) {
			standalone = new Standalone();
		}

		standalone.server = new DefaultUnicastRemoteObjectImpl<T>(serverClass);
		standalone.registry = LocateRegistry.createRegistry(1099);
		standalone.registry.rebind(serverName, (Remote) standalone.server);
	}

	public static <T extends Serializable> void init(Class<T> serverClass) throws Exception {
		Server server = checkoutServerInformations(serverClass);
		init(serverClass, server.name(), server.port());
	}

	public static void disconnect(boolean exitSystem) throws AccessException, RemoteException, NotBoundException {
		UnicastRemoteObject.unexportObject(standalone.registry, true);
		if(exitSystem){
			System.exit(0);
		}
	}

	public static <T extends Serializable> Server checkoutServerInformations(Class<T> serverClass) {
		Server server = serverClass.getAnnotation(Server.class);

		if (server == null) {
			throw new ClassCastException("This class isn't a @Server");
		}

		return server;
	}
}
