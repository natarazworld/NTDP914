package com.nt.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.nt.bo.CustomerBO;
import com.nt.dao.CustomerDAO;
import com.nt.dto.CustomerDTO;
import com.nt.factory.CustomerDAOFactory;

public class BankOperationsServiceImpl implements BankOperationsService {
	private static Properties props;
	private static Logger logger=Logger.getLogger(BankOperationsServiceImpl.class);
	static {
		try {
			PropertyConfigurator.configure("src/com/nt/commons/log4j.properties");
			InputStream is=new FileInputStream("src/com/nt/commons/jdbc.properties");
			props=new Properties();
			props.load(is);
			logger.debug("properties files are loaded");
		}//try
		catch(IOException ioe) {
			logger.error("Problem in Locating Properties files");
			ioe.printStackTrace();
		}
		catch(Exception e) {
			logger.fatal("unknown problem in Locating properties file");
			e.printStackTrace();
		}
	}
	
	

	@Override
	public String registerCustomer(CustomerDTO dto) throws Exception {
		float intrAmt=0.0f;
	    CustomerBO bo=null;
	    CustomerDAO dao=null;
		int count=0;
		logger.debug("start of  registerCustomer(-)");
	    //write b.logic  to calculate simple intrest amount
		intrAmt=(dto.getpAmt()*dto.getRate()*dto.getTime())/100.0f;
		logger.debug("b.logic execution to calculate intreset amount");
		//convert DTO to BO
		bo=new CustomerBO();
		bo.setCname(dto.getCname());
		bo.setCadd(dto.getCadd());
		bo.setIntrAmt(intrAmt);
	    bo.setpAmt(dto.getpAmt());
	    logger.debug("DTO is converted into  BO");
	    //get DAO class object
	    dao=CustomerDAOFactory.getInstance(props.getProperty("jdbc.dbType"));
	    logger.debug("DAO is gahtered from DAO FACtory");
	    //use DAO
	    count=dao.insert(bo);
	   logger.debug("DAO is used for persistence operations");
	    //process the result
	    if(count==0)
	    	return "Customer Registration failed";
	    else
	    	return "Customer Registration succeded::: Intrest amount"+intrAmt;
		
	}

}
