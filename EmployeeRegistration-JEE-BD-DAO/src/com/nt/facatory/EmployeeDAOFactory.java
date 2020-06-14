package com.nt.facatory;

import org.apache.log4j.Logger;

import com.nt.commons.Log4jConfigurations;
import com.nt.dao.EmployeeDAO;
import com.nt.dao.FiinanceEmployeeDAOImpl;
import com.nt.dao.HREmployeeDAOImpl;

public class EmployeeDAOFactory {
	 private static Logger logger=Logger.getLogger(EmployeeDAOFactory.class);
	static {
		Log4jConfigurations.configure();
		logger.debug("log4j is enabled");
	}
	
	public  static  EmployeeDAO  getInstance(String type) {
		logger.debug("getInstance(-) of EmloyeeDAO Factory class");
		   if(type.equalsIgnoreCase("hr")) {
			 logger.debug("HRemployeeDAOImpl class object is returned");
			   return  new HREmployeeDAOImpl();
		   }
		   else {
			   logger.debug("FinanceEmployeeDAOImpl class object is returned");
			   return new  FiinanceEmployeeDAOImpl();
			  
		   }
	}

}
