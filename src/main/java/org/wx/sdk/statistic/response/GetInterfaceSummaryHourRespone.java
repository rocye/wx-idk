package org.wx.sdk.statistic.response;

import java.util.List;
import org.wx.sdk.base.Response;
import org.wx.sdk.statistic.object.InterfaceSummaryHour;

/**
 * 获取接口分析分时数据返回对象
 * @author Rocye
 * @version 2017-10-09
 */
public class GetInterfaceSummaryHourRespone extends Response {

	private List<InterfaceSummaryHour> list;

	public List<InterfaceSummaryHour> getList() {
		return list;
	}
	public void setList(List<InterfaceSummaryHour> list) {
		this.list = list;
	}
    
}
