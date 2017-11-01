package org.wx.sdk.wifi.response;

import org.wx.sdk.base.Response;
import org.wx.sdk.wifi.object.WifiStatistics;

import java.util.List;
import java.util.Map;

/**
 * Wi-Fi数据统计返回对象
 * @author Rocye
 * @version 2017.11.01
 */
public class WifiStatisticsListRespone extends Response {

	private List<WifiStatistics> data;

	public List<WifiStatistics> getData() {
		return data;
	}
	public void setData(List<WifiStatistics> data) {
		this.data = data;
	}

}
