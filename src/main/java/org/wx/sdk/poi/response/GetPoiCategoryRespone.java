package org.wx.sdk.poi.response;

import org.wx.sdk.base.Response;
import java.util.List;

/**
 * 门店类目列表返回对象
 * @author Rocye
 * @version 2017.10.16
 */
public class GetPoiCategoryRespone extends Response {

	/** 门店类目列表 */
	private List<String> category_list;

	public List<String> getCategory_list() {
		return category_list;
	}
	public void setCategory_list(List<String> category_list) {
		this.category_list = category_list;
	}

}
