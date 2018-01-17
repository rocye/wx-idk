package org.wx.sdk.card.respone;

import org.wx.sdk.base.Response;
import org.wx.sdk.card.object.Cardx;

import java.util.List;

/**
 * 获取用户已领取卡券回对象
 * @author Rocye
 * @version 2017.12.29
 */
public class CardUserGetCardListRespone extends Response {

	/** 卡券列表 */
	private List<Cardx> card_list;
	/** 是否有可用的朋友的券 */
	private Boolean has_share_card;

	public List<Cardx> getCard_list() {
		return card_list;
	}
	public void setCard_list(List<Cardx> card_list) {
		this.card_list = card_list;
	}

	public Boolean getHas_share_card() {
		return has_share_card;
	}
	public void setHas_share_card(Boolean has_share_card) {
		this.has_share_card = has_share_card;
	}

}
