package com.nt.delegate;

import com.nt.dto.CricketerInputsDTO;
import com.nt.dto.CricketerProfileDTO;
import com.nt.errors.ProfileManagementException;
import com.nt.locator.CrickterDetailsSessionFacadeServiceLocator;
import com.nt.sessionfacade.CricketerDetailsFinderSessionFacade;
import com.nt.vo.CricketerInputsVO;
import com.nt.vo.CricketerProfileVO;

public class CricketerProfileManagmentBusinessDelegateImpl implements CricketerProfileMgmtBusinessDelegate {

	@Override
	public CricketerProfileVO fetchCrickterProfileByName(CricketerInputsVO ipVO) throws ProfileManagementException {
		CricketerInputsDTO ipDTO=null;
		CrickterDetailsSessionFacadeServiceLocator locator=null;
		CricketerProfileDTO profileDTO=null;
		CricketerDetailsFinderSessionFacade facade=null;
		CricketerProfileVO  profileVO=null;
		//convert inputsVO to inputsDTO
		ipDTO=new CricketerInputsDTO();
		ipDTO.setNickname(ipVO.getNickname());
		ipDTO.setCountry(ipVO.getCountry());
		//get Service Locator objeect
		locator=CrickterDetailsSessionFacadeServiceLocator.getInstance();
		//get Sessionfactory ref
		facade=locator.getSessionFacadeRef("bse");
		try {
			//invoke session method
			profileDTO=facade.fetchProfileById(ipDTO);
			//covert profileDTO to profileVO
			profileVO=new CricketerProfileVO();
			profileVO.setCountry(profileDTO.getCountry());
			profileVO.setNickname(profileDTO.getNickname());
			profileVO.setBattingAvg(String.valueOf(profileDTO.getBattingAvg()));
			profileVO.setBowlingAvg(String.valueOf(profileDTO.getBowlingAvg()));
		  profileVO.setCricketerId(String.valueOf(profileDTO.getCrickterId()));
		  profileVO.setDob(profileDTO.getDob().toString());
		  profileVO.setFullName(profileDTO.getFullName());
		  profileVO.setInnigsCount(String.valueOf(profileDTO.getInnigsCount()));
		  profileVO.setMatchesCount(String.valueOf(profileDTO.getMatchesCount()));
		  profileVO.setRuns(String.valueOf(profileDTO.getRuns()));
		  profileVO.setWicketsCount(String.valueOf(profileDTO.getWicketsCount()));
		  profileVO.setAddrs(profileDTO.getAddrs());
		  profileVO.setStatus(profileDTO.getStatus());
		}//try
		catch(IllegalArgumentException iae) {
			iae.printStackTrace();
			throw  new ProfileManagementException(iae.getMessage());
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new ProfileManagementException(e.getMessage());
		}
		
		return profileVO;
	}//method

}//class
