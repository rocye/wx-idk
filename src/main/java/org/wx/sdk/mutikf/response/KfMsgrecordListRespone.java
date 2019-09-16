package org.wx.sdk.mutikf.response;

import org.wx.sdk.base.Response;
import org.wx.sdk.mutikf.object.Msgrecord;
import java.util.List;

/**
 * 获取聊天记录返回对象
 * @author Rocye
 * @version 2017.10.27
 */
public class KfMsgrecordListRespone extends Response {

	/** 客服会话列表 */
	private List<Msgrecord> recordlist;
	/** 每次获取条数，最多10000条 */
	private Integer number;
	/** 消息id顺序从小到大，从1开始 */
	private Integer msgid;

	public List<Msgrecord> getRecordlist() {
		return recordlist;
	}
	public void setRecordlist(List<Msgrecord> recordlist) {
		this.recordlist = recordlist;
	}

	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getMsgid() {
		return msgid;
	}
	public void setMsgid(Integer msgid) {
		this.msgid = msgid;
	}

}
