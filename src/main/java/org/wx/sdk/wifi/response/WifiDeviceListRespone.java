package org.wx.sdk.wifi.response;

import org.wx.sdk.base.Response;
import org.wx.sdk.wifi.object.WifiDeviceList;

/**
 * 查询设备返回对象
 * @author Rocye
 * @version 2017.11.01
 */
public class WifiDeviceListRespone extends Response {

	/** WIFI设备列表 */
	private WifiDeviceList data;

	public WifiDeviceList getData() {
		return data;
	}
	public void setData(WifiDeviceList data) {
		this.data = data;
	}

}
