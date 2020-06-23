package com.nt.command;

import java.util.ResourceBundle;

//maps incoming request uri with command class
public class CommandMapper {
	private static ResourceBundle bundle;
	static {
		//load the proeprties file
		bundle=ResourceBundle.getBundle("com/nt/commons/config");
	}
    
	public static  Command  getInstance(String uri) throws Exception{
    	String commandClass=null;
    	Command cmd=null;
		//get Command class name based request uri from properties file
		commandClass=bundle.getString(uri);
		// instantiate command class
		cmd=(Command)Class.forName(commandClass).newInstance();
		return cmd;
		
		
    }
}
