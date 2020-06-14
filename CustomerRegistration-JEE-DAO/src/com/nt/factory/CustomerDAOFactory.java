package com.nt.factory;

import com.nt.dao.CustomerDAO;
import com.nt.dao.CustomerDAOImpl;

public class CustomerDAOFactory {
	
	public static CustomerDAO  getInstance(String dbType) {
		if(dbType.equalsIgnoreCase("oracle"))
		   return new CustomerDAOImpl();	
		else
			throw new IllegalArgumentException("invalid Db type");
	}

}
