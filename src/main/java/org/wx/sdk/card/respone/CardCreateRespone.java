package org.wx.sdk.card.respone;

import org.wx.sdk.base.Response;

/**
 * 创建卡券返回对象
 * @author Rocye
 * @version 2017.12.19
 */
public class CardCreateRespone extends Response {

	/** 卡券ID */
	private String card_id;

	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}

}
