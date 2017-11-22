package org.wx.pay.mode.object;

import com.alibaba.fastjson.JSON;

/**
 * <p>门店信息
 * <p>可用作统一下单接口中的场景信息的参数
 * @author Rocye
 * @version 2017.11.16
 */
public class StoreInfo {
	/** 门店id */
	private String id;
	/** 门店名称 */
	private String name;
	/** 门店行政区划码 */
	private String area_code;
	/** 门店详细地址 */
	private String address;

	/**
	 * 全参构造器
	 * @param id		门店id
	 * @param name		门店名称
	 * @param area_code	门店行政区划码
	 * @param address	门店详细地址
	 */
	public StoreInfo(String id, String name, String area_code, String address) {
		this.id = id;
		this.name = name;
		this.area_code = area_code;
		this.address = address;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getArea_code() {
		return area_code;
	}
	public void setArea_code(String area_code) {
		this.area_code = area_code;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
