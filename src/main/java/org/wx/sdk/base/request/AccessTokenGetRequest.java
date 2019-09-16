package org.wx.sdk.base.request;

import java.util.Map;
import org.wx.sdk.base.Request;
import org.wx.sdk.base.response.AccessTokenGetRespone;

/**
 * 微信公众号的全局唯一票据请求对象
 * @author Rocye
 * @version 2016-03-31
 */
public class AccessTokenGetRequest implements Request<AccessTokenGetRespone> {
    /** 微信公众平台AppId */
    private String appId;
    /** 微信公众平台AppSecret */
    private String appSecret;
    
    /**
     * 构造函数
     * @author Rocye
     */
    public AccessTokenGetRequest() {
    }
    
    /**
     * 构造函数
     * @author Rocye
     * @param appId		公众号AppID
     * @param appSecret	公众号AppSecret
     */
    public AccessTokenGetRequest(String appId, String appSecret) {
        this.appId = appId;
        this.appSecret = appSecret;
    }

    /**
     * 获取接口请求地址
     */
    public String getApiUrl() {
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+ this.appId +"&secret="+ this.appSecret; 
        return url;
    }

    /**
     * 请求参数格式(kv,json,xml)
     */
    public String getParamFormat() {
        return "";
    }

    /**
     * 请求类型：1-普通Get 2-下载GET 3-普通POST 4-下载POST 5-无参上传   6-有参上传
     */
    public int getReqType() {
        return 1;
    }

    /**
     * 获取返回对象类
     */
    public Class<AccessTokenGetRespone> getResponseClass() {
        return AccessTokenGetRespone.class;
    }

    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap() {
        return null;
    }

    /**
     * 设置AccessToken
     */
    public void setAccessToken(String accessToken) {
        //这里不需要
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

}
