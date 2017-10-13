package org.wx.sdk.mutikf.request;

import java.util.HashMap;
import java.util.Map;
import org.wx.sdk.base.Request;
import org.wx.sdk.mutikf.response.KfAccountRespone;

/**
 * 添加客服帐号请求对象
 * @author Rocye
 * @version 2016-06-29
 */
public class KfAccountUpdateRequest implements Request<KfAccountRespone> {
    
	/** 微信公众平台唯一凭证 */
    private String accessToken;
    /** 请求参数 */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
    /** 完整客服账号，格式为：账号前缀@公众号微信号 */
    private String kf_account;
    /** 客服昵称，最长6个汉字或12个英文字符 */
    private String nickname;
    /** 客服账号登录密码，格式为密码明文的32位加密MD5值。该密码仅用于在公众平台官网的多客服功能中使用，若不使用多客服功能，则不必设置密码 */
    private String password;
    
    /**
     * 构造器
     * @param kfAccount 完整客服账号，格式为：账号前缀@公众号微信号
     * @param nickname	客服昵称，最长6个汉字或12个英文字符
     * @param password	客服账号登录密码，格式为密码明文的32位加密MD5值。该密码仅用于在公众平台官网的多客服功能中使用，若不使用多客服功能，则不必设置密码
     */
    public KfAccountUpdateRequest(String kfAccount, String nickname, String password) {
        this.kf_account = kfAccount;
        this.nickname = nickname;
        this.password = password;
    }

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/customservice/kfaccount/update?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<KfAccountRespone> getResponseClass(){
        return KfAccountRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        wxHashMap.put("kf_account", this.kf_account);
        wxHashMap.put("nickname", this.nickname);
        wxHashMap.put("password", this.password);
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

    public String getKf_account() {
        return kf_account;
    }
    public void setKf_account(String kfAccount) {
        kf_account = kfAccount;
    }

    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
}
