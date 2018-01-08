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
1. Adding multiple devices to APPIOT v2

	a. Please find the Basic code to add multiple devices to appiot in TestExample.java.
	b. Run TestExample.java file as a java application in Eclipse IDE.
	c. If you want to add more Devices to appiot Please mention the END_POINT address in the Endpoint.txt in           
                    the project folder.
	d. To convert json to string object please specify the json format in JsonDatafile.java file.


2. GET Request to the APPIOT v2

	a. Please find the Basic java code to get resource value from appiot in GetvalueAppiot.java file.
	b. Run GetValueAppiot.java as a  java application in Eclipse IDE.
	c. Refer APPIOT API’s web page for more information about the rest api.
	    ((https://blab.iot-  accelerator.ericsson.net/apidoc/index.html#/))
