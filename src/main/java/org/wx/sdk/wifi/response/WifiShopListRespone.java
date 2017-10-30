package org.wx.sdk.wifi.response;

import org.wx.sdk.base.Response;
import org.wx.sdk.wifi.object.WifiShopInfo;

/**
 * 获取Wi-Fi门店列表返回对象
 * @author Rocye
 * @version 2017.10.30
 */
public class WifiShopListRespone extends Response {

	/** 门店ID */
	private WifiShopInfo data;

	public WifiShopInfo getData() {
		return data;
	}
	public void setData(WifiShopInfo data) {
		this.data = data;
	}

}
