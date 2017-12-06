package org.wx.open.authorize.object;

import java.util.List;

/**
 * 授权信息
 * @author Rocye
 * @version 2017.12.06
 */
public class AuthorizationInfoX {
	/** 授权方appid */
	private String appid;
	/** 授权给开发者的权限集列表 */
	private List<FuncInfo> func_info;

	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}

	public List<FuncInfo> getFunc_info() {
		return func_info;
	}
	public void setFunc_info(List<FuncInfo> func_info) {
		this.func_info = func_info;
	}

}
