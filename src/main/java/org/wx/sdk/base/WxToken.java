package org.wx.sdk.base;

import java.util.Map;

/**
 * 微信接口调用凭证超类
 * @author Rocye
 * @version 2016-04-05
 */
public abstract class WxToken {
	/** 微信公众平台AppId */
    protected String appId;
    /** 微信公众平台AppSecret */
    protected String appSecret;
    
    /**
     * 构造函数
     * @author Rocye
     * @param appId		公众号AppId
     * @param appSecret	公众号AppSecret
     */
    protected WxToken(String appId, String appSecret) {
        this.appId = appId;
        this.appSecret = appSecret;
    }
    
    public String getAppId() {
        return appId;
    }
    public void setAppId(String appId) {
        this.appId = appId;
    }
    
    public String getAppSecret() {
        return appSecret;
    }
    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }
    
    /**
     * 获取微信Token
     * @return Token数据键值对
     */
    public abstract Map<String, Object> getWxToken();
    
    /**
     * 保存微信Token
     * @param tokenMap 接口返回Token数据键值对
     */
    public abstract void setWxToken(Map<String, Object> tokenMap);
    
}
