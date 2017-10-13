package org.wx.sdk.statistic.response;

import java.util.List;
import org.wx.sdk.base.Response;
import org.wx.sdk.statistic.object.UpstreamMsgDist;

/**
 * 获取消息发送分布数据返回对象
 * @author Rocye
 * @version 2017-10-09
 */
public class GetUpstreamMsgDistRespone extends Response {
	private static final long serialVersionUID = 7705516376460790123L;
	
	private List<UpstreamMsgDist> list;

	public List<UpstreamMsgDist> getList() {
		return list;
	}
	public void setList(List<UpstreamMsgDist> list) {
		this.list = list;
	}
    
}
