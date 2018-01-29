  JAVA CLASS TO ACCESS IPSO RESOURCES ON APPIOT V2

Download and Build (needs maven):
	$ git clone  https://github.com/arunkumar0/SensorValue-APPIoT
	$ cd SensorValue-AppIoT/Appiot_RestfulClient
	$ mvn clean package

Set Environment Variables:
	APPIOT setting are passed through these environment variables:
	$ export BASE_URL="https://iotabusinesslab-api.sensbysigma.com"
	$ export AUTH_KEY="Bearer xyzzzzzz"
	$ export X_DEV_NETWORK="123456778-888"
	$ export X_DEBUG="0"= It provides only Sensor value. 
									or
					 "1"= It provides Smartobj ID, Resourceobj ID and the entire response from the server.	
					

Usage: 
	In Java code:

        package org.arun.javabrains.Appiot_RestfulClient;
	..
	..
        ResourceFunction r = new ResourceFunction(<device-id>, <smart-object-id>, <resource-type-id>, <instance-id>);
        v = r.getResource();
	..

	Also available as a command line for easy usage/testing:
        
        $ java -cp target/Appiot_RestfulClient.jar  org.arun.javabrains.Appiot_RestfulClient.MyClass <device-id>  <smart-object-id>  <resource-type-id>  <instance-id>

   -> device-id is the internal device Id of the device.
