package org.wx.sdk.card.respone;

import org.wx.sdk.base.Response;
import org.wx.sdk.card.object.Bizuininfo;

import java.util.List;

/**
 * 获取免费券数据返回对象
 * @author Rocye
 * @version 2018.01.02
 */
public class GetCardCardinfoRespone extends Response {

	private List<Bizuininfo> list;

	public List<Bizuininfo> getList() {
		return list;
	}
	public void setList(List<Bizuininfo> list) {
		this.list = list;
	}

}
