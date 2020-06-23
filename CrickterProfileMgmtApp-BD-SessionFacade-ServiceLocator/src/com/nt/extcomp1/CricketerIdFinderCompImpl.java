package com.nt.extcomp1;

import com.nt.dto.CricketerIdDTO;
import com.nt.dto.CricketerInputsDTO;

public class CricketerIdFinderCompImpl implements CricketerIdFinderComp {

	@Override
	public CricketerIdDTO findIdByName(CricketerInputsDTO ipDTO) {
		CricketerIdDTO  idDTO=null;
		if(ipDTO.getNickname().equalsIgnoreCase("sachin")){
			idDTO=new CricketerIdDTO();
			idDTO.setNickname(ipDTO.getNickname());
			idDTO.setCountry(ipDTO.getCountry());
			idDTO.setCrickterId(1234);
		}
		else if(ipDTO.getNickname().equalsIgnoreCase("kohli")) {
			idDTO=new CricketerIdDTO();
			idDTO.setNickname(ipDTO.getNickname());
			idDTO.setCountry(ipDTO.getCountry());
			idDTO.setCrickterId(4567);
		}
		else if(ipDTO.getNickname().equalsIgnoreCase("rohit")) {
			idDTO=new CricketerIdDTO();
			idDTO.setNickname(ipDTO.getNickname());
			idDTO.setCountry(ipDTO.getCountry());
			idDTO.setCrickterId(3456);
		}
		else if(ipDTO.getNickname().equalsIgnoreCase("dhoni")) {
			idDTO=new CricketerIdDTO();
			idDTO.setNickname(ipDTO.getNickname());
			idDTO.setCountry(ipDTO.getCountry());
			idDTO.setCrickterId(9999);
		}
		else {
			throw new IllegalArgumentException("Invalid nickname of Cricketer");
		}
			
		return idDTO;
	}

}
