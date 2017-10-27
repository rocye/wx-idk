package org.wx.sdk.mutikf.object;

/**
 * 客服会话
 * @author Rocye
 * @version 2017.10.27
 */
public class KfSession {
	/** 粉丝的openid */
	private String openid;
	/** 会话接入的时间 */
	private Long createtime;
	/** 粉丝的最后一条消息的时间 */
	private Long latest_time;

	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public Long getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Long createtime) {
		this.createtime = createtime;
	}

	public Long getLatest_time() {
		return latest_time;
	}
	public void setLatest_time(Long latest_time) {
		this.latest_time = latest_time;
	}

}
