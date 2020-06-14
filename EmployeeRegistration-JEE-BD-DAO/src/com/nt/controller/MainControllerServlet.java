package com.nt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.nt.commons.Log4jConfigurations;
import com.nt.delegate.HumanResourceManagementBusinessDelegate;
import com.nt.error.EmployeeRegistrationException;
import com.nt.vo.EmployeeVO;

@WebServlet("/controller")
public class MainControllerServlet extends HttpServlet {
	private static Logger logger=Logger.getLogger(MainControllerServlet.class);
	static {
		Log4jConfigurations.configure();
		logger.debug("log4 is activated ");
	}
	HumanResourceManagementBusinessDelegate delegate=null;
	public void init() throws ServletException {
		delegate=new HumanResourceManagementBusinessDelegate();
		logger.debug("Business Delegate class object is created");
	}

	public void destroy() {
	   delegate=null;
	  logger.debug("Business Delegate class object is nullified");
	}


	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
         EmployeeVO vo=null;
         String result=null;
         RequestDispatcher rd=null;
         logger.debug("start of doGet(-,-)");
		//read form data and convert to VO class object
         vo=new EmployeeVO();
         vo.setEname(req.getParameter("ename"));
		vo.setEadd(req.getParameter("eadd"));
		vo.setDesg(req.getParameter("edesg"));
		vo.setSalary(req.getParameter("esalary"));
		logger.debug("form data is stored into Vo class object");
		//use Business Delegate
		try {
			result=delegate.registerEmployee(vo);
			logger.debug("BusinessDelegate method is invoked");
			//keep result in request scope
			req.setAttribute("resultMsg",result);
			logger.debug("results are kept in reques scope");
			//froward to result.jsp
			rd=req.getRequestDispatcher("/result.jsp");
			rd.forward(req,res);
			logger.debug("forwarded to  result page");
		}
		catch(EmployeeRegistrationException  ere) {
			//forward to error page
		   req.setAttribute("errorMsg",ere.getMessage())	;	   
		   logger.debug("errors are kept in reques scope");
			rd=req.getRequestDispatcher("/error.jsp");
			rd.forward(req,res);
			logger.error("forwarded to  error page");
		}
		catch(Exception e) {
			//forward to error page
			   req.setAttribute("errorMsg",e.getMessage())	;	   
			   logger.debug("errors are kept in reques scope");
				rd=req.getRequestDispatcher("/error.jsp");
				rd.forward(req,res);
				logger.fatal("forwarded to  error page");
		}
		logger.debug("end of doGet(-,-) method");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.debug("doPost(-,-)");
		doGet(req, res);
		
	}

}
