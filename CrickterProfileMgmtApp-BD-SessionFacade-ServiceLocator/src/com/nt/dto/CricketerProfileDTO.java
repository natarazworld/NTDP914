package com.nt.dto;

import java.util.Date;

public class CricketerProfileDTO extends CricketerIdDTO {
	private String fullName;
	private  String status;
	private  Date dob;
	private  String addrs;
	private  int  runs;
	private  int innigsCount;
	private  float battingAvg;
	private  int  wicketsCount;
	private  int matchesCount;
	private   float bowlingAvg;
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAddrs() {
		return addrs;
	}
	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}
	public int getRuns() {
		return runs;
	}
	public void setRuns(int runs) {
		this.runs = runs;
	}
	public int getInnigsCount() {
		return innigsCount;
	}
	public void setInnigsCount(int innigsCount) {
		this.innigsCount = innigsCount;
	}
	public float getBattingAvg() {
		return battingAvg;
	}
	public void setBattingAvg(float battingAvg) {
		this.battingAvg = battingAvg;
	}
	public int getWicketsCount() {
		return wicketsCount;
	}
	public void setWicketsCount(int wicketsCount) {
		this.wicketsCount = wicketsCount;
	}
	public int getMatchesCount() {
		return matchesCount;
	}
	public void setMatchesCount(int matchesCount) {
		this.matchesCount = matchesCount;
	}
	public float getBowlingAvg() {
		return bowlingAvg;
	}
	public void setBowlingAvg(float bowlingAvg) {
		this.bowlingAvg = bowlingAvg;
	}
	
	

}
