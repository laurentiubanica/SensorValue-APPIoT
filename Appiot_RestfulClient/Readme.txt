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
In this programming we set few variables as a environment variable and also we passing few arguments through command line.
variables details are here:
Environment Variables:
	1. BASE_URL
	2. AUTH_KEY
	3. X_DEV_NETWORK
Command line Arguments:
	1. args[0] = Device Internal Id
	2. args[1] = Smart object TypeID
	3. args[2] = Resource TypeId
	4. args[3] = InstanceNumber

This program  has a separate class to get the resource value. Any one can use this class to get the different smart object resource.
  

