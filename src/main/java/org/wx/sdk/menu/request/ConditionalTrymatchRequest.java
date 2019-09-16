package org.wx.sdk.menu.request;

import java.util.HashMap;
import java.util.Map;
import org.wx.sdk.base.Request;
import org.wx.sdk.menu.response.ConditionalTrymatchRespone;

/**
 * 测试个性化菜单匹配结果请求对象
 * @author Rocye
 * @version 2016-09-03
 */
public class ConditionalTrymatchRequest implements Request<ConditionalTrymatchRespone> {
	
    /** 微信公众平台唯一凭证 */
    private String accessToken;
    /** 请求参数 */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
    /** 粉丝的OpenID或粉丝的微信号 */
    private String user_id;
    
    /**
     * 构造器
     * @param userId 粉丝OpenId或微信号
     */
    public ConditionalTrymatchRequest(String userId) {
        this.user_id = userId;
    }

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/cgi-bin/menu/trymatch?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<ConditionalTrymatchRespone> getResponseClass(){
        return ConditionalTrymatchRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        wxHashMap.put("user_id", this.user_id);
        return wxHashMap;
    }
    
    /**
     * 请求类型：1-普通Get 2-下载GET 3-普通POST 4-下载POST 5-无参上传   6-有参上传
     */
    public int getReqType(){
        return 3;
    }
    
    /**
     * 请求参数格式(kv,json,xml)
     */
    public String getParamFormat(){
        return "json";
    }
    
    /**
     * 设置AccessToken
     */
    public void setAccessToken(String accessToken){
        this.accessToken = accessToken;
    }

    public String getUser_id() {
        return user_id;
    }
    public void setUser_id(String userId) {
        user_id = userId;
    }
    
}
