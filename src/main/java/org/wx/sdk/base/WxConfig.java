package org.wx.sdk.base;

import java.io.Serializable;

/**
 * 微信公众平台JsApi配置对象
 * @author Rocye
 * @version 2017-02-21
 */
public class WxConfig implements Serializable{
	private static final long serialVersionUID = 8608378463115920761L;
	
	/** 公众号的唯一标识 */
	private String appId;
	/** 生成签名的时间戳 */
    private String timestamp;
    /** 生成签名的随机串 */
    private String nonceStr;
    /** 签名 */
    private String signature;
    
    /**
     * 构造函数
     * @param appId			公众号的唯一标识
     * @param timestamp		生成签名的时间戳
     * @param nonceStr		生成签名的随机串
     * @param signature		签名
     */
    public WxConfig(String appId, String timestamp, String nonceStr, String signature) {
        this.appId = appId;
        this.timestamp = timestamp;
        this.nonceStr = nonceStr;
        this.signature = signature;
    }
    
    public String getAppId() {
        return appId;
    }
    public void setAppId(String appId) {
        this.appId = appId;
    }
    
    public String getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    
    public String getNonceStr() {
        return nonceStr;
    }
    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }
    
    public String getSignature() {
        return signature;
    }
    public void setSignature(String signature) {
        this.signature = signature;
    }

	@Override
	public String toString() {
		return "WxConfig [appId=" + appId + ", timestamp=" + timestamp + ", nonceStr=" + nonceStr + ", signature="
				+ signature + "]";
	}

}
