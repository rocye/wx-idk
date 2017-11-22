package org.wx.pay.mode.response;

import org.wx.pay.base.Response;

/**
 * 转换短链接返回对象
 * @author Rocye
 * @version 2017.11.21
 */
public class ShortUrlRespone extends Response {
	/** 公众账号ID */
	private String appid;
	/** 商户号 */
	private String mch_id;
	/** 转换后的URL */
	private String short_url;

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

	public String getShort_url() {
		return short_url;
	}
	public void setShort_url(String short_url) {
		this.short_url = short_url;
	}

}
