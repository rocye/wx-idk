package org.wx.sdk.statistic.response;

import java.util.List;
import org.wx.sdk.base.Response;
import org.wx.sdk.statistic.object.UpstreamMsg;

/**
 * 获取消息发送月数据返回对象
 * @author Rocye
 * @version 2017-10-09
 */
public class GetUpstreamMsgMonthRespone extends Response {
	private static final long serialVersionUID = 7693017630426143955L;
	
	private List<UpstreamMsg> list;

	public List<UpstreamMsg> getList() {
		return list;
	}
	public void setList(List<UpstreamMsg> list) {
		this.list = list;
	}
    
}
