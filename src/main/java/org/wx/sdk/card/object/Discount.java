package org.wx.sdk.card.object;

import java.util.Map;

/**
 * 折扣券
 * @author Rocye
 * @version 2017.12.19
 */
public class Discount {
	/** 卡券基础信息 */
	private BaseInfo base_info;
	/** 卡券高级信息 */
	private Map<String, Object> advanced_info;
	/** 折扣券专用，表示打折额度（百分比）。填30就是七折。 */
	private Integer discount;

	public BaseInfo getBase_info() {
		return base_info;
	}
	public void setBase_info(BaseInfo base_info) {
		this.base_info = base_info;
	}

	public Map<String, Object> getAdvanced_info() {
		return advanced_info;
	}
	public void setAdvanced_info(Map<String, Object> advanced_info) {
		this.advanced_info = advanced_info;
	}

	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
}
