package org.wx.sdk.card.respone;

import org.wx.sdk.base.Response;

import java.util.Map;

/**
 * 查看卡券详情返回对象
 * @author Rocye
 * @version 2017.12.29
 */
public class CardGetRespone extends Response {

	/** 卡券数据 */
	private Map<String, Object> card;

	public Map<String, Object> getCard() {
		return card;
	}
	public void setCard(Map<String, Object> card) {
		this.card = card;
	}

}
