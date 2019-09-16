package org.wx.sdk.menu.request;

import java.util.HashMap;
import java.util.Map;
import org.wx.sdk.base.Request;
import org.wx.sdk.menu.response.SelfmenuInfoGetRespone;

/**
 * <p>获取自定义菜单配置请求对象
 * <p>如果公众号是通过API调用设置的菜单，则返回菜单的开发配置
 * <p>如果公众号是在公众平台官网通过网站功能发布菜单，则本接口返回运营者设置的菜单配置
 * <p>但是无法获取个性化菜单
 * @author Rocye
 * @version 2016-09-03
 */
public class SelfmenuInfoGetRequest implements Request<SelfmenuInfoGetRespone> {
    
	/** 微信公众平台唯一凭证 */
    private String accessToken;
    /** 请求参数 */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
    
    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/cgi-bin/get_current_selfmenu_info?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<SelfmenuInfoGetRespone> getResponseClass(){
        return SelfmenuInfoGetRespone.class;
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
