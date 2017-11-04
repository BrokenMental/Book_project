package com.inhatc.domain;

import java.util.Date;

public class BookVO {
	
	private Integer no;
	private Date enterdate;
	private int income;
	private int spend;
	private String classify;
	private String spend_type;
	private String other;
	
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public Date getEnterdate() {
		return enterdate;
	}
	public void setEnterdate(Date enterdate) {
		this.enterdate = enterdate;
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	public int getSpend() {
		return spend;
	}
	public void setSpend(int spend) {
		this.spend = spend;
	}
	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}
	public String getSpend_type() {
		return spend_type;
	}
	public void setSpend_type(String spend_type) {
		this.spend_type = spend_type;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
}
