package org.wx.sdk.mutikf.response;

import org.wx.sdk.base.Response;

/**
 * 获取客户会话状态返回对象
 * @author Rocye
 * @version 2017.10.27
 */
public class KfSessionGetRespone extends Response {
	/** 正在接待的客服，为空表示没有人在接待 */
	private String kf_account;
	/** 会话接入的时间 */
	private Long createtime;

	public String getKf_account() {
		return kf_account;
	}
	public void setKf_account(String kf_account) {
		this.kf_account = kf_account;
	}

	public Long getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Long createtime) {
		this.createtime = createtime;
	}

}
