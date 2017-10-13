package org.wx.sdk.statistic.response;

import java.util.List;

import org.wx.sdk.base.Response;
import org.wx.sdk.statistic.object.UserSummary;

/**
 * 获取用户增减数据返回对象
 * @author Rocye
 * @version 2017-09-25
 */
public class GetUserSummaryRespone extends Response {
	private static final long serialVersionUID = -5332083678682865807L;
	
	private List<UserSummary> list;

	public List<UserSummary> getList() {
		return list;
	}
	public void setList(List<UserSummary> list) {
		this.list = list;
	}
    
}
