package org.wx.sdk.webdev.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.webdev.response.UserInfoRespone;
import java.util.HashMap;
import java.util.Map;

/**
 * 第四步：拉取用户信息(需scope为 snsapi_userinfo) 请求对象
 * @author Rocye
 * @version 2017.10.24
 */
public class UserInfoRequest implements Request<UserInfoRespone> {
    
	/** OAuth2接口凭证 */
    private String accessToken;
    /** 请求参数 */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
    /** 用户唯一标识 */
    private String openid;
    
    /**
     * 构造器
     * @param openid    用户唯一标识
     */
    public UserInfoRequest(String openid) {
        this.openid = openid;
    }

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/sns/userinfo?access_token="+ accessToken +"&openid="+ openid +"&lang=zh_CN";
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<UserInfoRespone> getResponseClass(){
        return UserInfoRespone.class;
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
        return "json";
    }
    
    /**
     * 设置AccessToken
     */
    public void setAccessToken(String accessToken){
        this.accessToken = accessToken;
    }

    public String getOpenid() {
        return openid;
    }
    public void setOpenid(String openid) {
        this.openid = openid;
    }

}
