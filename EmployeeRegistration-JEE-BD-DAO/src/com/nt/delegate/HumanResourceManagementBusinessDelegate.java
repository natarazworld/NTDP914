package com.nt.delegate;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.log4j.Logger;

import com.nt.bo.FinanceEmployeeBO;
import com.nt.bo.HREmployeeBO;
import com.nt.commons.Log4jConfigurations;
import com.nt.dao.EmployeeDAO;
import com.nt.error.EmployeeRegistrationException;
import com.nt.facatory.DBConnectionFactory;
import com.nt.facatory.EmployeeDAOFactory;
import com.nt.vo.EmployeeVO;

public class HumanResourceManagementBusinessDelegate {
	private static Logger logger=Logger.getLogger(HumanResourceManagementBusinessDelegate.class);
	static {
		Log4jConfigurations.configure();
		logger .debug("log4j enabled");
	}
	
	   public String  registerEmployee(EmployeeVO vo) throws EmployeeRegistrationException{
		      HREmployeeBO  hbo=null;  
		      FinanceEmployeeBO fbo=null;		    
		      Connection con=null;
		      EmployeeDAO  hrDAO=null,financeDAO=null;
		      int count1=0,count2=0;
		      boolean flag=false;
		      logger.debug("start of  registerEmployee(-) method"); 
		   try {
			   //convert VO class obj to  BO objes  //use Case1
			   hbo=new HREmployeeBO();
			   hbo.setEname(vo.getEname());
			   hbo.setEadd(vo.getEadd());
			   hbo.setDesg(vo.getDesg());
			   
			   fbo=new FinanceEmployeeBO();
			   fbo.setEname(vo.getEname());
			   fbo.setDesg(vo.getDesg());
			   fbo.setSalary(Float.parseFloat(vo.getSalary()));
			   logger.info("VO class object data is converted to BO class objects data");
		   }
		   catch(NumberFormatException nfe) {
			   nfe.printStackTrace();
			   logger.error("problem is converting VO salary to  bo salary--->"+nfe.getMessage());
			   throw nfe;
		   }
		   catch(Exception e) {
			   e.printStackTrace();
			   logger.fatal("unknown problem in converting VO class obj to BO class objects");
			   throw e;
		   }
		   try {
			   //get Pooled jdbc con object
			   con=DBConnectionFactory.getPooledConnection(); //usecase3
			   logger.info("recived  pooled jdbc object");
			   //begin Tx by disabling  AutoCommit mode
			   con.setAutoCommit(false);  //use case3
			   logger.debug("Tx has begun");
			   //use both dao ....  perform transaction operations
			   hrDAO=EmployeeDAOFactory.getInstance("hr");
			   financeDAO=EmployeeDAOFactory.getInstance("finance");
			   logger.debug("DAO calss objects are gathered from factory");
		        count1=hrDAO.insert(hbo, con);   //usecase3
		        count2=financeDAO.insert(fbo, con);  //usecase3
		        logger.debug("DAO class methods are called");
		        if(count1!=0 &&  count2!=0)
		        	   flag=true;
		        else
		        	flag=false;
		   }
		   catch(SQLException se) {
			   flag=false;
			   se.printStackTrace();
			   logger.error("DB problem in Business Delegate "+se.getMessage());
			   throw  new EmployeeRegistrationException(se.getMessage());  //usecase2
		   }
		   catch(NamingException ne) {
			   flag=false;
			   ne.printStackTrace();
			   logger.error("Jndi problem in Business Delegate "+ne.getMessage());
			   throw new EmployeeRegistrationException(ne.getMessage());  //usecase2
		   }
		   catch(Exception e) {
			   flag=false;
			   e.printStackTrace();
			   logger.error("unkonwn problem in Business Delegate "+e.getMessage());
			   throw new EmployeeRegistrationException(e.getMessage());  //usecase
		    }
		   finally {
			   //perform Transaction mgmt
			   try {  
				    if(con!=null) {
				    	if(flag) {
				    		con.commit();  //usecase3
				    		logger.info("Tx committed");
				    	}
				    	else {
				    		con.rollback();  //usecase3
				    		logger.info("Tx rolled back");
				    	}
				    }//if
			   }//try
				    catch(SQLException se) {
				    	 se.printStackTrace();
				    	 logger.error("Problem in  Transaction management ::"+se.getMessage());
						   throw new EmployeeRegistrationException(se.getMessage());  //usecase2
				    }
				    //return jdbc con object back to jdbc con pool
				   try { 
				    if(con!=null) {
				    	con.close();
				    	logger.debug("con object is relased back to jdbc con pool");
				     }
				   }
				   catch(SQLException se) {
					   se.printStackTrace();
					   logger.debug("Problem in releasing jdbc con object..");
					   throw new  EmployeeRegistrationException(se.getMessage());  //usecase2
				   }
				   
		   }//finally
		   
			   if(flag)
				   return "Employeee Regisration succeded";
			   else
				   return "Employee Registration failed";
		   
	   }//method
}//class
