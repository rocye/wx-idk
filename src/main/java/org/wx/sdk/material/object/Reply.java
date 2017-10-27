package org.wx.sdk.material.object;

/**
 * 作者回复数据
 * @author Rocye
 * @version 2017.10.10
 */
public class Reply {
	/** 作者回复内容 */
	private String content;
	/** 作者回复时间 */
	private String create_time;
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	
}
