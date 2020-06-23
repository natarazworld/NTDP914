package com.nt.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nt.dto.UserDetailsDTO;

@WebServlet("/loginurl")
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	     String uname=null,pwd=null;
	    HttpSession ses=null;
	    UserDetailsDTO  details=null;
	    RequestDispatcher rd=null;
		//read form data
	     uname=req.getParameter("user").trim();
	     pwd=req.getParameter("pwd").trim();
	     // get/create  Session
	     ses=req.getSession(true);
	     //perform authentication 
	     if(uname.equalsIgnoreCase("raja") && pwd.equalsIgnoreCase("rani")) {
	    	 //store in the session
	    	 details=new UserDetailsDTO();
	    	 details.setUname(uname); details.setPwd(pwd);
	    	 ses.setAttribute("userDetails",details);
	    	 //foward to Inbox Page
	    	 rd=req.getRequestDispatcher("/inbox.jsp");
	    	rd.forward(req,res);
	     }//if
	     else {
	    	 req.setAttribute("errMsg","Invalid Credentials");
	    	//foward to login Page
	    	 rd=req.getRequestDispatcher("/login.jsp");
	    	rd.forward(req,res);
	     }
				
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
