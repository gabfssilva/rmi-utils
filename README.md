rmi-utils
=========

RMI api based on annotations

Server: (no need to inherit from java.rmi.server.UnicastRemoteObject)

```
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
```

Client: (no need to inherit from java.rmi.Remote)

```
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

```

Standalone and RMIClient to lookup the object:

```
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
```


:D
