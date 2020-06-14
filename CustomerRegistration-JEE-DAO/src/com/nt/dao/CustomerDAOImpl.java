package com.nt.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.nt.bo.CustomerBO;
import com.nt.factory.DBConnectionFactory;

public class CustomerDAOImpl implements CustomerDAO {
	private static final String  CUSTOMER_INSERT_QUERY="INSERT INTO JEE_DP_CUSTOMER VALUES(CNO_SEQ.NEXTVAL,?,?,?,?)";
	private static Properties props=null;
	 private static Logger logger =Logger.getLogger(CustomerDAOImpl.class);
		static {
		InputStream is=null;
		try {
			//Load log4j properties
			PropertyConfigurator.configure("src/com/nt/commons/log4j.properties");
                
			//Load jdbc.proeprties file and store its content to java.util.Properties collection
		   is=new FileInputStream("src/com/nt/commons/jdbc.properties");
		   props=new Properties();
		   props.load(is);
		    logger.debug("jdbc.properites info is stored in to java.util.Properties class object");   
		}
		catch(FileNotFoundException fnf) {
			logger.error("Problem in loacating properties file infio");
			fnf.printStackTrace();
		}
		catch(IOException ioe) {
			logger.error("Problem in loading and reading  propertiesf ile info");
			ioe.printStackTrace();
		}
		catch(Exception e) {
			logger.fatal("unknown problem towards properties file");
			e.printStackTrace();
		}
	}
	

	@Override
	public int insert(CustomerBO bo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		logger.debug("start of  insert(-) method");
		try {
		  //get jdbc con object
			con=DBConnectionFactory.getConnection(props.getProperty("jdbc.url"),
					                                                                                 props.getProperty("jdbc.username"),
					                                                                                 props.getProperty("jdbc.password"));
			logger.info("Connection is established using the support of ConnectionFactory ");
			//crreate PrpeparedStatement object
			ps=con.prepareStatement(CUSTOMER_INSERT_QUERY);
			logger.debug("PreparedStatement obj is created");
			//set query param values
			ps.setString(1,bo.getCname());
			ps.setString(2,bo.getCadd());
			ps.setFloat(3,bo.getpAmt());
			ps.setFloat(4,bo.getIntrAmt());
			logger.debug("setting values to query params");
			//execute the query
			result=ps.executeUpdate();
			logger.debug("query executed");
		}
		catch(SQLException se) {
			logger.error("propblem in inserting record" );
			se.printStackTrace();
			throw se;
		}
		catch(Exception  e) {
			logger.fatal("unknown problem" );
			e.printStackTrace();
			throw e;
		}
		finally {
			logger.debug("closing jdbc objects");
			try {
				if(ps!=null)
					ps.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}//finally
		logger.debug("end insert(-,-) method"); 
		return result;
	}//method

}
