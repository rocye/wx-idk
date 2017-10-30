package org.wx.sdk.wifi.object;

/**
 * WIFI门店数据
 * @author Rocye
 * @version 2017.10.28
 */
public class WifiShop {
    /** 门店ID（适用于微信连Wi-Fi业务） */
    private String shop_id;
	/** 门店名称 */
    private String shop_name;
    /** 无线网络设备的ssid，未添加设备为空，多个ssid时显示第一个 */
    private String ssid;
    /** 无线网络设备的ssid列表，返回数组格式 */
    private String[] ssid_list;
    /** 门店内设备的设备类型，0-未添加设备，1-专业型设备，4-密码型设备，5-portal自助型设备，31-portal改造型设备 */
    private Integer protocol_type;
    /** 商户自己的id，与门店poi_id对应关系，建议在添加门店时候建立关联关系，具体请参考“微信门店接口” */
    private String sid;
    /** 门店ID（适用于微信卡券、微信门店业务），具体定义参考微信门店，与shop_id一一对应 */
    private String poi_id;

	public String getShop_id() {
		return shop_id;
	}
	public void setShop_id(String shop_id) {
		this.shop_id = shop_id;
	}

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
