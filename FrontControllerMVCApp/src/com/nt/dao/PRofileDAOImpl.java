package com.nt.dao;

import java.util.Date;

import com.nt.bo.ProfileBO;

public class PRofileDAOImpl implements ProfileDAO {

	@Override
	public ProfileBO getProfileById(int id) {
	    ProfileBO bo=null;
	    bo=new ProfileBO();
	    bo.setId(id);
	    bo.setName("raja");
	    bo.setDob(new Date(90,10,20));
	    bo.setDesg("CLERK");
	    bo.setIncome(90000);
	    bo.setAddrs("hyd");
	    return bo;
	}

}
