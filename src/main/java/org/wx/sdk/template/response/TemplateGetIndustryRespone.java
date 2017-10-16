package org.wx.sdk.template.response;

import org.wx.sdk.base.Response;
import org.wx.sdk.template.object.Industry;

/**
 * 获取设置的行业信息返回对象
 * @author Rocye
 * @version 2017-08-22
 */
public class TemplateGetIndustryRespone extends Response {

	/** 帐号设置的主营行业 */
	private Industry primary_industry;
	/** 帐号设置的副营行业 */
	private Industry secondary_industry;
	
	public Industry getPrimary_industry() {
		return primary_industry;
	}
	public void setPrimary_industry(Industry primary_industry) {
		this.primary_industry = primary_industry;
	}
	
	public Industry getSecondary_industry() {
		return secondary_industry;
	}
	public void setSecondary_industry(Industry secondary_industry) {
		this.secondary_industry = secondary_industry;
	}
	
}
