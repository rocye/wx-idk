package org.wx.sdk.card.object;

import java.util.Map;

/**
 * 团购券
 * @author Rocye
 * @version 2017.12.19
 */
public class Groupon {
	/** 卡券基础信息 */
	private BaseInfo base_info;
	/** 卡券高级信息 */
	private Map<String, Object> advanced_info;
	/** 团购券专用，团购详情 */
	private String deal_detail;

	/**
	 * 构造器
	 * @param base_info		基本的卡券数据
	 * @param deal_detail	团购详情
	 */
	public Groupon(BaseInfo base_info, String deal_detail) {
		this.base_info = base_info;
		this.deal_detail = deal_detail;
	}

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

	public String getDeal_detail() {
		return deal_detail;
	}
	public void setDeal_detail(String deal_detail) {
		this.deal_detail = deal_detail;
	}

}
