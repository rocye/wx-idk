package org.wx.sdk.card.respone;

import org.wx.sdk.base.Response;

/**
 * 创建二维码返回对象
 * @author Rocye
 * @version 2017.12.22
 */
public class CardQrcodeCreateRespone extends Response {

	/** 获取的二维码ticket，凭借此ticket可以在有效时间内换取二维码 */
	private String ticket;
	/** ticket有效时间 */
	private Long expire_seconds;
	/** 二维码图片解析后的地址，开发者可根据该地址自行生成需要的二维码图片 */
	private String url;
	/** 二维码显示地址，点击后跳转二维码页面 */
	private String show_qrcode_url;

	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public String getShow_qrcode_url() {
		return show_qrcode_url;
	}
	public void setShow_qrcode_url(String show_qrcode_url) {
		this.show_qrcode_url = show_qrcode_url;
	}

	public Long getExpire_seconds() {
		return expire_seconds;
	}
	public void setExpire_seconds(Long expire_seconds) {
		this.expire_seconds = expire_seconds;
	}

}
