package org.wx.sdk.wifi.object;

/**
 * Wi-Fi数据统计
 * @author Rocye
 * @version 2017.11.01
 */
public class WifiStatistics {
    /** 门店ID */
    private Integer shop_id;
    /** 统计时间，单位为毫秒 */
    private Long statis_time;
	/** Wi-Fi连接总人数 */
    private Integer total_user;
	/** 商家主页访问人数 */
    private Integer homepage_uv;
	/** 新增公众号关注人数 */
    private  Integer new_fans;
	/** 新增公众号关注人数 */
    private Integer total_fans;
	/** 微信方式连Wi-Fi人数 */
    private Integer wxconnect_user;
	/** 连网后消息发送人数 */
    private Integer connect_msg_user;

	public Integer getShop_id() {
		return shop_id;
	}
	public void setShop_id(Integer shop_id) {
		this.shop_id = shop_id;
	}

	public Long getStatis_time() {
		return statis_time;
	}
	public void setStatis_time(Long statis_time) {
		this.statis_time = statis_time;
	}

	public Integer getTotal_user() {
		return total_user;
	}
	public void setTotal_user(Integer total_user) {
		this.total_user = total_user;
	}

	public Integer getHomepage_uv() {
		return homepage_uv;
	}
	public void setHomepage_uv(Integer homepage_uv) {
		this.homepage_uv = homepage_uv;
	}

	public Integer getNew_fans() {
		return new_fans;
	}
	public void setNew_fans(Integer new_fans) {
		this.new_fans = new_fans;
	}

	public Integer getTotal_fans() {
		return total_fans;
	}
	public void setTotal_fans(Integer total_fans) {
		this.total_fans = total_fans;
	}

	public Integer getWxconnect_user() {
		return wxconnect_user;
	}
	public void setWxconnect_user(Integer wxconnect_user) {
		this.wxconnect_user = wxconnect_user;
	}

	public Integer getConnect_msg_user() {
		return connect_msg_user;
	}
	public void setConnect_msg_user(Integer connect_msg_user) {
		this.connect_msg_user = connect_msg_user;
	}

}
