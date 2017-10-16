package org.wx.sdk.statistic.response;

import java.util.List;
import org.wx.sdk.base.Response;
import org.wx.sdk.statistic.object.UserRead;

/**
 * 获取图文统计数据返回对象
 * @author Rocye
 * @version 2017-09-29
 */
public class GetUserReadRespone extends Response {

	private List<UserRead> list;

	public List<UserRead> getList() {
		return list;
	}
	public void setList(List<UserRead> list) {
		this.list = list;
	}
    
}
