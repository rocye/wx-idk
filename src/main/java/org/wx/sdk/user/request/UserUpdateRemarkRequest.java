package org.wx.sdk.user.request;

import java.util.HashMap;
import java.util.Map;
import org.wx.sdk.base.Request;
import org.wx.sdk.user.response.UserUpdateRemarkRespone;

/**
 * 设置备注名请求对象
 * 开发者可以通过该接口对指定用户设置备注名，该接口暂时开放给微信认证的服务号。
 * @author Rocye
 * @version 2016-10-27
 */
public class UserUpdateRemarkRequest implements Request<UserUpdateRemarkRespone> {
    
	/** 调用接口凭证 */
    private String accessToken;
    /** 请求参数 */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
    /** 用户唯一标识 */
    private String openid;
    /** 新的备注名，长度必须小于30字符 */
    private String remark;
    
    /**
     * 构造器
     * @param openid    用户标识
     * @param remark    新的备注名，长度必须小于30字符
     */
    public UserUpdateRemarkRequest(String openid, String remark) {
        this.openid = openid;
        this.remark = remark;
    }

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/cgi-bin/user/info/updateremark?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<UserUpdateRemarkRespone> getResponseClass(){
        return UserUpdateRemarkRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        wxHashMap.put("openid", openid);
        wxHashMap.put("remark", remark);
        return wxHashMap;
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

    public String getOpenid() {
        return openid;
    }
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
}
