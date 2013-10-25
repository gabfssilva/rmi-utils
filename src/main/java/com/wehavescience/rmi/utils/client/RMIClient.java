package com.wehavescience.rmi.utils.client;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.wehavescience.rmi.utils.annotations.Client;
import com.wehavescience.rmi.utils.utils.DefaultUnicastRemoteObject;

/**
 * @author gabriel
 * 
 * Oct 25, 2013
 */
@SuppressWarnings("unchecked")
public class RMIClient {

	public static <T extends Serializable> T lookup(Class<T> clazz) {
		Client client = checkoutClientInformations(clazz);
		DefaultUnicastRemoteObject<T> remoteObject;
		try {
			remoteObject = (DefaultUnicastRemoteObject<T>) Naming.lookup("rmi://" + client.ip() + ":" + client.port() + "/" + client.serverName());
			return (T) remoteObject.getObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T extends Serializable> T lookup(String ip, String port, String serverName) throws MalformedURLException, RemoteException, NotBoundException {
		DefaultUnicastRemoteObject<T> remoteObject;
		try {
			remoteObject = (DefaultUnicastRemoteObject<T>) Naming.lookup("rmi://" + ip + ":" + port + "/" + serverName);
			return (T) remoteObject.getObject();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private static <T extends Serializable> Client checkoutClientInformations(Class<T> clientInterface) {
		Client client = clientInterface.getAnnotation(Client.class);

		if (client == null) {
			throw new ClassCastException("This class isn't a @Client");
		}

		return client;
	}
}
