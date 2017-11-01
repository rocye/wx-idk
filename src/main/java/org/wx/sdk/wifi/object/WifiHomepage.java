package org.wx.sdk.wifi.object;

/**
 * WIFI设备数据
 * @author Rocye
 * @version 2017.11.01
 */
public class WifiHomepage {
    /** 门店ID */
    private Integer shop_id;
    /** 模板类型 */
    private Short template_id;
    /** 商家主页链接 */
    private String url;

	public Integer getShop_id() {
		return shop_id;
	}
	public void setShop_id(Integer shop_id) {
		this.shop_id = shop_id;
	}

	public Short getTemplate_id() {
		return template_id;
	}
	public void setTemplate_id(Short template_id) {
		this.template_id = template_id;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
