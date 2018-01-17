package org.wx.sdk.card.object;

import java.util.Map;

/**
 * 优惠券
 * @author Rocye
 * @version 2017.12.19
 */
public class GeneralGroupon {
	/** 卡券基础信息 */
	private BaseInfo base_info;
	/** 卡券高级信息 */
	private Map<String, Object> advanced_info;
	/** 优惠券专用，填写优惠详情 */
	private String default_detail;

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

	public String getDefault_detail() {
		return default_detail;
	}
	public void setDefault_detail(String default_detail) {
		this.default_detail = default_detail;
	}

}
