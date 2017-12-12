package org.wx.open.authorize.request;

import org.wx.open.authorize.response.ApiCreatePreauthcodeRespone;
import org.wx.open.authorize.response.ApiQueryAuthRespone;
import org.wx.sdk.base.Request;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>使用授权码换取公众号或小程序的接口调用凭据和授权信息请求对象
 * <p>该API用于使用授权码换取授权公众号或小程序的授权信息，并换取authorizer_access_token和authorizer_refresh_token。
 * 授权码的获取，需要在用户在第三方平台授权页中完成授权流程后，在回调URI中通过URL参数提供给第三方平台方。
 * <p>请注意，由于现在公众号或小程序可以自定义选择部分权限授权给第三方平台，因此第三方平台开发者需要通过该接口来获取公众号或小程序具体授权了哪些权限，而不是简单地认为自己声明的权限就是公众号或小程序授权的权限。
 * @author Rocye
 * @version 2017.12.06
 */
public class ApiQueryAuthRequest implements Request<ApiQueryAuthRespone> {
	/** 第三方平台access_token */
    private String accessToken;

    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();

    /** 第三方平台appid */
    private String component_appid;
    /** 授权code,会在授权成功时返回给第三方平台 */
    private String authorization_code;

	/**
	 * 构造器
	 * @param componentAppid	第三方平台方appid
	 * @param authorizationCode	授权code,会在授权成功时返回给第三方平台
	 */
	public ApiQueryAuthRequest(String componentAppid, String authorizationCode) {
		this.component_appid = componentAppid;
		this.authorization_code = authorizationCode;
	}

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/cgi-bin/component/api_query_auth?component_access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<ApiQueryAuthRespone> getResponseClass(){
        return ApiQueryAuthRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
		wxHashMap.put("component_appid", this.component_appid);
		wxHashMap.put("authorization_code", this.authorization_code);
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

	public String getAuthorization_code() {
		return authorization_code;
	}
	public void setAuthorization_code(String authorization_code) {
		this.authorization_code = authorization_code;
	}

}
