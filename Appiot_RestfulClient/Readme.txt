                             ACCESS APPIOT V2 THROUGH REST API USING JAVA

Basic Requirements:
	a. Install Eclipse IDE Which Supports Maven Project.
	b. Add the below dependancy to the pom.xml file.
		<dependency>
            	<groupId>com.sun.jersey</groupId>
            	<artifactId>jersey-client</artifactId>
            	<version>1.8</version>
            </dependency> 
    c.  Need Autorization and X-DeviceNetwork header (These two headers you will get it from
        appiot account)
	d. Refer Appiot Api’s web page for more information of API’s.
	  (https://blab.iot-  accelerator.ericsson.net/apidoc/index.html#/)
Getting Sensor value from the AppIot:
	a. Use the Device internal ID to get the sensor value.
	b. Device internal id you will get it as respose after adding the device to Appiot.
	c. Before running this code please use the Device internal id in the code.
 	d. This code will gives the latest measurement of the sensor value.

In this code we have set few variables as environment variable and few variables passing as a command line argument.
	"BASE_URL" = environment variable.
	"AUTH_KEY" = environment variable.
	"X_DEV_NETWORK" = environment variable.
	args[0] = device internal Id.
	args[1] = smart object TypeId.
	args[2] = resource TypeId.
	args[3] = Instance Number.
Make sure that before running this code the environment variable as to set in your system.
This program gives the resource value of all the LWM2M smart objects like "Temperature","Location","Device","Addressable Text Display", etc..
