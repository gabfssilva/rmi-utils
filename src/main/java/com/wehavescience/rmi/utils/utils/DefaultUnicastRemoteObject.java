package com.wehavescience.rmi.utils.utils;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author gabriel
 *
 * Oct 25, 2013
 */
public interface DefaultUnicastRemoteObject<T extends Serializable> extends Remote {
	T getObject() throws RemoteException;
}
