package org.arun.javabrains.Appiot_RestfulClient;



import java.awt.List;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.Arrays;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class ResourceValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client c = Client.create();

		//WebResource resource = c.resource("https://api.blab.iotacc.ericsson.net/occhub/proxy/appiot/api/v3/devices/bootstrapservernames");
		WebResource resource = c.resource(System.getenv("BASE_URL")+"/api/v3/devices/"+args[0]);
		String response = resource.accept("application/json").header("Authorization",System.getenv("AUTH_KEY")).header("X-DeviceNetwork", System.getenv("X_DEV_NETWORK")).get(String.class);
		//System.out.println(response);
		JSONParser parser = new JSONParser();
		try {
			JSONObject jsonobj = (JSONObject) parser.parse(response);


			
			JSONArray array = (JSONArray)jsonobj.get("SmartObjects");
			
			int args1 =Integer.parseInt(args[1]);
			int args3 = Integer.parseInt(args[3]);
			
			String temp=null;
			for(int i =0;i<array.size();i++) {
				
				//boolean newtemp = array.get(i).toString().contains("\"Name\":\""+args[1]+"\"");
				String arrayElement = array.get(i).toString();
				JSONObject elementKey = (JSONObject)parser.parse(arrayElement);
				
				if((Integer.parseInt(elementKey.get("TypeId").toString())== args1 ) & (Integer.parseInt(elementKey.get("InstanceNumber").toString()) == args3)) {
					temp = String.valueOf(array.get(i));
					break;
				}
			    
				//System.out.println(newtemp);
			/*	if(newtemp == true) {
					temp = String.valueOf(array.get(i));
					break;
				}*/

			}


			JSONObject obj = (JSONObject)parser.parse(temp);
			String smartObjid = String.valueOf(obj.get("Id"));
			System.out.println("SmartobjTempID:"+smartObjid);

			WebResource resource1 = c.resource(System.getenv("BASE_URL")+"/api/v3/smartobjects/"+smartObjid);
			String response1 = resource1.accept("application/json").header("Authorization",System.getenv("AUTH_KEY")).header("X-DeviceNetwork", System.getenv("X_DEV_NETWORK")).get(String.class);

			JSONObject jsonobj1 = (JSONObject) parser.parse(response1);
			JSONArray array1 = (JSONArray)jsonobj1.get("Resources");
			int args2 = Integer.parseInt(args[2]);
			
			String reso= null;
			for(int j=0;j<array1.size();j++) {
				/*boolean newreso = array1.get(j).toString().contains("\"Name\":\""+argument2+"\"");
				if(newreso == true) {
					reso = String.valueOf(array1.get(j));
				}*/
				String arrayElement = array1.get(j).toString();
				JSONObject elementKey = (JSONObject)parser.parse(arrayElement);
				if(Integer.parseInt(elementKey.get("TypeId").toString())== args2) {
	
					reso = String.valueOf(array1.get(j));
					break;
				}
			}

			JSONObject resObj = (JSONObject)parser.parse(reso);
			String resourceId = String.valueOf(resObj.get("Id"));
			System.out.println("ResourceID:"+resourceId);

			WebResource resource2 = c.resource(System.getenv("BASE_URL")+"/api/v3/resources/"+resourceId);
			String response2 = resource2.accept("application/json").header("Authorization",System.getenv("AUTH_KEY")).header("X-DeviceNetwork", System.getenv("X_DEV_NETWORK")).get(String.class);
			JSONObject jsonobj2 = (JSONObject) parser.parse(response2);
			//JSONObject latestMeasurement = (JSONObject)parser.parse(jsonobj2.toJSONString()).get("LatestMeasurement");
			String objjj = String.valueOf(jsonobj2.get("LatestMeasurement"));
			JSONObject newsenvalue = (JSONObject)parser.parse(objjj);
			String newvaluesensor = String.valueOf(newsenvalue.get("v"));
			//String  actualSensorValue = String.valueOf(objjj.get("v"));
			System.out.println("value: "+newvaluesensor);
			
			System.out.println(response2);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
