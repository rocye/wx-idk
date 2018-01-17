package org.wx.sdk.card.respone;

import org.wx.sdk.base.Response;
import org.wx.sdk.card.object.Cardx;

import java.util.List;

/**
 * 查询Code返回对象
 * @author Rocye
 * @version 2017.12.28
 */
public class CardCodeGetRespone extends Response {

	/** 返回的Card信息 */
	private Cardx card;
	/** 用户openid */
	private String openid;
	/** 是否可以核销，true为可以核销，false为不可核销 */
	private Boolean can_consume;
	/** 当前code对应卡券的状态： NORMAL 正常 CONSUMED 已核销 EXPIRE 已过期 GIFTING 转赠中 GIFT_TIMEOUT 转赠超时
	 * DELETE 已删除 UNAVAILABLE 已失效，code未被添加或被转赠领取的情况则统一报错：invalid serial code。 */
	private String user_card_status;

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

	public Boolean getCan_consume() {
		return can_consume;
	}
	public void setCan_consume(Boolean can_consume) {
		this.can_consume = can_consume;
	}

	public String getUser_card_status() {
		return user_card_status;
	}
	public void setUser_card_status(String user_card_status) {
		this.user_card_status = user_card_status;
	}
}
