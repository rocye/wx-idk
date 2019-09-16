package org.wx.sdk.generalize.request;

import java.util.HashMap;
import java.util.Map;
import org.wx.sdk.base.Request;
import org.wx.sdk.generalize.response.CurrentAutoreplyGetRespone;

/**
 * <p>获取公众号的自动回复规则
 * <p>开发者可以通过该接口，获取公众号当前使用的自动回复规则，包括关注后自动回复、消息自动回复（60分钟内触发一次）、关键词自动回复。
 * <p>1、第三方平台开发者可以通过本接口，在旗下公众号将业务授权给你后，立即通过本接口检测公众号的自动回复配置，并通过接口再次给公众号设置好自动回复规则，以提升公众号运营者的业务体验。
 * <p>2、本接口仅能获取公众号在公众平台官网的自动回复功能中设置的自动回复规则，若公众号自行开发实现自动回复，或通过第三方平台开发者来实现，则无法获取。
 * <p>3、认证/未认证的服务号/订阅号，以及接口测试号，均拥有该接口权限。
 * <p>4、从第三方平台的公众号登录授权机制上来说，该接口从属于消息与菜单权限集。
 * <p>5、本接口中返回的图片/语音/视频为临时素材（临时素材每次获取都不同，3天内有效，通过素材管理-获取临时素材接口来获取这些素材），
 * 		 本接口返回的图文消息为永久素材素材（通过素材管理-获取永久素材接口来获取这些素材）。
 * @author Rocye
 * @version 2017-08-22
 */
public class CurrentAutoreplyGetRequest implements Request<CurrentAutoreplyGetRespone>{
	/** 调用接口凭证 */
    private String accessToken;
    /** 请求参数 */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
    
    /**
     * 构造器
     */
    public CurrentAutoreplyGetRequest() {
    	
    }

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/cgi-bin/get_current_autoreply_info?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<CurrentAutoreplyGetRespone> getResponseClass(){
        return CurrentAutoreplyGetRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        return wxHashMap;
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
        return "json";
    }
    
    /**
     * 设置AccessToken
     */
    public void setAccessToken(String accessToken){
        this.accessToken = accessToken;
    }

}
