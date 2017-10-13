package org.wx.sdk.base;

import java.util.Map;
import java.util.UUID;

/**
 * 微信接口调用权限签名接口
 * @author Rocye
 * @version 2017-02-21
 */
public abstract class WxTicket {
    
	/**
     * 获取微信Ticket
     * @author Rocye
     * @param appId		公众号AppId
     * @param appSecret	公众号AppSecret
     * @version 2017-02-21
     * @return 接口票据字符串
     */
	public abstract String getWxTicket(String appId, String appSecret);
    
    /**
     * 刷新ticket
     * @author Rocye
     * @param appId		公众号AppId
     * @param appSecret	公众号AppSecret
     * @return 接口返回票据键值对
     * @version 2017-02-21
     */
    public abstract Map<String, Object> refreshTicket(String appId, String appSecret);
    
    /**
     * 获取签名signature的配置接口
     * @author Rocye
     * @param appId		公众号AppId
     * @param appSecret	公众号AppSecret
     * @param url		需要JsApi的链接
     * @version 2017-02-21
     * @return {@link WxConfig}
     */
    public abstract WxConfig getWxConfig(String appId, String appSecret, String url);
    
    /**
     * 生成nonce随机字符串
     * @return nonce字符串
     */
    protected static String create_nonce_str() {
        return UUID.randomUUID().toString();
    }
    /**
     * 生成当前时间戳
     * @return 时间戳字符串
     */
    protected static String create_timestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }
    
}
