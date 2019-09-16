package org.wx.sdk.user.request;

import java.util.HashMap;
import java.util.Map;
import org.wx.sdk.base.Request;
import org.wx.sdk.user.response.UserListGetRespone;

/**
 * <p>获取用户列表请求对象
 * <p>公众号可通过本接口来获取帐号的关注者列表，关注者列表由一串OpenID（加密后的微信号，每个用户对每个公众号的OpenID是唯一的）组成。
 * <p>一次拉取调用最多拉取10000个关注者的OpenID，可以通过多次拉取的方式来满足需求。
 * @author Rocye
 * @version 2016-10-27
 */
public class UserListGetRequest implements Request<UserListGetRespone> {
    
	/** 调用接口凭证 */
    private String accessToken;
    /** 请求参数 */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
    /** 第一个拉取的OPENID，不填默认从头开始拉取 */
    private String next_openid;
    
    /**
     * 构造函数
     */
    public UserListGetRequest() {
    }
    
    /**
     * 构造函数
     * @param nextOpenid    第一个拉取的OPENID，不填默认从头开始拉取
     */
    public UserListGetRequest(String nextOpenid) {
        this.next_openid = nextOpenid;
    }

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/cgi-bin/user/get?access_token="+ this.accessToken;
        if(this.next_openid != null){
            url = url + "&next_openid=" + this.next_openid;
        }
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<UserListGetRespone> getResponseClass(){
        return UserListGetRespone.class;
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

    public String getNext_openid() {
        return next_openid;
    }
    public void setNext_openid(String nextOpenid) {
        next_openid = nextOpenid;
    }

}
