package org.wx.sdk.statistic.response;

import java.util.List;
import org.wx.sdk.base.Response;
import org.wx.sdk.statistic.object.InterfaceSummary;

/**
 * 获取用户增减数据返回对象
 * @author Rocye
 * @version 2017-10-09
 */
public class GetInterfaceSummaryRespone extends Response {

	private List<InterfaceSummary> list;

	public List<InterfaceSummary> getList() {
		return list;
	}
	public void setList(List<InterfaceSummary> list) {
		this.list = list;
	}
    
}
