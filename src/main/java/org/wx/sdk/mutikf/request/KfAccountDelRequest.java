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
public class KfAccountDelRequest implements Request<KfAccountRespone> {
    
	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数 */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
    /** 完整客服账号，格式为：账号前缀@公众号微信号 */
    private String kf_account;
    
    /**
     * 构造器
     * @param kfAccount     完整客服账号，格式为：账号前缀@公众号微信号
     */
    public KfAccountDelRequest(String kfAccount) {
        this.kf_account = kfAccount;
    }

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/customservice/kfaccount/del?access_token="+ this.accessToken + "&kf_account=" + this.kf_account;
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

    public String getKf_account() {
        return kf_account;
    }
    public void setKf_account(String kfAccount) {
        kf_account = kfAccount;
    }

}
