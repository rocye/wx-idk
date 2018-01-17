package org.wx.sdk.card.object;

import java.util.Map;

/**
 * 代金券
 * @author Rocye
 * @version 2017.12.19
 */
public class Cash {
	/** 卡券基础信息 */
	private BaseInfo base_info;
	/** 卡券高级信息 */
	private Map<String, Object> advanced_info;
	/** 代金券专用，表示起用金额（单位为分）,如果无起用门槛则填0。 */
	private Integer least_cost;
	/** 代金券专用，表示减免金额。（单位为分） */
	private Integer reduce_cost;

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

	public Integer getLeast_cost() {
		return least_cost;
	}
	public void setLeast_cost(Integer least_cost) {
		this.least_cost = least_cost;
	}

	public Integer getReduce_cost() {
		return reduce_cost;
	}
	public void setReduce_cost(Integer reduce_cost) {
		this.reduce_cost = reduce_cost;
	}

}
