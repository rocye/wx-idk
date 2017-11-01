package org.wx.sdk.wifi.response;

import org.wx.sdk.base.Response;
import org.wx.sdk.wifi.object.WifiHomepage;

/**
 * 查询商家主页返回对象
 * @author Rocye
 * @version 2017.11.01
 */
public class WifiHomepageGetRespone extends Response {

	/** 商家主页 */
	private WifiHomepage data;

	public WifiHomepage getData() {
		return data;
	}
	public void setData(WifiHomepage data) {
		this.data = data;
	}

}
