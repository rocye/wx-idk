package org.wx.pay.mode.response;

import org.wx.pay.base.Response;

/**
 * 统一下单返回对象
 * @author Rocye
 * @version 2017.11.16
 */
public class UnifiedOrderRespone extends Response {
	/** 公众账号ID */
	private String appid;
	/** 商户号 */
	private String mch_id;
	/** 自定义参数，可以为请求支付的终端设备号等(否) */
	private String device_info;
	/** 微信返回的随机字符串 */
	private String nonce_str;
	/** 交易类型，取值为：JSAPI，NATIVE，APP等 */
	private String trade_type;
	/** 微信生成的预支付会话标识，用于后续接口调用中使用，该值有效期为2小时 */
	private String prepay_id;
	/** trade_type为NATIVE时有返回，用于生成二维码，展示给用户进行扫码支付(否) */
	private String code_url;

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

	public String getDevice_info() {
		return device_info;
	}
	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}

	public String getNonce_str() {
		return nonce_str;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getTrade_type() {
		return trade_type;
	}
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public String getPrepay_id() {
		return prepay_id;
	}
	public void setPrepay_id(String prepay_id) {
		this.prepay_id = prepay_id;
	}

	public String getCode_url() {
		return code_url;
	}
	public void setCode_url(String code_url) {
		this.code_url = code_url;
	}

}
