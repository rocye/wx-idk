package org.wx.sdk.wifi.response;

import org.wx.sdk.base.Response;
import java.util.Map;

/**
 * 获取物料二维码返回对象
 * @author Rocye
 * @version 2017.11.01
 */
public class WifiQrcodeGetRespone extends Response {

	/** qrcode_url 二维码图片url */
	private Map<String, String> data;

	public Map<String, String> getData() {
		return data;
	}
	public void setData(Map<String, String> data) {
		this.data = data;
	}

}
