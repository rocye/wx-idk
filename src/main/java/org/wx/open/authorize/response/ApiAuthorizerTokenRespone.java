package org.wx.open.authorize.response;

import org.wx.sdk.base.Response;

/**
 * 获取（刷新）授权公众号或小程序的接口调用凭据（令牌）返回对象
 * @author Rocye
 * @version 2017.12.06
 */
public class ApiAuthorizerTokenRespone extends Response {

	/** 授权方令牌 */
	private String authorizer_access_token;
	/** 有效期，为2小时 */
	private Long expires_in;
	/** 刷新令牌 */
	private String authorizer_refresh_token;

	public String getAuthorizer_access_token() {
		return authorizer_access_token;
	}
	public void setAuthorizer_access_token(String authorizer_access_token) {
		this.authorizer_access_token = authorizer_access_token;
	}

	public Long getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(Long expires_in) {
		this.expires_in = expires_in;
	}

	public String getAuthorizer_refresh_token() {
		return authorizer_refresh_token;
	}
	public void setAuthorizer_refresh_token(String authorizer_refresh_token) {
		this.authorizer_refresh_token = authorizer_refresh_token;
	}

}
