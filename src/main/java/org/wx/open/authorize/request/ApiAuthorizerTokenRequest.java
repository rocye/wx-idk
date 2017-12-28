package org.wx.open.authorize.request;

import org.wx.open.authorize.response.ApiAuthorizerTokenRespone;
import org.wx.sdk.base.Request;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>获取（刷新）授权公众号或小程序的接口调用凭据（令牌）请求对象
 * <p>该API用于在授权方令牌（authorizer_access_token）失效时，可用刷新令牌（authorizer_refresh_token）获取新的令牌。
 * <p>请注意，此处token是2小时刷新一次，开发者需要自行进行token的缓存，避免token的获取次数达到每日的限定额度。
 * @author Rocye
 * @version 2017.12.06
 */
public class ApiAuthorizerTokenRequest implements Request<ApiAuthorizerTokenRespone> {
	/** 第三方平台access_token */
    private String accessToken;

    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();

    /** 第三方平台appid */
    private String component_appid;
    /** 授权方appid */
    private String authorizer_appid;
    /** 授权方的刷新令牌，刷新令牌主要用于第三方平台获取和刷新已授权用户的access_token，只会在授权时刻提供，请妥善保存。
	 * 一旦丢失，只能让用户重新授权，才能再次拿到新的刷新令牌 */
    private String authorizer_refresh_token;

	/**
	 * 构造器
	 * @param componentAppid			第三方平台方appid
	 * @param authorizerAppid			授权方appid
	 * @param authorizerRefreshToken	授权方的刷新令牌，刷新令牌主要用于第三方平台获取和刷新已授权用户的access_token
	 */
	public ApiAuthorizerTokenRequest(String componentAppid, String authorizerAppid, String authorizerRefreshToken) {
		this.component_appid = componentAppid;
		this.authorizer_appid = authorizerAppid;
		this.authorizer_refresh_token = authorizerRefreshToken;
	}

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/cgi-bin/component/api_authorizer_token?component_access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<ApiAuthorizerTokenRespone> getResponseClass(){
        return ApiAuthorizerTokenRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
		wxHashMap.put("component_appid", this.component_appid);
		wxHashMap.put("authorizer_appid", this.authorizer_appid);
		wxHashMap.put("authorizer_refresh_token", this.authorizer_refresh_token);
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

	public String getAuthorizer_refresh_token() {
		return authorizer_refresh_token;
	}
	public void setAuthorizer_refresh_token(String authorizer_refresh_token) {
		this.authorizer_refresh_token = authorizer_refresh_token;
	}

}
