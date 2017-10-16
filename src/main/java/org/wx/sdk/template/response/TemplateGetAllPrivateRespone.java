package org.wx.sdk.template.response;

import java.util.List;
import org.wx.sdk.base.Response;
import org.wx.sdk.template.object.Template;

/**
 * 获取模板列表返回对象
 * @author Rocye
 * @version 2017-08-22
 */
public class TemplateGetAllPrivateRespone extends Response {

	private List<Template> template_list;

	public List<Template> getTemplate_list() {
		return template_list;
	}
	public void setTemplate_list(List<Template> template_list) {
		this.template_list = template_list;
	}
	
}
