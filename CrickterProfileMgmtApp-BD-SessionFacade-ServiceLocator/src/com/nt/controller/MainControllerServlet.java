package com.nt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.delegate.CricketerProfileManagmentBusinessDelegateImpl;
import com.nt.delegate.CricketerProfileMgmtBusinessDelegate;
import com.nt.errors.ProfileManagementException;
import com.nt.vo.CricketerInputsVO;
import com.nt.vo.CricketerProfileVO;

@WebServlet("/controller")
public class MainControllerServlet extends HttpServlet {
   CricketerProfileMgmtBusinessDelegate delegate;
	@Override
	public void init() throws ServletException {
	   //create BusinessDelegate object
		delegate=new CricketerProfileManagmentBusinessDelegateImpl();
		}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   CricketerInputsVO ipVO=null;
	   CricketerProfileVO profileVO=null;
	   RequestDispatcher rd=null;
		//read form data and store into VO class object
	   ipVO=new CricketerInputsVO();
	   ipVO.setNickname(req.getParameter("name"));
	   ipVO.setCountry(req.getParameter("country"));
	   try {
		   //invoke methods on busness Delegate
		   profileVO=delegate.fetchCrickterProfileByName(ipVO);
		   //keep results in requst scope
		   req.setAttribute("profile", profileVO);
		   //forward reuslt page
		   rd=req.getRequestDispatcher("/result.jsp");
		   rd.forward(req,res);
	   }
	   catch(ProfileManagementException pme) {
		   req.setAttribute("errMsg",pme.getMessage());
		   rd=req.getRequestDispatcher("/error.jsp");
		   rd.forward(req,res);
	   }//catch
		
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	 doGet(req,res);
	}
	
	@Override
	public void destroy() {
	    delegate=null;
	}
	
}
