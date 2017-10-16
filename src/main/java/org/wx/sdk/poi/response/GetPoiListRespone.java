package org.wx.sdk.poi.response;

import org.wx.sdk.base.Response;
import org.wx.sdk.poi.object.Business;
import java.util.List;

/**
 * 查询门店返回对象
 * @author Rocye
 * @version 2017.10.16
 */
public class GetPoiListRespone extends Response {

	/** 门店列表数据 */
	private List<Business> business_list;

	public List<Business> getBusiness_list() {
		return business_list;
	}
	public void setBusiness_list(List<Business> business_list) {
		this.business_list = business_list;
	}

}
