package org.wx.sdk.wifi.object;

/**
 * ssid和密码的数据
 * @author Rocye
 * @version 2017.10.28
 */
public class SsidPassword {
    /** 无线网络设备的ssid，未添加设备为空，多个ssid时显示第一个 */
    private String ssid;
	/** 设备密码，当设备类型为密码型时返回 */
    private String password;

	public String getSsid() {
		return ssid;
	}
	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
