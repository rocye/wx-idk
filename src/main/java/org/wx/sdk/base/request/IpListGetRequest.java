package org.wx.sdk.base.request;

import java.util.Map;

import org.wx.sdk.base.Request;
import org.wx.sdk.base.response.IpListGetRespone;

/**
 * 微信服务器IP地址列表请求对象
 * @author Rocye
 * @version 2016-03-31
 */
public class IpListGetRequest implements Request<IpListGetRespone> {
    /** 微信公众平台唯一凭证 */
    private String accessToken;
    
    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<IpListGetRespone> getResponseClass(){
        return IpListGetRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        return null;
    }
    
    /**
     * 获取请求是否是Https
     */
    public boolean getUseHttps(){
        return true;
    }
    
    /**
     * 请求类型：1-普通Get 2-下载GET 3-普通POST 4-下载POST 5-无参上传   6-有参上传
     */
    public int getReqType(){
        return 1;
    }
    
    /**
     * 请求参数格式(kv,json,xml)
     */
    public String getParamFormat(){
        return null;
    }
    
    /**
     * 设置AccessToken
     */
    public void setAccessToken(String accessToken){
        this.accessToken = accessToken;
    }
}
