package com.nt.extcomp2;

import java.util.Date;

import com.nt.dto.CricketerIdDTO;
import com.nt.dto.CricketerProfileDTO;

public class CricketerProfileFinderCompImpl implements CricketerProfileFinderComp {

	@Override
	public CricketerProfileDTO getProfileById(CricketerIdDTO idDTO) {
		CricketerProfileDTO  profileDTO=null;
		if(idDTO.getCrickterId()==1234) {
			profileDTO=new CricketerProfileDTO();
			profileDTO.setNickname(idDTO.getNickname());
			profileDTO.setCountry(idDTO.getCountry());
			profileDTO.setCrickterId(idDTO.getCrickterId());
			profileDTO.setFullName("Sachin Ramesh Tendulkar");
			profileDTO.setAddrs("Bombay-->India");
			profileDTO.setDob(new Date(73,3,24));
			profileDTO.setBattingAvg(53.78f);
			profileDTO.setBowlingAvg(23.22f);
			profileDTO.setInnigsCount(737);
			profileDTO.setMatchesCount(463);
			profileDTO.setRuns(53000);
			profileDTO.setWicketsCount(154);
			profileDTO.setStatus("retired");
		}
		else if (idDTO.getCrickterId()==4567) {
			profileDTO=new CricketerProfileDTO();
			profileDTO.setNickname(idDTO.getNickname());
			profileDTO.setCountry(idDTO.getCountry());
			profileDTO.setCrickterId(idDTO.getCrickterId());
			profileDTO.setFullName("Virat Kohli");
			profileDTO.setAddrs("Delhi-->India");
			profileDTO.setDob(new Date(88,10,5));
			profileDTO.setBattingAvg(59.3f);
			profileDTO.setBowlingAvg(112.66f);
			profileDTO.setInnigsCount(400);
			profileDTO.setMatchesCount(250);
			profileDTO.setRuns(21000);
			profileDTO.setWicketsCount(8);
			profileDTO.setStatus("active");
		}
		else if(idDTO.getCrickterId()==3456) {
			profileDTO=new CricketerProfileDTO();
			profileDTO.setNickname(idDTO.getNickname());
			profileDTO.setCountry(idDTO.getCountry());
			profileDTO.setCrickterId(idDTO.getCrickterId());
			profileDTO.setFullName("Rohit Sharma");
			profileDTO.setAddrs("Mumbai-->India");
			profileDTO.setDob(new Date(87,3,30));
			profileDTO.setBattingAvg(49.3f);
			profileDTO.setBowlingAvg(103.22f);
			profileDTO.setInnigsCount(270);
			profileDTO.setMatchesCount(256);
			profileDTO.setRuns(19000);
			profileDTO.setWicketsCount(11);
			profileDTO.setStatus("active");
		}
		else if(idDTO.getCrickterId()==9999) {
			profileDTO=new CricketerProfileDTO();
			profileDTO.setNickname(idDTO.getNickname());
			profileDTO.setCountry(idDTO.getCountry());
			profileDTO.setCrickterId(idDTO.getCrickterId());
			profileDTO.setFullName("Mahendra singh dhohi");
			profileDTO.setAddrs("ranchi-->India");
			profileDTO.setDob(new Date(81,7,6));
			profileDTO.setBattingAvg(50.53f);
			profileDTO.setBowlingAvg(31);
			profileDTO.setInnigsCount(441);
			profileDTO.setMatchesCount(440);
			profileDTO.setRuns(17226);
			profileDTO.setWicketsCount(1);
			profileDTO.setStatus("active");
		}
		else {
			throw new IllegalArgumentException("invalid crickter Id or nick name");
		}
		
		return profileDTO;
	}

}
