package org.wx.open.authorize.response;

import org.wx.open.authorize.object.AuthorizationInfo;
import org.wx.sdk.base.Response;

/**
 * 使用授权码换取公众号或小程序的接口调用凭据和授权信息返回对象
 * @author Rocye
 * @version 2017.12.06
 */
public class ApiQueryAuthRespone extends Response {

	/** 授权信息 */
	private AuthorizationInfo authorization_info;

	public AuthorizationInfo getAuthorization_info() {
		return authorization_info;
	}
	public void setAuthorization_info(AuthorizationInfo authorization_info) {
		this.authorization_info = authorization_info;
	}

}
