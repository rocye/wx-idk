package org.wx.sdk.statistic.response;

import java.util.List;
import org.wx.sdk.base.Response;
import org.wx.sdk.statistic.object.UserReadHour;

/**
 * 获取图文统计分时数据返回对象
 * @author Rocye
 * @version 2017-09-30
 */
public class GetUserReadHourRespone extends Response {

	private List<UserReadHour> list;

	public List<UserReadHour> getList() {
		return list;
	}
	public void setList(List<UserReadHour> list) {
		this.list = list;
	}
    
}
