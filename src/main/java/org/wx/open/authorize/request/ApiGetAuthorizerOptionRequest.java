package org.wx.open.authorize.request;

import org.wx.open.authorize.response.ApiGetAuthorizerInfoRespone;
import org.wx.open.authorize.response.ApiGetAuthorizerOptionRespone;
import org.wx.sdk.base.Request;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>获取授权方的选项设置信息请求对象
 * <p>该API用于获取授权方的公众号或小程序的选项设置信息，如：地理位置上报，语音识别开关，多客服开关。
 * 注意，获取各项选项设置信息，需要有授权方的授权，详见权限集说明。
 * @author Rocye
 * @version 2017.12.06
 */
public class ApiGetAuthorizerOptionRequest implements Request<ApiGetAuthorizerOptionRespone> {
	/** 第三方平台access_token */
    private String accessToken;

    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();

    /** 第三方平台appid */
    private String component_appid;
    /** 授权公众号或小程序的appid */
    private String authorizer_appid;
	/** 选项名称 */
    private String option_name;

	/**
	 * 构造器
	 * @param componentAppid	第三方平台appid
	 * @param authorizerAppid	授权公众号或小程序的appid
	 * @param optionName		选项名称
	 */
	public ApiGetAuthorizerOptionRequest(String componentAppid, String authorizerAppid, String optionName) {
		this.component_appid = componentAppid;
		this.authorizer_appid = authorizerAppid;
		this.option_name = optionName;
	}

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/cgi-bin/component/api_get_authorizer_option?component_access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<ApiGetAuthorizerOptionRespone> getResponseClass(){
        return ApiGetAuthorizerOptionRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
		wxHashMap.put("component_appid", this.component_appid);
		wxHashMap.put("authorizer_appid", this.authorizer_appid);
		wxHashMap.put("option_name", this.option_name);
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

	public String getOption_name() {
		return option_name;
	}
	public void setOption_name(String option_name) {
		this.option_name = option_name;
	}

}
