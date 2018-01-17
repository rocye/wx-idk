package org.wx.sdk.card.respone;

import org.wx.sdk.base.Response;

/**
 * 创建货架返回对象
 * @author Rocye
 * @version 2017.12.26
 */
public class CardLandingPageCreateRespone extends Response {

	/** 货架链接 */
	private String url;
	/** 货架ID，货架的唯一标识 */
	private Integer page_id;

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getPage_id() {
		return page_id;
	}
	public void setPage_id(Integer page_id) {
		this.page_id = page_id;
	}

}
