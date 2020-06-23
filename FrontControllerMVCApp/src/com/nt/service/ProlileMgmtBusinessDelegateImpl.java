package com.nt.service;

import com.nt.bo.ProfileBO;
import com.nt.dao.PRofileDAOImpl;
import com.nt.dao.ProfileDAO;
import com.nt.dto.ProfileDTO;

public class ProlileMgmtBusinessDelegateImpl implements ProfileMgmtBusinessDelegate {
	  private ProfileDAO dao;
	public ProlileMgmtBusinessDelegateImpl() {
        dao=new PRofileDAOImpl();		
	}

	@Override
	public ProfileDTO fetchProfileById(int id) {
		ProfileDTO dto=null;
		ProfileBO bo=null;
		  //use dAO
		bo=dao.getProfileById(id);
		//convert bo to dto
		dto=new ProfileDTO();
		dto.setId(bo.getId());
		dto.setName(bo.getName());
		dto.setIncome(bo.getIncome());
		dto.setDesg(bo.getDesg());
		dto.setAddrs(bo.getAddrs());
		dto.setDob(bo.getDob());
		return dto;
	}

}
