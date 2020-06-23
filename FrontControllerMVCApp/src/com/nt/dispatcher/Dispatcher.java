package com.nt.dispatcher;

import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Dispatcher {
	private static ResourceBundle bundle;
	static {
		bundle=ResourceBundle.getBundle("com/nt/commons/config");
	}
	
	// To render control to physical jsp file name
	public static void  render(HttpServletRequest req,HttpServletResponse res,String lvn) throws Exception{
		  String view=null;
		  RequestDispatcher rd=null;
		  //get the physical view  name
		  view=bundle.getString(lvn);
		  //render to physical view comp
		  rd=req.getRequestDispatcher(view);
		  rd.forward(req, res);
	}

}
