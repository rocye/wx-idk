package org.wx.sdk.mutikf.response;

import org.wx.sdk.base.Response;
import org.wx.sdk.mutikf.object.KfSession;

import java.util.List;

/**
 * 获取客服会话列表返回对象
 * @author Rocye
 * @version 2017.10.27
 */
public class KfSessionListRespone extends Response {

	/** 客服会话列表 */
	private List<KfSession> sessionlist;

	public List<KfSession> getSessionlist() {
		return sessionlist;
	}
	public void setSessionlist(List<KfSession> sessionlist) {
		this.sessionlist = sessionlist;
	}

}
