package org.wx.sdk.statistic.response;

import java.util.List;
import org.wx.sdk.base.Response;
import org.wx.sdk.statistic.object.UpstreamMsgHour;

/**
 * 获取消息分送分时数据返回对象
 * @author Rocye
 * @version 2017-10-09
 */
public class GetUpstreamMsgHourRespone extends Response {
	private static final long serialVersionUID = 6364563810163856323L;
	
	private List<UpstreamMsgHour> list;

	public List<UpstreamMsgHour> getList() {
		return list;
	}
	public void setList(List<UpstreamMsgHour> list) {
		this.list = list;
	}
    
}
