package org.wx.sdk.token;

import java.util.HashMap;
import java.util.Map;

import org.wx.sdk.base.WxToken;

/**
 * <p>【默认例子实现类，不会生成到jar包去】
 * <p>微信接口调用凭证全局变量实现
 * @author Rocye
 * @version 2016-04-05
 */
public class GlobalAccessToken extends WxToken {
    /**
     * <p>access_token有效期为7200秒，重复获取将导致上次获取的access_token失效
     * <p>这里是access_token的内存全局缓存
     */
    private static Map<String, Map<String, Object>> ACCESS_TOKEN_MAP = new HashMap<String, Map<String,Object>>(0);
    
    /**
     * 构造函数
     * @author Rocye
     * @param appId		公众号AppID
     * @param appSecret	公众号AppSecret
     */
    public GlobalAccessToken(String appId, String appSecret) {
        super(appId, appSecret);
    }

    /**
     * 获取微信Token
     * @return Token数据键值对
     */
    public Map<String, Object> getWxToken() {
        long nowTime = System.currentTimeMillis();
        if(ACCESS_TOKEN_MAP.containsKey(this.appId) && nowTime < (Long.parseLong(ACCESS_TOKEN_MAP.get(this.appId).get("time").toString())-5000)){
            return ACCESS_TOKEN_MAP.get(this.appId);
        }else{
            return null;
        }
    }

    /**
     * 保存微信Token
     * @param tokenMap 接口返回Token数据键值对
     */
    public void setWxToken(Map<String, Object> tokenMap) {
        ACCESS_TOKEN_MAP.put(this.appId, tokenMap);
    }

}
