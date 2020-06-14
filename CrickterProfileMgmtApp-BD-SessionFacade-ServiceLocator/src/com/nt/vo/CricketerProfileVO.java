package com.nt.vo;

import java.util.Date;

public class CricketerProfileVO extends CricketerInputsVO {
   private  String cricketerId;
	private String fullName;
	private  String status;
	private  String dob;
	private  String addrs;
	private  String  runs;
	private  String innigsCount;
	private  String battingAvg;
	private  String  wicketsCount;
	private  String matchesCount;
	private   String bowlingAvg;
	public String getCricketerId() {
		return cricketerId;
	}
	public void setCricketerId(String cricketerId) {
		this.cricketerId = cricketerId;
	}
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
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAddrs() {
		return addrs;
	}
	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}
	public String getRuns() {
		return runs;
	}
	public void setRuns(String runs) {
		this.runs = runs;
	}
	public String getInnigsCount() {
		return innigsCount;
	}
	public void setInnigsCount(String innigsCount) {
		this.innigsCount = innigsCount;
	}
	public String getBattingAvg() {
		return battingAvg;
	}
	public void setBattingAvg(String battingAvg) {
		this.battingAvg = battingAvg;
	}
	public String getWicketsCount() {
		return wicketsCount;
	}
	public void setWicketsCount(String wicketsCount) {
		this.wicketsCount = wicketsCount;
	}
	public String getMatchesCount() {
		return matchesCount;
	}
	public void setMatchesCount(String matchesCount) {
		this.matchesCount = matchesCount;
	}
	public String getBowlingAvg() {
		return bowlingAvg;
	}
	public void setBowlingAvg(String bowlingAvg) {
		this.bowlingAvg = bowlingAvg;
	}
	
	@Override
	public String toString() {
		return "CricketerProfileVO [cricketerId=" + cricketerId + ", fullName=" + fullName + ", status=" + status
				+ ", dob=" + dob + ", addrs=" + addrs + ", runs=" + runs + ", innigsCount=" + innigsCount
				+ ", battingAvg=" + battingAvg + ", wicketsCount=" + wicketsCount + ", matchesCount=" + matchesCount
				+ ", bowlingAvg=" + bowlingAvg + "]";
	}

	

}
