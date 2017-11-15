package org.wx.pay.tool.object;

/**
 * 裂变红包领取记录
 * @author Rocye
 * @version 2017.11.14
 */
public class Hbinfo {
	/** 领取红包的Openid */
	private String openid;
	/** 金额 */
	private Integer amount;
	/** 接收时间 */
	private String rcv_time;

	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getRcv_time() {
		return rcv_time;
	}
	public void setRcv_time(String rcv_time) {
		this.rcv_time = rcv_time;
	}

}
