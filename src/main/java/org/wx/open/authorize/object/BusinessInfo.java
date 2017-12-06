package org.wx.open.authorize.object;

/**
 * 业务功能的开通状况（0代表未开通，1代表已开通）
 * @author Rocye
 * @version 2017.12.06
 */
public class BusinessInfo {
	/** 是否开通微信门店功能 */
	private Integer open_store;
	/** 是否开通微信扫商品功能 */
	private Integer open_scan;
	/** 是否开通微信支付功能 */
	private Integer open_pay;
	/** 是否开通微信卡券功能 */
	private Integer open_card;
	/** 是否开通微信摇一摇功能 */
	private Integer open_shake;

	public Integer getOpen_store() {
		return open_store;
	}
	public void setOpen_store(Integer open_store) {
		this.open_store = open_store;
	}

	public Integer getOpen_scan() {
		return open_scan;
	}
	public void setOpen_scan(Integer open_scan) {
		this.open_scan = open_scan;
	}

	public Integer getOpen_pay() {
		return open_pay;
	}
	public void setOpen_pay(Integer open_pay) {
		this.open_pay = open_pay;
	}

	public Integer getOpen_card() {
		return open_card;
	}
	public void setOpen_card(Integer open_card) {
		this.open_card = open_card;
	}

	public Integer getOpen_shake() {
		return open_shake;
	}
	public void setOpen_shake(Integer open_shake) {
		this.open_shake = open_shake;
	}

}
