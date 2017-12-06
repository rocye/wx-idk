package org.wx.open.authorize.request;

import org.wx.open.authorize.response.ApiGetAuthorizerInfoRespone;
import org.wx.sdk.base.Request;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>获取授权方的帐号基本信息请求对象
 * <p>该API用于获取授权方的基本信息，包括头像、昵称、帐号类型、认证类型、微信号、原始ID和二维码图片URL。
 * <p>需要特别记录授权方的帐号类型，在消息及事件推送时，对于不具备客服接口的公众号，需要在5秒内立即响应；
 * 而若有客服接口，则可以选择暂时不响应，而选择后续通过客服接口来发送消息触达粉丝。
 * @author Rocye
 * @version 2017.12.06
 */
public class ApiGetAuthorizerInfoRequest implements Request<ApiGetAuthorizerInfoRespone> {
	/** 第三方平台access_token */
    private String accessToken;

    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();

    /** 服务appid */
    private String component_appid;
    /** 授权方appid */
    private String authorizer_appid;

	/**
	 * 构造器
	 * @param componentAppid	服务appid
	 * @param authorizerAppid	授权方appid
	 */
	public ApiGetAuthorizerInfoRequest(String componentAppid, String authorizerAppid) {
		this.component_appid = componentAppid;
		this.authorizer_appid = authorizerAppid;
	}

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/cgi-bin/component/api_get_authorizer_info?component_access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<ApiGetAuthorizerInfoRespone> getResponseClass(){
        return ApiGetAuthorizerInfoRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("component_appid", this.component_appid);
        paraMap.put("authorizer_appid", this.authorizer_appid);
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

	public String getComponent_appid() {
		return component_appid;
	}
	public void setComponent_appid(String component_appid) {
		this.component_appid = component_appid;
	}

	public String getAuthorizer_appid() {
		return authorizer_appid;
	}
	public void setAuthorizer_appid(String authorizer_appid) {
		this.authorizer_appid = authorizer_appid;
	}

}
