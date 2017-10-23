package org.wx.sdk.template.object;

/**
 * 模板数据对象
 * @author Rocye
 * @version 2017.08.22
 */
public class DataObj {
	/** 模板内容  */
	private String value;
	/** 模板内容字体颜色，不填默认为黑色(否) */
	private String color;

	/**
	 * 构造器
	 * @param value	  模板内容
	 */
	public DataObj(String value) {
		this.value = value;
	}

	/**
	 * 构造器
	 * @param value	  模板内容
	 * @param color	  模板内容字体颜色
	 */
	public DataObj(String value, String color) {
		this.value = value;
		this.color = color;
	}

	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

}