package org.arun.javabrains.Appiot_RestfulClient;

public class MyClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(System.getenv("DEV_ID"));
		//System.out.println(args[0].toString());
		if(args.length == 0) {
			
			ResourceFunction r = new ResourceFunction(System.getenv("DEV_ID"), "3303", "5700", "0");
			String value=r.getResource();
			System.out.println(value);
			
		}
		else {
			
			ResourceFunction r = new ResourceFunction(args[0],args[1],args[2],args[3]);
			String value=r.getResource();
			System.out.println(value);
		}

	}

}
