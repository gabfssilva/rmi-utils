package com.wehavescience.rmi.utils.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author gabriel
 *
 * Oct 23, 2013
 * 
 * 
 * This annotation supersedes the need to inherit from java.rmi.Remote
 */
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Client {
	String serverName() default "server";
	int port() default 1099;
	String ip() default "localhost";
}
