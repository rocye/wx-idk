package org.wx.sdk.base.request;

import java.util.HashMap;
import java.util.Map;
import org.wx.sdk.base.Request;
import org.wx.sdk.base.response.JsApiTicketGetRespone;

/**
 * 微信公众号的全局唯一票据请求对象
 * @author Rocye
 * @version 2016-03-31
 */
public class JsApiTicketGetRequest implements Request<JsApiTicketGetRespone> {
    /** 微信公众平台唯一凭证 */
	private String accessToken;
	/** 请求参数 */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
    
    /**
     * 获取接口请求地址
     */
    public String getApiUrl() {
        String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+ this.accessToken +"&type=jsapi"; 
        return url;
    }
    
    /**
     * 获取返回对象类
     */
    public Class<JsApiTicketGetRespone> getResponseClass() {
        return JsApiTicketGetRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        return wxHashMap;
    }

    /**
     * 请求参数格式(kv,json,xml)
     */
    public String getParamFormat(){
        return "json";
    }
    
    /**
     * 请求类型：1-普通Get 2-下载GET 3-普通POST 4-下载POST 5-无参上传   6-有参上传
     */
    public int getReqType() {
        return 1;
    }

    /**
     * 设置AccessToken
     */
    public void setAccessToken(String accessToken){
        this.accessToken = accessToken;
    }

}
