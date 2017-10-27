package org.wx.sdk.webdev.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.webdev.response.OAuth2TokenGetRespone;
import java.util.Map;

/**
 * <p>第二步：通过code换取网页授权access_token 请求对象
 * <p>第一步：引导关注者打开如下页面，用户同意授权，获取code：
 * https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect
 * @author Rocye
 * @version 2017.10.23
 */
public class OAuth2TokenGetRequest implements Request<OAuth2TokenGetRespone> {

	/** 公众号的唯一标识 */
    private String appid;
	/** 公众号的appsecret */
    private String secret;
	/** 填写第一步获取的code参数 */
    private String code;
	/** 填写为authorization_code */
    private String grant_type;

	/**
	 * 构造器
	 * @param appid		公众号的唯一标识
	 * @param secret	公众号的appsecret
	 * @param code		填写第一步获取的code参数
	 */
	public OAuth2TokenGetRequest(String appid, String secret, String code) {
		this.appid = appid;
		this.secret = secret;
		this.code = code;
		this.grant_type = "authorization_code";
	}

	/**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+ appid +"&secret="+ secret +"&code="+ code +"&grant_type=" + grant_type;
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

	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getGrant_type() {
		return grant_type;
	}
	public void setGrant_type(String grant_type) {
		this.grant_type = grant_type;
	}

}
