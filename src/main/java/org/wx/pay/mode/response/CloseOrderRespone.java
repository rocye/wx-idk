package org.wx.pay.mode.response;

import org.wx.pay.base.Response;

/**
 * 关闭订单返回对象
 * @author Rocye
 * @version 2017.11.20
 */
public class CloseOrderRespone extends Response {
	/** 公众账号ID */
	private String appid;
	/** 商户号 */
	private String mch_id;
	/** 业务结果描述 */
	private String result_msg;

	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMch_id() {
		return mch_id;
	}
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getResult_msg() {
		return result_msg;
	}
	public void setResult_msg(String result_msg) {
		this.result_msg = result_msg;
	}

}
