package com.wehavescience.rmi.utils.utils;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.wehavescience.rmi.utils.annotations.Server;

/**
 * @author gabriel
 * 
 * Oct 25, 2013
 */
public class DefaultUnicastRemoteObjectImpl<T extends Serializable> extends UnicastRemoteObject implements DefaultUnicastRemoteObject<T> {
	private static final long serialVersionUID = -8226791404371890703L;

	@Server
	private T server;

	public DefaultUnicastRemoteObjectImpl() throws RemoteException {
	}

	public DefaultUnicastRemoteObjectImpl(Class<T> clazz) throws RemoteException, InstantiationException, IllegalAccessException {
		super();
		this.server = clazz.newInstance();
	}

	public T getObject() {
		return server;
	}

	public void setObject(T object) {
		this.server = object;
	}
}
