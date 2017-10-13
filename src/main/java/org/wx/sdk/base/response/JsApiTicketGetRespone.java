package org.wx.sdk.base.response;

import org.wx.sdk.base.Response;

/**
 * 微信公众号JS接口的临时票据
 * @author Rocye
 * @version 2017-02-21
 */
public class JsApiTicketGetRespone extends Response {
	private static final long serialVersionUID = -6253453467321711585L;
	
	/** 获取到的凭证 */
	private String ticket;
	/** 凭证有效时间，单位：秒  */
    private Long expires_in;
    
    public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	
	public Long getExpires_in() {
        return expires_in;
    }
    public void setExpires_in(Long expiresIn) {
        expires_in = expiresIn;
    }
}
