package org.arun.javabrains.Appiot_RestfulClient;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class ResourceFunction {
	String devId;
	String smartobjTypeId;
	String resourceTypeId;
	String instanceNo;
	String smartObjid;
	String resourceId;
	String response2;
	
	public ResourceFunction(String devId,String smartobjTypeId,String resourceTypeId,String instanceNo) {
		 this.devId = devId;
		 this.smartobjTypeId = smartobjTypeId;
		 this.resourceTypeId = resourceTypeId;
		 this.instanceNo = instanceNo;
	}
	
	public String getResource() {
	Client c = Client.create();
	String newvaluesensor = null;

	
	WebResource resource = c.resource(System.getenv("BASE_URL")+"/api/v3/devices/"+devId);
	String response = resource.accept("application/json").header("Authorization",System.getenv("AUTH_KEY")).header("X-DeviceNetwork", System.getenv("X_DEV_NETWORK")).get(String.class);
	
	JSONParser parser = new JSONParser();
	try {
		JSONObject jsonobj = (JSONObject) parser.parse(response);


		
		JSONArray array = (JSONArray)jsonobj.get("SmartObjects");
		
		int args1 =Integer.parseInt(smartobjTypeId);
		int args3 = Integer.parseInt(instanceNo);
		
		String temp=null;
		for(int i =0;i<array.size();i++) {
			
			
			String arrayElement = array.get(i).toString();
			JSONObject elementKey = (JSONObject)parser.parse(arrayElement);
			
			if((Integer.parseInt(elementKey.get("TypeId").toString())== args1 ) & (Integer.parseInt(elementKey.get("InstanceNumber").toString()) == args3)) {
				temp = String.valueOf(array.get(i));
				break;
			}
		    
			

		}


		JSONObject obj = (JSONObject)parser.parse(temp);
		smartObjid = String.valueOf(obj.get("Id"));
		

		WebResource resource1 = c.resource(System.getenv("BASE_URL")+"/api/v3/smartobjects/"+smartObjid);
		String response1 = resource1.accept("application/json").header("Authorization",System.getenv("AUTH_KEY")).header("X-DeviceNetwork", System.getenv("X_DEV_NETWORK")).get(String.class);

		JSONObject jsonobj1 = (JSONObject) parser.parse(response1);
		JSONArray array1 = (JSONArray)jsonobj1.get("Resources");
		int args2 = Integer.parseInt(resourceTypeId);
		
		String reso= null;
		for(int j=0;j<array1.size();j++) {
			
			String arrayElement = array1.get(j).toString();
			JSONObject elementKey = (JSONObject)parser.parse(arrayElement);
			if(Integer.parseInt(elementKey.get("TypeId").toString())== args2) {

				reso = String.valueOf(array1.get(j));
				break;
			}
		}

		JSONObject resObj = (JSONObject)parser.parse(reso);
		resourceId = String.valueOf(resObj.get("Id"));
		

		WebResource resource2 = c.resource(System.getenv("BASE_URL")+"/api/v3/resources/"+resourceId);
		response2 = resource2.accept("application/json").header("Authorization",System.getenv("AUTH_KEY")).header("X-DeviceNetwork", System.getenv("X_DEV_NETWORK")).get(String.class);
		JSONObject jsonobj2 = (JSONObject) parser.parse(response2);
		String objjj = String.valueOf(jsonobj2.get("LatestMeasurement"));
		JSONObject newsenvalue = (JSONObject)parser.parse(objjj);
		 newvaluesensor = String.valueOf(newsenvalue.get("v"));
		

	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return newvaluesensor;
	}
	
	public void httpresp() {
		System.out.println("SmartobjTempID:"+smartObjid);
		System.out.println("ResourceID:"+resourceId);
		System.out.println(response2);
		
	}

}
