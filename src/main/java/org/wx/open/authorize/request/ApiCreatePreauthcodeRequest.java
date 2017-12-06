package org.wx.open.authorize.request;

import org.wx.open.authorize.response.ApiCreatePreauthcodeRespone;
import org.wx.sdk.base.Request;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>获取预授权码pre_auth_code请求对象
 * <p>该API用于获取预授权码。预授权码用于公众号或小程序授权时的第三方平台方安全验证。
 * @author Rocye
 * @version 2017.12.06
 */
public class ApiCreatePreauthcodeRequest implements Request<ApiCreatePreauthcodeRespone> {
	/** 第三方平台access_token */
    private String accessToken;

    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();

    /** 第三方平台方appid */
    private String component_appid;

	/**
	 * 构造器
	 * @param componentAppid	第三方平台方appid
	 */
	public ApiCreatePreauthcodeRequest(String componentAppid) {
		this.component_appid = componentAppid;
	}

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/cgi-bin/component/api_create_preauthcode?component_access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<ApiCreatePreauthcodeRespone> getResponseClass(){
        return ApiCreatePreauthcodeRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("component_appid", this.component_appid);
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

}
