package org.wx.sdk.template.response;

import org.wx.sdk.base.Response;

/**
 * 发送模板消息返回对象
 * @author Rocye
 * @version 2017-08-22
 */
public class TemplateSendRespone extends Response {

	private String msgid;

	public String getMsgid() {
		return msgid;
	}
	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}
	
}
