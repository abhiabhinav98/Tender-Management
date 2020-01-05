package org.websparrow.model;

import java.sql.Timestamp;

public class bid {
	
	private int vendor_id;
	private int tender_id;
	private int bid_id;
	private double bidAmount;
	private Timestamp bidTime;
	private String selectBid="Processing";
	public int getVendor_id() {
		return vendor_id;
	}
	public void setVendor_id(int vendor_id) {
		this.vendor_id = vendor_id;
	}
	public int getTender_id() {
		return tender_id;
	}
	public void setTender_id(int tender_id) {
		this.tender_id = tender_id;
	}
	public int getBid_id() {
		return bid_id;
	}
	public void setBid_id(int bid_id) {
		this.bid_id = bid_id;
	}
	public double getBidAmount() {
		return bidAmount;
	}
	public void setBidAmount(double bidAmount) {
		this.bidAmount = bidAmount;
	}
	public Timestamp getBidTime() {
		return bidTime;
	}
	public void setBidTime(Timestamp bidTime) {
		this.bidTime = bidTime;
	}
	public String getSelectBid() {
		return selectBid;
	}
	public void setSelectBid(String selectBid) {
		this.selectBid = selectBid;
	}

}
