package org.wx.sdk.poi.response;

import org.wx.sdk.base.Response;

/**
 * 创建门店返回对象
 * @author Rocye
 * @version 2017.10.14
 */
public class AddPoiRespone extends Response {

	/** 门店ID */
	private Long poi_id;

	public Long getPoi_id() {
		return poi_id;
	}
	public void setPoi_id(Long poi_id) {
		this.poi_id = poi_id;
	}

}
