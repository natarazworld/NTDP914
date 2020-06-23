package com.nt.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter({"/inbox.jsp"})
public class UserSessionCheckingFilter extends HttpFilter  {
       
   
	public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpSession ses=null;
		RequestDispatcher rd=null;
		//get Session
		ses=req.getSession(false);
		if(ses!=null && ses.getAttribute("userDetails")!=null)
	          	chain.doFilter(req, res);
		else {
			req.setAttribute("errMsg", "you can not give direct request to inbox page..");
			//foward to login.jsp
			rd=req.getRequestDispatcher("/login.jsp");
			rd.forward(req,res);
		}
	}//doFilter(-,-)

	
}
