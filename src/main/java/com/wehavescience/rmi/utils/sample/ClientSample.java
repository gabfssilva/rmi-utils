package com.wehavescience.rmi.utils.sample;

import java.io.Serializable;

import com.wehavescience.rmi.utils.annotations.Client;

/**
 * @author gabriel
 *
 * Oct 24, 2013
 */
@Client(serverName="myServerSample")
public interface ClientSample extends Serializable{
	void print();
}
