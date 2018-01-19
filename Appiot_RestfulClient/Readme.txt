                              ACCESS APPIOT V2 THROUGH REST API USING JAVA


Getting Sensor value from the AppIot:
	a. Use the Device internal ID to get the sensor value.
	b. Device internal id you will get it as respose after adding the device     to Appiot.
	c. Before running this code please use the Device internal id in the code.
 	d. This code will gives the latest measurement of the sensor value.

In this programming we set few variables as a environment variable and also we are passing few arguments through command line.
variables details are here:
Environment Variables:
	1. BASE_URL:”https://iotabusinesslab-api.sensbysigma.com”
	2. AUTH_KEY:”Bearer xyzzzzzz”
	3. X_DEV_NETWORK:”123456778-888”
Command line Arguments:
	1. args[0] = Device Internal Id:”98526258-deg8g7g-c8”
	2. args[1] = Smart object TypeID:”3303”
	3. args[2] = Resource TypeId:”5700”
	4. args[3] = InstanceNumber:”0”

This program  has a separate class to get the resource value. Any one can use this class to get the different smart object resource.
  
To run this code through command line Please follow the below steps:
	1. Build this code by running this command:
		--$	mvn clean package
	2. TO run this code use this command:
        --$ java -cp target/Appiot_RestfulClient.jar   org.arun.javabrains.Appiot_RestfulClient.MyClass [Dev_Id] [SmartobjTypeID] [ResourceTypeId] [InstanceNumber] 

Make Sure that before running this code thorough command line install Maven externally. 

