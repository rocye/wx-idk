package org.wx.sdk.statistic.object;

/**
 * 消息发送概况数据实体类
 * @author Rocye
 * @version 2017-10-09
 */
public class UpstreamMsg {
	
	/** 数据的日期 */
    private String ref_date;
    /** 消息类型，代表含义如下：1代表文字 2代表图片 3代表语音 4代表视频 6代表第三方应用消息（链接消息） */
    private Integer msg_type;
    /** 上行发送了（向公众号发送了）消息的用户数 */
    private Integer msg_user;
    /** 上行发送了消息的消息总数 */
    private Integer msg_count;
    
	public String getRef_date() {
		return ref_date;
	}
	public void setRef_date(String ref_date) {
		this.ref_date = ref_date;
	}
	
	public Integer getMsg_type() {
		return msg_type;
	}
	public void setMsg_type(Integer msg_type) {
		this.msg_type = msg_type;
	}
	
	public Integer getMsg_user() {
		return msg_user;
	}
	public void setMsg_user(Integer msg_user) {
		this.msg_user = msg_user;
	}
	
	public Integer getMsg_count() {
		return msg_count;
	}
	public void setMsg_count(Integer msg_count) {
		this.msg_count = msg_count;
	}

}
