package org.wx.sdk.poi.response;

import org.wx.sdk.base.Response;
import org.wx.sdk.poi.object.Business;

/**
 * 查询门店返回对象
 * @author Rocye
 * @version 2017.10.16
 */
public class GetPoiRespone extends Response {

	/** 门店数据 */
	private Business business;

	public Business getBusiness() {
		return business;
	}
	public void setBusiness(Business business) {
		this.business = business;
	}

}
