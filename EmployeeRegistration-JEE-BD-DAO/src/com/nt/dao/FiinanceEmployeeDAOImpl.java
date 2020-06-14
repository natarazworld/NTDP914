package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.nt.bo.BaseEmployeeBO;
import com.nt.bo.FinanceEmployeeBO;
import com.nt.commons.Log4jConfigurations;

public class FiinanceEmployeeDAOImpl implements EmployeeDAO {
   private static final String FINANCE_EMPLOYEE_INSERT_QUERY="INSERT INTO BD_FINANCE_EMPLOYEE VALUES(BD_EMPNO_SEQ.CURRVAL,?,?,? )";
 private static Logger logger=Logger.getLogger(FiinanceEmployeeDAOImpl.class);
  static {
	  //activate log4j  
	   Log4jConfigurations.configure();
	   logger.debug("log4j is enabled");
  }
    @Override
	public int insert(BaseEmployeeBO bo,Connection con) throws SQLException {
		PreparedStatement ps=null;
		int count=0;
		logger.debug("start of insert(-,1); method");
		try {
			//create PreparedStatement objct
			ps=con.prepareStatement(FINANCE_EMPLOYEE_INSERT_QUERY);
			//set values to query params
			ps.setString(1, bo.getEname());
			ps.setString(2,bo.getDesg());
			ps.setFloat(3, ((FinanceEmployeeBO)bo).getSalary());
			
			logger.debug("inputs are set to query params");
			//execut the query
			count=ps.executeUpdate();
			logger.debug("query executed" );
		}
		catch(SQLException se) {
			se.printStackTrace();
			logger.error("Problem in insert operations"+se.getMessage());
			throw se;
				
		}
		catch(Exception e) {
			e.printStackTrace();
			logger.fatal("unProblem in insert operations"+e.getMessage());
			throw e;
		}
		return count;
	}

}
