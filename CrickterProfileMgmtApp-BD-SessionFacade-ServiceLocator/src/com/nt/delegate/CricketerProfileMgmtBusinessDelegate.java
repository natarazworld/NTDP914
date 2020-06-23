package com.nt.delegate;

import com.nt.errors.ProfileManagementException;
import com.nt.vo.CricketerInputsVO;
import com.nt.vo.CricketerProfileVO;

public interface CricketerProfileMgmtBusinessDelegate {
	
	  public   CricketerProfileVO   fetchCrickterProfileByName(CricketerInputsVO vo)throws ProfileManagementException;

}
