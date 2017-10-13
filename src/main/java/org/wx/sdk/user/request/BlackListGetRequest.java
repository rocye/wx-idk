package org.wx.sdk.user.request;

import java.util.HashMap;
import java.util.Map;
import org.wx.sdk.base.Request;
import org.wx.sdk.user.response.BlackListGetRespone;

/**
 * <p>获取公众号的黑名单列表
 * <p>公众号可通过该接口来获取帐号的黑名单列表，黑名单列表由一串 OpenID（加密后的微信号，每个用户对每个公众号的OpenID是唯一的）组成。
 * <p>该接口每次调用最多可拉取 10000个OpenID，当列表数较多时，可以通过多次拉取的方式来满足需求。
 * @author Rocye
 * @version 2017-08-22
 */
public class BlackListGetRequest implements Request<BlackListGetRespone> {
    
	/** 调用接口凭证 */
    private String accessToken;
    /** 请求参数 */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
    
    /** 第一个拉取的OPENID，不填默认从头开始拉取 */
    private String begin_openid;
    
    /**
     * 构造函数
     */
    public BlackListGetRequest() {
    	
    }
    
    /**
     * 构造函数
     * @param beginOpenid    当 begin_openid 为空时，默认从开头拉取
     */
    public BlackListGetRequest(String beginOpenid) {
        this.begin_openid = beginOpenid;
    }

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/cgi-bin/tags/members/getblacklist?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<BlackListGetRespone> getResponseClass(){
        return BlackListGetRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
    	if(begin_openid != null){
    		wxHashMap.put("begin_openid", begin_openid);
    	}
        return wxHashMap;
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

	public String getBegin_openid() {
		return begin_openid;
	}
	public void setBegin_openid(String begin_openid) {
		this.begin_openid = begin_openid;
	}
    

}
