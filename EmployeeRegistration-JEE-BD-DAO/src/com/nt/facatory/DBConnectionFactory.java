package com.nt.facatory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.nt.commons.Log4jConfigurations;

public class DBConnectionFactory {
	private static Logger logger=Logger.getLogger(DBConnectionFactory.class);
	private static Properties  dbProps=null;
	static {
		ResourceBundle bundle=null;
	    Set<String> keySet=null;
		Log4jConfigurations.configure();
		logger.debug("log4j activated");
		try {
			//get jndi name from  jdbc.proeprties and store into java.util.Properties collection
			bundle=ResourceBundle.getBundle("com/nt/commons/jdbc");
			keySet=bundle.keySet();
			dbProps=new Properties();
			for(String key:keySet) {
				dbProps.put(key,bundle.getString(key));
			}
			logger.info("jdbc.properties file info is copied to  Properties collection" );
					
		}
		catch(Exception e) {
			logger.fatal("Problem in locating and reading properties file");
			e.printStackTrace();
		}
	}
	
	public  static  Connection  getPooledConnection()throws SQLException,NamingException{
		Connection con=null;
		InitialContext ic=null;
		DataSource ds=null;
		logger.debug("statr of getPooledConnection()");
		
		try {
			//create InitialContext object
			ic=new InitialContext();
			logger.debug("InitialContext object is creatd");
			//get DataSource object ref  from Jndi registry
			ds=(DataSource) ic.lookup(dbProps.getProperty("jdbc.datasource.jndi"));
			logger.debug("DataSource obj is gathered from jndi registry");
			//get Pooled Connection
			con=ds.getConnection();
			logger.info("Pooled jdbc con object is gathered from jdbc con pool");
		}
		catch(SQLException se) {
			logger.error("Known DB Problem-->"+se.getMessage());
			se.printStackTrace();
			throw se;
		}
		catch(NamingException ne) {
			logger.error("Known Jndi Problem-->"+ne.getMessage());
			ne.printStackTrace();
			throw ne;
		}
		catch(Exception e) {
			logger.fatal("Unknow  Problem --->"+e.getMessage());
			e.printStackTrace();
			throw e;
		}
		logger.debug("end of  getPooledConnection() method");
		return con;
	}
	

}
