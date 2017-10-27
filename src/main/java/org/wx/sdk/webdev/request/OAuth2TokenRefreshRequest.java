package org.wx.sdk.webdev.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.webdev.response.OAuth2TokenGetRespone;
import java.util.Map;

/**
 * 第三步：刷新access_token（如果需要） 请求对象
 * @author Rocye
 * @version 2017.10.23
 */
public class OAuth2TokenRefreshRequest implements Request<OAuth2TokenGetRespone> {

	/** 公众号的唯一标识 */
    private String appid;
	/** 公众号的appsecret */
    private String refresh_token;
	/** 填写为authorization_code */
    private String grant_type;

	/**
	 * 构造器
	 * @param appid			公众号的唯一标识
	 * @param refreshToken	刷新用的Token
	 */
	public OAuth2TokenRefreshRequest(String appid, String refreshToken) {
		this.appid = appid;
		this.refresh_token = refreshToken;
		this.grant_type = "refresh_token";
	}

	/**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid="+ appid +"&grant_type="+ grant_type +"&refresh_token=" + refresh_token;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<OAuth2TokenGetRespone> getResponseClass(){
        return OAuth2TokenGetRespone.class;
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
    }

	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getRefresh_token() {
		return refresh_token;
	}
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public String getGrant_type() {
		return grant_type;
	}
	public void setGrant_type(String grant_type) {
		this.grant_type = grant_type;
	}

}
