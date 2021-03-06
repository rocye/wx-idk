package org.wx.sdk.mutikf.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.mutikf.response.KfSessionCreateRespone;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>创建会话请求对象
 * <p>此接口在客服和用户之间创建一个会话，如果该客服和用户会话已存在，则直接返回0。指定的客服帐号必须已经绑定微信号且在线。
 * @author Rocye
 * @version 2017.10.26
 */
public class KfSessionCreateRequest implements Request<KfSessionCreateRespone> {

	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数 */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
    /** 完整客服账号，格式为：账号前缀@公众号微信号 */
    private String kf_account;
    /** 粉丝的openid */
    private String openid;

	/**
	 * 构造器
	 * @param kfAccount 完整客服账号，格式为：账号前缀@公众号微信号
	 * @param openid	客服昵称，最长6个汉字或12个英文字符
	 */
	public KfSessionCreateRequest(String kfAccount, String openid) {
		this.kf_account = kfAccount;
		this.openid = openid;
	}

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/customservice/kfsession/create?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<KfSessionCreateRespone> getResponseClass(){
        return KfSessionCreateRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        wxHashMap.put("kf_account", this.kf_account);
        wxHashMap.put("openid", this.openid);
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

    public String getKf_account() {
        return kf_account;
    }
    public void setKf_account(String kfAccount) {
        kf_account = kfAccount;
    }

	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}

}
