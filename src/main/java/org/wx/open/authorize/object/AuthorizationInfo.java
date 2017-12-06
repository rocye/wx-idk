package org.wx.open.authorize.object;

import java.util.List;

/**
 * 授权信息
 * @author Rocye
 * @version 2017.12.06
 */
public class AuthorizationInfo {
	/** 授权方appid */
	private String authorizer_appid;
	/** 授权方接口调用凭据（在授权的公众号或小程序具备API权限时，才有此返回值），也简称为令牌 */
	private String authorizer_access_token;
	/** 有效期（在授权的公众号或小程序具备API权限时，才有此返回值） */
	private Long expires_in;
	/** 接口调用凭据刷新令牌（在授权的公众号具备API权限时，才有此返回值），刷新令牌主要用于第三方平台获取和刷新已授权用户的access_token，
	 * 只会在授权时刻提供，请妥善保存。 一旦丢失，只能让用户重新授权，才能再次拿到新的刷新令牌 */
	private String authorizer_refresh_token;
	/** 授权给开发者的权限集列表 */
	private List<FuncInfo> func_info;

	public String getAuthorizer_appid() {
		return authorizer_appid;
	}
	public void setAuthorizer_appid(String authorizer_appid) {
		this.authorizer_appid = authorizer_appid;
	}

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

	public List<FuncInfo> getFunc_info() {
		return func_info;
	}
	public void setFunc_info(List<FuncInfo> func_info) {
		this.func_info = func_info;
	}

}
