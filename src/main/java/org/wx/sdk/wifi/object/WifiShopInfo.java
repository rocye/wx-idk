package org.wx.sdk.wifi.object;

import java.util.List;

/**
 * WIFI门店信息
 * @author Rocye
 * @version 2017.10.30
 */
public class WifiShopInfo {
	/** 门店名称 */
    private String shop_name;
    /** 无线网络设备的ssid，未添加设备为空，多个ssid时显示第一个 */
    private String ssid;
    /** 无线网络设备的ssid列表，返回数组格式 */
    private String[] ssid_list;
    /** ssid和密码的列表，数组格式。当为密码型设备时，密码才有值 */
    private List<SsidPassword> ssid_password_list;
    /** 设备密码，当设备类型为密码型时返回 */
    private String password;
    /** 门店内设备的设备类型，0-未添加设备，1-专业型设备，4-密码型设备，5-portal自助型设备，31-portal改造型设备 */
    private Integer protocol_type;
    /** 门店内设备总数 */
    private Integer ap_count;
    /** 商家主页模板类型 */
    private Integer template_id;
    /** 商家主页链接 */
    private String homepage_url;
    /** 顶部常驻入口上显示的文本内容：0--欢迎光临+公众号名称；1--欢迎光临+门店名称；2--已连接+公众号名称+WiFi；3--已连接+门店名称+Wi-Fi */
    private Integer bar_type;
    /** 商户自己的id，与门店poi_id对应关系，建议在添加门店时候建立关联关系，具体请参考“微信门店接口” */
    private String sid;
    /** 门店ID（适用于微信卡券、微信门店业务），具体定义参考微信门店，与shop_id一一对应 */
    private String poi_id;

	public String getShop_name() {
		return shop_name;
	}

	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public String getSsid() {
		return ssid;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	public String[] getSsid_list() {
		return ssid_list;
	}
	public void setSsid_list(String[] ssid_list) {
		this.ssid_list = ssid_list;
	}

	public Integer getProtocol_type() {
		return protocol_type;
	}
	public void setProtocol_type(Integer protocol_type) {
		this.protocol_type = protocol_type;
	}

	public List<SsidPassword> getSsid_password_list() {
		return ssid_password_list;
	}
	public void setSsid_password_list(List<SsidPassword> ssid_password_list) {
		this.ssid_password_list = ssid_password_list;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAp_count() {
		return ap_count;
	}
	public void setAp_count(Integer ap_count) {
		this.ap_count = ap_count;
	}

	public Integer getTemplate_id() {
		return template_id;
	}
	public void setTemplate_id(Integer template_id) {
		this.template_id = template_id;
	}

	public String getHomepage_url() {
		return homepage_url;
	}
	public void setHomepage_url(String homepage_url) {
		this.homepage_url = homepage_url;
	}

	public Integer getBar_type() {
		return bar_type;
	}
	public void setBar_type(Integer bar_type) {
		this.bar_type = bar_type;
	}

	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getPoi_id() {
		return poi_id;
	}
	public void setPoi_id(String poi_id) {
		this.poi_id = poi_id;
	}

}
