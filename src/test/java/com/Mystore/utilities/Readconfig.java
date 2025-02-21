package com.Mystore.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Readconfig {

	//public static void main(String [] args) {
	Properties property;
	String path="C:\\Users\\satish\\Desktop\\tdd1_project\\MyStoreV1\\Configuration\\config.properties";

	public Readconfig() {
		try {
			property=new Properties();
			FileInputStream input=new FileInputStream(path);

			property.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}

	}
	
	public String getBaseUrl() {
		String value=property.getProperty("baseUrl");
		if (value!=null)
		return value;
		else
			throw new RuntimeException("exception");
	}
	public String getbrowser() {
		String value=property.getProperty("browser");
		if (value!=null)
		return value;
		else
			throw new RuntimeException("exception");
	}
}




