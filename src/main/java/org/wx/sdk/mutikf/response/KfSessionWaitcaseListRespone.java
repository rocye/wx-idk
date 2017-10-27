package org.wx.sdk.mutikf.response;

import org.wx.sdk.base.Response;
import org.wx.sdk.mutikf.object.KfSession;

import java.util.List;

/**
 * 获取未接入会话列表返回对象
 * @author Rocye
 * @version 2017.10.27
 */
public class KfSessionWaitcaseListRespone extends Response {

	/** 未接入会话数量 */
	private Integer count;
	/** 未接入会话列表，最多返回100条数据，按照来访顺序 */
	private List<KfSession> waitcaselist;

	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}

	public List<KfSession> getWaitcaselist() {
		return waitcaselist;
	}
	public void setWaitcaselist(List<KfSession> waitcaselist) {
		this.waitcaselist = waitcaselist;
	}

}
