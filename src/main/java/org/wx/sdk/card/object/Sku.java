package org.wx.sdk.card.object;

/**
 * 商品信息
 * @author Rocye
 * @version 2017.12.19
 */
public class Sku {
	/** 卡券库存的数量，上限为100000000。*/
	private Integer quantity;

	/**
	 * 构造器
	 * @param quantity	卡券库存的数量，上限为100000000
	 */
	public Sku(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
