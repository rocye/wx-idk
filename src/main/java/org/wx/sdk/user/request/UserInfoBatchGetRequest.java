package org.wx.sdk.user.request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.wx.sdk.base.Request;
import org.wx.sdk.user.object.OpenidObj;
import org.wx.sdk.user.response.UserInfoBatchGetRespone;

/**
 * <p>批量获取用户基本信息请求对象
 * <p>开发者可通过该接口来批量获取用户基本信息。最多支持一次拉取100条。
 * @author Rocye
 * @version 2016-10-27
 */
public class UserInfoBatchGetRequest implements Request<UserInfoBatchGetRespone> {
	/** 微信公众平台唯一凭证 */
    private String accessToken;
    /** 请求参数 */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
    /** 用户的OpenID */
    private List<OpenidObj> user_list;
    
    /**
     * 构造器
     * @param openidList 用户OpenId列表
     */
    public UserInfoBatchGetRequest(List<OpenidObj> openidList) {
        this.user_list = openidList;
    }

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<UserInfoBatchGetRespone> getResponseClass(){
        return UserInfoBatchGetRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        wxHashMap.put("user_list", user_list);
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

    public List<OpenidObj> getUser_list() {
        return user_list;
    }
    public void setUser_list(List<OpenidObj> userList) {
        user_list = userList;
    }

}
