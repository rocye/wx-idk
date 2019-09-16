package org.wx.sdk.card.respone;

import org.wx.sdk.base.Response;
import org.wx.sdk.card.object.MemberCardinfo;
import java.util.List;

/**
 * 拉取会员卡概况数据返回对象
 * @author Rocye
 * @version 2018.01.15
 */
public class GetCardMemberCardinfoRespone extends Response {

	private List<MemberCardinfo> list;

	public List<MemberCardinfo> getList() {
		return list;
	}
	public void setList(List<MemberCardinfo> list) {
		this.list = list;
	}

}
