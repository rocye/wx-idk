package org.wx.sdk.wifi.response;

import org.wx.sdk.base.Response;
import org.wx.sdk.wifi.object.WifiShopList;

/**
 * 查询门店Wi-Fi信息返回对象
 * @author Rocye
 * @version 2017.10.28
 */
public class WifiShopGetRespone extends Response {

	/** 门店ID */
	private WifiShopList data;

	public WifiShopList getData() {
		return data;
	}
	public void setData(WifiShopList data) {
		this.data = data;
	}

}
