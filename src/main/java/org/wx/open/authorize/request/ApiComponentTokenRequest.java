package org.wx.open.authorize.request;

import org.wx.open.authorize.response.ApiComponentTokenRespone;
import org.wx.sdk.base.Request;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>获取第三方平台component_access_token请求对象
 * <p>第三方平台接口的调用凭据，也叫做令牌。每个令牌是存在有效期（2小时）的，
 * 且令牌的调用不是无限制的，请第三方平台做好令牌的管理，在令牌快过期时（比如1小时50分）再进行刷新。
 * @author Rocye
 * @version 2017.12.06
 */
public class ApiComponentTokenRequest implements Request<ApiComponentTokenRespone> {
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();

    /** 第三方平台appid */
    private String component_appid;
    /** 第三方平台appsecret */
    private String component_appsecret;
    /** 微信后台推送的ticket，此ticket会定时推送 */
    private String component_verify_ticket;

	/**
	 * 构造函数
	 * @param componentAppid			第三方平台appid
	 * @param componentAppsecret		第三方平台appsecret
	 * @param componentVerifyTicket		微信后台推送的ticket，此ticket会定时推送
	 */
    public ApiComponentTokenRequest(String componentAppid, String componentAppsecret, String componentVerifyTicket) {
		this.component_appid = componentAppid;
		this.component_appsecret = componentAppsecret;
		this.component_verify_ticket = componentVerifyTicket;
	}

	/**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/cgi-bin/component/api_component_token";
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<ApiComponentTokenRespone> getResponseClass(){
        return ApiComponentTokenRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        wxHashMap.put("component_appid", this.component_appid);
        wxHashMap.put("component_appsecret", this.component_appsecret);
        wxHashMap.put("component_verify_ticket", this.component_verify_ticket);
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
		//这里不需要
    }

	public String getComponent_appid() {
		return component_appid;
	}
	public void setComponent_appid(String component_appid) {
		this.component_appid = component_appid;
	}

	public String getComponent_appsecret() {
		return component_appsecret;
	}
	public void setComponent_appsecret(String component_appsecret) {
		this.component_appsecret = component_appsecret;
	}

	public String getComponent_verify_ticket() {
		return component_verify_ticket;
	}
	public void setComponent_verify_ticket(String component_verify_ticket) {
		this.component_verify_ticket = component_verify_ticket;
	}

}
