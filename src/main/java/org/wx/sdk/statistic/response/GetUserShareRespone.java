package org.wx.sdk.statistic.response;

import java.util.List;
import org.wx.sdk.base.Response;
import org.wx.sdk.statistic.object.UserShare;

/**
 * 获取图文统计数据返回对象
 * @author Rocye
 * @version 2017-09-30
 */
public class GetUserShareRespone extends Response {
	private static final long serialVersionUID = 3480380094751531618L;
	
	private List<UserShare> list;

	public List<UserShare> getList() {
		return list;
	}
	public void setList(List<UserShare> list) {
		this.list = list;
	}
    
}
