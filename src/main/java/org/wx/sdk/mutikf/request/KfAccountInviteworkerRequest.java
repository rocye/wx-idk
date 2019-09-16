package org.wx.sdk.mutikf.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.mutikf.response.KfAccountRespone;
import java.util.HashMap;
import java.util.Map;

/**
 * 邀请绑定客服帐号请求对象
 * @author Rocye
 * @version 2016-06-29
 */
public class KfAccountInviteworkerRequest implements Request<KfAccountRespone> {

	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数 */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
    /** 完整客服账号，格式为：账号前缀@公众号微信号 */
    private String kf_account;
    /** 接收绑定邀请的客服微信号 */
    private String invite_wx;

	/**
	 * 构造器
	 * @param kfAccount 完整客服账号，格式为：账号前缀@公众号微信号
	 * @param inviteWx	接收绑定邀请的客服微信号
	 */
	public KfAccountInviteworkerRequest(String kfAccount, String inviteWx) {
		this.kf_account = kfAccount;
		this.invite_wx = inviteWx;
	}

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/customservice/kfaccount/inviteworker?access_token="+ this.accessToken;
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
        wxHashMap.put("invite_wx", this.invite_wx);
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

	public String getInvite_wx() {
		return invite_wx;
	}
	public void setInvite_wx(String invite_wx) {
		this.invite_wx = invite_wx;
	}

}
