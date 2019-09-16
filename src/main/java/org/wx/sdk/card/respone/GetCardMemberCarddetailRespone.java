package org.wx.sdk.card.respone;

import org.wx.sdk.base.Response;
import org.wx.sdk.card.object.MemberCarddetail;
import java.util.List;

/**
 * 拉取单张会员卡数据返回对象
 * @author Rocye
 * @version 2018.01.16
 */
public class GetCardMemberCarddetailRespone extends Response {

	private List<MemberCarddetail> list;

	public List<MemberCarddetail> getList() {
		return list;
	}
	public void setList(List<MemberCarddetail> list) {
		this.list = list;
	}

}
