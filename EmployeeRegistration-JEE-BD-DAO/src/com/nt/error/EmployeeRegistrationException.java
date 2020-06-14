package com.nt.error;

import org.apache.log4j.Logger;

import com.nt.commons.Log4jConfigurations;

public class EmployeeRegistrationException extends Exception {
	 private static  Logger logger=Logger.getLogger(EmployeeRegistrationException.class);
	static {
		Log4jConfigurations.configure();
		logger.debug("log4j is enabled");
	}
	
	public EmployeeRegistrationException(String message) {
	    super(message);
	    logger.info("CustomExcetion is raised "+this.getMessage());
	}

}
