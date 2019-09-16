package org.wx.sdk.material.request;

import java.util.Map;
import org.wx.sdk.base.Request;
import org.wx.sdk.material.response.PerpetualMaterialCountRespone;

/**
 * 获取永久素材数量的请求对象
 * @author Rocye
 * @version 2016-06-27
 */
public class PerpetualMaterialCountRequest implements Request<PerpetualMaterialCountRespone> {
	
	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    
    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<PerpetualMaterialCountRespone> getResponseClass(){
        return PerpetualMaterialCountRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        return null;
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
