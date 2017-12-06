package org.wx.open.authorize.response;

import org.wx.open.authorize.object.AuthorizationInfoX;
import org.wx.open.authorize.object.AuthorizerInfoX;
import org.wx.sdk.base.Response;

/**
 * 获取授权方的帐号基本信息返回对象
 * @author Rocye
 * @version 2017.12.06
 */
public class ApiGetAuthorizerInfoRespone extends Response {

	/** 授权方的基本信息 */
	private AuthorizerInfoX authorizer_info;
	/** 授权信息 */
	private AuthorizationInfoX authorization_info;

	public AuthorizerInfoX getAuthorizer_info() {
		return authorizer_info;
	}
	public void setAuthorizer_info(AuthorizerInfoX authorizer_info) {
		this.authorizer_info = authorizer_info;
	}

	public AuthorizationInfoX getAuthorization_info() {
		return authorization_info;
	}
	public void setAuthorization_info(AuthorizationInfoX authorization_info) {
		this.authorization_info = authorization_info;
	}

}
