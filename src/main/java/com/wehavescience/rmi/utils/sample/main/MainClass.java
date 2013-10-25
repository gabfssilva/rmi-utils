package com.wehavescience.rmi.utils.sample.main;

import com.wehavescience.rmi.utils.client.RMIClient;
import com.wehavescience.rmi.utils.sample.ClientSample;
import com.wehavescience.rmi.utils.sample.ServerSample;
import com.wehavescience.rmi.utils.server.Standalone;

/**
 * @author gabriel
 * 
 * Oct 25, 2013
 */
public class MainClass {
	public static void main(String[] args) throws Exception {
		Standalone.init(ServerSample.class);
		ClientSample client = RMIClient.lookup(ClientSample.class);
		client.print();
		Standalone.disconnect(true);
	}
}
