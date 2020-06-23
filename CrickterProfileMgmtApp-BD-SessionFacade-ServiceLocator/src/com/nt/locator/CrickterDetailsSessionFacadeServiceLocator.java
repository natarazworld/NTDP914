package com.nt.locator;

import java.util.HashMap;
import java.util.Map;

import com.nt.dto.CricketerInputsDTO;
import com.nt.dto.CricketerProfileDTO;
import com.nt.sessionfacade.CricketerDetailsFinderSessionFacade;
import com.nt.sessionfacade.CricketerDetailsFinderSessionFacadeImpl;

public class CrickterDetailsSessionFacadeServiceLocator {
	private static CrickterDetailsSessionFacadeServiceLocator  INSTANCE;
	private  Map<String,CricketerDetailsFinderSessionFacade> cacheMap=new HashMap();
	
	private CrickterDetailsSessionFacadeServiceLocator() {
		//no operations
	}
	
	public static CrickterDetailsSessionFacadeServiceLocator  getInstance() {
		    if(INSTANCE==null)
		    	INSTANCE=new CrickterDetailsSessionFacadeServiceLocator();
		    
		    return INSTANCE;
	}
	
	public  CricketerDetailsFinderSessionFacade  getSessionFacadeRef(String jndi) {
		 CricketerDetailsFinderSessionFacade facade=null;
		   if(!cacheMap.containsKey(jndi)) {
			   //actually we should write jndi lookup code here.. since we have taken
			   //SessionFacade as ordinay java class we are going to develop it as normal
			   // object creation operation
			   facade=new CricketerDetailsFinderSessionFacadeImpl();
			   cacheMap.put(jndi, facade);
		   }
		   return cacheMap.get(jndi);
	}
	
	
	

}
