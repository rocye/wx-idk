package org.wx.sdk.template.request;

import java.util.HashMap;
import java.util.Map;
import org.wx.sdk.base.Request;
import org.wx.sdk.template.response.TemplateGetIndustryRespone;

/**
 * <p>获取帐号设置的行业信息，可登录微信公众平台，在公众号后台中查看行业信息
 * <p>为方便第三方开发者，提供通过接口调用的方式来获取帐号所设置的行业信息。
 * @author Rocye
 * @version 2017-08-22
 */
public class TemplateGetIndustryRequest implements Request<TemplateGetIndustryRespone>{
	/** 调用接口凭证 */
    private String accessToken;
    /** 请求参数 */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
    
    /**
     * 构造器
     */
    public TemplateGetIndustryRequest() {
    	
    }

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<TemplateGetIndustryRespone> getResponseClass(){
        return TemplateGetIndustryRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
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
