package org.wx.sdk.wifi.object;

/**
 * WIFI设备数据
 * @author Rocye
 * @version 2017.10.31
 */
public class WifiDevice {
    /** 门店ID */
    private String shop_id;
    /** 连网设备ssid */
    private String ssid;
    /** 门店内设备的设备类型，0-未添加设备，4-密码型设备，31-portal型设备 */
    private Integer protocol_type;
    /** 无线MAC地址 */
    private String bssid;

	public String getShop_id() {
		return shop_id;
	}
	public void setShop_id(String shop_id) {
		this.shop_id = shop_id;
	}

	public String getSsid() {
		return ssid;
	}
	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	public Integer getProtocol_type() {
		return protocol_type;
	}
	public void setProtocol_type(Integer protocol_type) {
		this.protocol_type = protocol_type;
	}

	public String getBssid() {
		return bssid;
	}
	public void setBssid(String bssid) {
		this.bssid = bssid;
	}

}
