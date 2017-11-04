package com.inhatc.domain;

import java.util.Date;

public class BookVO {
	
	private Integer no;
	private Date enterdate;
	private String in_out;
	private int sum;
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
	public String getIn_out() {
		return in_out;
	}
	public void setIn_out(String in_out) {
		this.in_out = in_out;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
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
