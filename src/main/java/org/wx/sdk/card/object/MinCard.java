package org.wx.sdk.card.object;

/**
 * 贷架中的卡券
 * @author Rocye
 * @version 2017.12.26
 */
public class MinCard {
	/** 所要在页面投放的卡券ID */
	private String card_id;
	/** 缩略图url */
	private String thumb_url;

	/**
	 * 构造器
	 * @param card_id	所要在页面投放的卡券ID
	 * @param thumb_url	缩略图url
	 */
	public MinCard(String card_id, String thumb_url) {
		this.card_id = card_id;
		this.thumb_url = thumb_url;
	}

	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}

	public String getThumb_url() {
		return thumb_url;
	}
	public void setThumb_url(String thumb_url) {
		this.thumb_url = thumb_url;
	}

}
