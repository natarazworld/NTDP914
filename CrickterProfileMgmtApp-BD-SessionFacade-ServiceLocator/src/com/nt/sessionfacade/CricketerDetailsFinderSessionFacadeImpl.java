package com.nt.sessionfacade;

import com.nt.dto.CricketerIdDTO;
import com.nt.dto.CricketerInputsDTO;
import com.nt.dto.CricketerProfileDTO;
import com.nt.extcomp1.CricketerIdFinderComp;
import com.nt.extcomp1.CricketerIdFinderCompImpl;
import com.nt.extcomp2.CricketerProfileFinderComp;
import com.nt.extcomp2.CricketerProfileFinderCompImpl;

public class CricketerDetailsFinderSessionFacadeImpl  implements CricketerDetailsFinderSessionFacade {
    
	public  CricketerProfileDTO  fetchProfileById(CricketerInputsDTO  ipDTO) {
    	CricketerIdFinderComp extComp1=null;
    	CricketerProfileFinderComp extComp2=null;
    	CricketerIdDTO idDTO=null;
    	CricketerProfileDTO  profileDTO=null;
    	//invoke extenal comp1 ,external comp2  methods
    	extComp1=new CricketerIdFinderCompImpl() ;
    	extComp2=new CricketerProfileFinderCompImpl();
    	//invoking methods  of external services
    	idDTO=extComp1.findIdByName(ipDTO);
    	profileDTO=extComp2.getProfileById(idDTO);
    	
    	return profileDTO;
    	   	
    }
}
    	
    	
