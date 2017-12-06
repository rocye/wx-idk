package org.wx.open.authorize.response;

import org.wx.sdk.base.Response;

/**
 * 获取第三方平台component_access_token返回对象
 * @author Rocye
 * @version 2017.12.06
 */
public class ApiComponentTokenRespone extends Response {

	/** 第三方平台access_token */
    private String component_access_token;
    /** 有效期 */
    private Long expires_in;

	public String getComponent_access_token() {
		return component_access_token;
	}
	public void setComponent_access_token(String component_access_token) {
		this.component_access_token = component_access_token;
	}

	public Long getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(Long expires_in) {
		this.expires_in = expires_in;
	}

}
