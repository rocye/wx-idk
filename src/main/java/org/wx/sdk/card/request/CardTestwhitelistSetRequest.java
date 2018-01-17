package org.wx.sdk.card.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.card.respone.CardTestwhitelistSetRespone;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>设置测试白名单请求对象
 * <p>由于卡券有审核要求，为方便公众号调试，可以设置一些测试帐号，这些帐号可领取未通过审核的卡券，体验整个流程。
 * <p>开发者注意事项：
 * <p>1.同时支持“openid”、“username”两种字段设置白名单，总数上限为10个。
 * <p>2.设置测试白名单接口为全量设置，即测试名单发生变化时需调用该接口重新传入所有测试人员的ID。
 * <p>3.白名单用户领取该卡券时将无视卡券失效状态，请开发者注意。
 * @author Rocye
 * @version 2017.12.28
 */
public class CardTestwhitelistSetRequest implements Request<CardTestwhitelistSetRespone> {

	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();

    /** 测试的openid列表 */
    private List<String> openid;
	/** 测试的微信号列表 */
    private List<String> username;

	/**
	 * 构造器
	 * @param openid	测试的openid列表
	 */
	public CardTestwhitelistSetRequest(List<String> openid) {
		this.openid = openid;
	}

	/**
	 * 构造器
	 * @param openid	测试的openid列表
	 * @param username	测试的微信号列表
	 */
	public CardTestwhitelistSetRequest(List<String> openid, List<String> username) {
		this.openid = openid;
		this.username = username;
	}

	/**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/card/testwhitelist/set?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<CardTestwhitelistSetRespone> getResponseClass(){
        return CardTestwhitelistSetRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        wxHashMap.put("openid", this.openid);
        wxHashMap.put("username", this.username);
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

	public List<String> getOpenid() {
		return openid;
	}
	public void setOpenid(List<String> openid) {
		this.openid = openid;
	}

	public List<String> getUsername() {
		return username;
	}
	public void setUsername(List<String> username) {
		this.username = username;
	}

}
