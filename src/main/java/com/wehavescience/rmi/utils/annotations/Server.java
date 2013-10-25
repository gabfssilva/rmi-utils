package com.wehavescience.rmi.utils.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author gabriel
 *
 * Oct 23, 2013
 * 
 * 
 * This annotation supersedes the need to inherit from java.rmi.server.UnicastRemoteObject
 * 
 */
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Server {
	String name() default "server";
	int port() default 1099;
}
