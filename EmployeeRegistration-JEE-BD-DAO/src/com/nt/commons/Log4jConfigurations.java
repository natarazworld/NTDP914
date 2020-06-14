package com.nt.commons;

import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

import org.apache.log4j.PropertyConfigurator;

public class Log4jConfigurations {
	
	public static  void  configure() {
		ResourceBundle  bundle=null;
		Properties props=null;
		Set<String> keys=null;
		try {
		//locate the properties file
		bundle=ResourceBundle.getBundle("com/nt/commons/log4j");
		//get all keys from the properties file
		 keys=bundle.keySet();
		 //write properties file data to  java.util.Properties collection
		 props=new Properties();
		 for(String key:keys) {
			 props.put(key,bundle.getString(key));
		 }
		 //Activate  Log4j
		 PropertyConfigurator.configure(props);
		}
		catch(Exception  e) {
			e.printStackTrace();
		}
	}

}
