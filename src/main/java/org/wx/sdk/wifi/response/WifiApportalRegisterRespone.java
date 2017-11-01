package org.wx.sdk.wifi.response;

import org.wx.sdk.base.Response;
import java.util.Map;

/**
 * 添加portal型设备返回对象
 * @author Rocye
 * @version 2017.10.31
 */
public class WifiApportalRegisterRespone extends Response {

	private Map<String, String> data;

	public Map<String, String> getData() {
		return data;
	}
	public void setData(Map<String, String> data) {
		this.data = data;
	}

}
