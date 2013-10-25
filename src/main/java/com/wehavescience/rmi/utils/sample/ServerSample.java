package com.wehavescience.rmi.utils.sample;

import com.wehavescience.rmi.utils.annotations.Server;

/**
 * @author gabriel
 *
 * Oct 24, 2013
 */
@Server(name="myServerSample")
public class ServerSample implements ClientSample {
	private static final long serialVersionUID = 720008226532974320L;

	public void print() {
		System.out.println("This is an example");
	}
}
