package com.nt.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class DBConnectionFactory {
	private static Logger logger=Logger.getLogger(DBConnectionFactory.class);
	static {
		PropertyConfigurator.configure("src/com/nt/commons/log4j.properties");
		logger.debug("log4j activated");
	}
	
	public  static  Connection  getConnection(String url,String user,String pwd)throws SQLException{
		Connection con=null;
		logger.debug("statr of getConnection()");
		try {
			con=DriverManager.getConnection(url, user,pwd);
			logger.info("Connection established with Db s/w");
		}
		catch(SQLException se) {
			logger.error("Known DB Problem-->"+se.getMessage());
			se.printStackTrace();
			throw se;
		}
		catch(Exception e) {
			logger.fatal("Unknow  Problem --->"+e.getMessage());
			e.printStackTrace();
			throw e;
		}
		logger.debug("end of  getConnection() method");
		return con;
	}
	

}
