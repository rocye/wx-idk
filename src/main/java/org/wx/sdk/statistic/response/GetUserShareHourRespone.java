package org.wx.sdk.statistic.response;

import java.util.List;
import org.wx.sdk.base.Response;
import org.wx.sdk.statistic.object.UserShareHour;

/**
 * 获取图文分享转发分时数据返回对象
 * @author Rocye
 * @version 2017-09-30
 */
public class GetUserShareHourRespone extends Response {

	private List<UserShareHour> list;

	public List<UserShareHour> getList() {
		return list;
	}
	public void setList(List<UserShareHour> list) {
		this.list = list;
	}
    
}
