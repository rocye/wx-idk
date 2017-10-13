package org.wx.sdk.template.response;

import org.wx.sdk.base.Response;

/**
 * 获得模板ID返回对象
 * @author Rocye
 * @version 2017-08-22
 */
public class TemplateGetIdRespone extends Response {
	private static final long serialVersionUID = 7918959947236274448L;
	
	/** 模板库中模板的编号，有“TM**”和“OPENTMTM**”等形式 */
	private String template_id;

	public String getTemplate_id() {
		return template_id;
	}
	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}
	
}
