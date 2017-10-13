package org.wx.sdk.statistic.response;

import java.util.List;
import org.wx.sdk.base.Response;
import org.wx.sdk.statistic.object.UserCumulate;

/**
 * 获取累计用户数据返回对象
 * @author Rocye
 * @version 2017-09-29
 */
public class GetUserCumulateRespone extends Response {
	private static final long serialVersionUID = -2082083617305857141L;
	
	private List<UserCumulate> list;

	public List<UserCumulate> getList() {
		return list;
	}
	public void setList(List<UserCumulate> list) {
		this.list = list;
	}
    
}
