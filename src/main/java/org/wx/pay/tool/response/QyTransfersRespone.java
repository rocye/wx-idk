package org.wx.pay.tool.response;

import org.wx.pay.base.Response;

/**
 * 企业付款返回对象
 * @author Rocye
 * @version 2017.11.15
 */
public class QyTransfersRespone extends Response {
	/** 商户appid */
	private String mch_appid;
	/** 商户号 */
	private String mchid;
	/** 设备号 */
	private String device_info;
	/** 商户订单号 */
	private String partner_trade_no;
	/** 微信订单号 */
	private String payment_no;
	/** 微信支付成功时间 */
	private String payment_time;

	public String getMch_appid() {
		return mch_appid;
	}
	public void setMch_appid(String mch_appid) {
		this.mch_appid = mch_appid;
	}

	public String getMchid() {
		return mchid;
	}
	public void setMchid(String mchid) {
		this.mchid = mchid;
	}

	public String getDevice_info() {
		return device_info;
	}
	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}

	public String getPartner_trade_no() {
		return partner_trade_no;
	}
	public void setPartner_trade_no(String partner_trade_no) {
		this.partner_trade_no = partner_trade_no;
	}

	public String getPayment_no() {
		return payment_no;
	}
	public void setPayment_no(String payment_no) {
		this.payment_no = payment_no;
	}

	public String getPayment_time() {
		return payment_time;
	}
	public void setPayment_time(String payment_time) {
		this.payment_time = payment_time;
	}

}
