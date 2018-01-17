package org.wx.sdk.card.object;

/**
 * 查询Code返回的卡券
 * @author Rocye
 * @version 2017.12.28
 */
public class Cardx {
	/** 卡券ID */
	private String card_id;
	/** 单张卡券的唯一标准 */
	private String code;
	/** 起始使用时间 */
	private Long begin_time;
	/** 结束时间 */
	private Long end_time;

	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public Long getBegin_time() {
		return begin_time;
	}
	public void setBegin_time(Long begin_time) {
		this.begin_time = begin_time;
	}

	public Long getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Long end_time) {
		this.end_time = end_time;
	}
}
