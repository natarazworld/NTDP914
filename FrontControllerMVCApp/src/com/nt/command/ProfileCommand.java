package com.nt.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.ProfileDTO;
import com.nt.service.ProfileMgmtBusinessDelegate;
import com.nt.service.ProlileMgmtBusinessDelegateImpl;
import com.nt.vo.ProfileVO;

public class ProfileCommand implements Command {
	  private ProfileMgmtBusinessDelegate delegate;
	public ProfileCommand() {
		delegate=new ProlileMgmtBusinessDelegateImpl();
	}

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		int id=0;
		ProfileDTO dto=null;
		ProfileVO vo=null;
		//read inputs
		id=Integer.parseInt(req.getParameter("id"));
		//use Business Delegate
		dto=delegate.fetchProfileById(id);
		//convert dto to VO
		vo=new ProfileVO();
		vo.setId(String.valueOf(dto.getId()));
		vo.setName(dto.getName());
		vo.setDesg(dto.getDesg());
		vo.setDob(dto.getDob().toString());
		vo.setIncome(String.valueOf(dto.getIncome()));
		vo.setAddrs(dto.getAddrs());
		//keep results in request scope
		req.setAttribute("profileInfo",vo);
		//return lvn
			return "show_profile";
	}

}
