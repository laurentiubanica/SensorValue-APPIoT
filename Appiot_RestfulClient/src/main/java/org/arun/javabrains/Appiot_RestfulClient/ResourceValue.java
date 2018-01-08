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
		WebResource resource = c.resource("https://iotabusinesslab-api.sensbysigma.com/api/v3/devices/"+Device_id);
		String response = resource.accept("application/json").header("Authorization","Authorization key").header("X-DeviceNetwork", "Id").get(String.class);
		JSONParser parser = new JSONParser();
		try {
			JSONObject jsonobj = (JSONObject) parser.parse(response);


			String str = jsonobj.toJSONString();
			JSONArray array = (JSONArray)jsonobj.get("SmartObjects");
			String temperature = "Temperature";
			String temp=null;
			for(int i =0;i<array.size();i++) {
				//System.out.println(array.get(i)+"\n");
				boolean newtemp = array.get(i).toString().contains("\"Name\":\""+temperature+"\"");
				if(newtemp == true) {
					temp = String.valueOf(array.get(i));
					break;
				}

			}


			JSONObject obj = (JSONObject)parser.parse(temp);
			String temperatureid = String.valueOf(obj.get("Id"));
			System.out.println("SmartobjTempID:"+temperatureid);

			WebResource resource1 = c.resource("https://iotabusinesslab-api.sensbysigma.com/api/v3/smartobjects/"+temperatureid);
			String response1 = resource1.accept("application/json").header("Authorization","Authorization key").header("X-DeviceNetwork", "ID").get(String.class);

			JSONObject jsonobj1 = (JSONObject) parser.parse(response1);
			JSONArray array1 = (JSONArray)jsonobj1.get("Resources");
			String sensorValue = "Sensor Value";
			String reso= null;
			for(int j=0;j<array1.size();j++) {
				boolean newreso = array1.get(j).toString().contains("\"Name\":\""+sensorValue+"\"");
				if(newreso == true) {
					reso = String.valueOf(array1.get(j));
				}
			}

			JSONObject resObj = (JSONObject)parser.parse(reso);
			String resourceId = String.valueOf(resObj.get("Id"));
			System.out.println("ResourceID:"+resourceId);

			WebResource resource2 = c.resource("https://iotabusinesslab-api.sensbysigma.com/api/v3/resources/"+resourceId);
			String response2 = resource2.accept("application/json").header("Authorization","Authorization key").header("X-DeviceNetwork", "ID").get(String.class);
			JSONObject jsonobj2 = (JSONObject) parser.parse(response2);
			//JSONObject latestMeasurement = (JSONObject)parser.parse(jsonobj2.toJSONString()).get("LatestMeasurement");
			String objjj = String.valueOf(jsonobj2.get("LatestMeasurement"));
			JSONObject newsenvalue = (JSONObject)parser.parse(objjj);
			String newvaluesensor = String.valueOf(newsenvalue.get("v"));
			//String  actualSensorValue = String.valueOf(objjj.get("v"));
			System.out.println("Sensor value: "+newvaluesensor);
			
			System.out.println(response2);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
