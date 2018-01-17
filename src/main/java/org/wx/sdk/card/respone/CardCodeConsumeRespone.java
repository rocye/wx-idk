package org.wx.sdk.card.respone;

import org.wx.sdk.base.Response;
import org.wx.sdk.card.object.Cardx;

/**
 * 核销Code返回对象
 * @author Rocye
 * @version 2017.12.29
 */
public class CardCodeConsumeRespone extends Response {

	/** 返回的Card信息 */
	private Cardx card;
	/** 用户openid */
	private String openid;

	public Cardx getCard() {
		return card;
	}
	public void setCard(Cardx card) {
		this.card = card;
	}

	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}

}
