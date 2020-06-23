package com.nt.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.command.Command;
import com.nt.command.CommandMapper;
import com.nt.dispatcher.Dispatcher;

@WebServlet("*.do")
public class MainFrontControllerServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uri=null;
		Command cmd=null;
		String lvn=null;
		try {
		//get requst uri
		uri=req.getServletPath();
		//get Command class object
		cmd=CommandMapper.getInstance(uri);
		//invoke execute(-,-) method
		lvn=cmd.execute(req, res);
			//use Dispatcher
			Dispatcher.render(req, res, lvn);
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost(-,-)

}
