package org.wx.open.authorize.response;

import org.wx.sdk.base.Response;

import java.util.Map;

/**
 * 获取预授权码pre_auth_code返回对象
 * @author Rocye
 * @version 2017.12.06
 */
public class ApiCreatePreauthcodeRespone extends Response {

	/** 预授权码 */
	private String pre_auth_code;
	/** 有效期 */
	private Integer expires_in;

	public String getPre_auth_code() {
		return pre_auth_code;
	}
	public void setPre_auth_code(String pre_auth_code) {
		this.pre_auth_code = pre_auth_code;
	}

	public Integer getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(Integer expires_in) {
		this.expires_in = expires_in;
	}

}
