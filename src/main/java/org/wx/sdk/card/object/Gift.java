package org.wx.sdk.card.object;

import java.util.Map;

/**
 * 兑换券
 * @author Rocye
 * @version 2017.12.19
 */
public class Gift {
	/** 卡券基础信息 */
	private BaseInfo base_info;
	/** 卡券高级信息 */
	private Map<String, Object> advanced_info;
	/** 兑换券专用，填写兑换内容的名称。 */
	private String gift;

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

	public String getGift() {
		return gift;
	}
	public void setGift(String gift) {
		this.gift = gift;
	}

}
