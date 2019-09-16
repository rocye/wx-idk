package org.wx.sdk.card.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.card.respone.CardUserGetCardListRespone;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>获取用户已领取卡券请求对象
 * <p>用于获取用户卡包里的，属于该appid下所有可用卡券，包括正常状态和异常状态。
 * @author Rocye
 * @version 2017.12.29
 */
public class CardUserGetCardListRequest implements Request<CardUserGetCardListRespone> {

	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();

	/** 需要查询的用户openid */
	private String openid;
	/** 卡券ID，不填写时默认查询当前appid下的卡券 */
	private String card_id;

	/**
	 * 构造器
	 * @param openid	需要查询的用户openid
	 */
	public CardUserGetCardListRequest(String openid) {
		this.openid = openid;
	}

	/**
	 * 构造器
	 * @param openid	需要查询的用户openid
	 * @param cardId	卡券ID，不填写时默认查询当前appid下的卡券
	 */
	public CardUserGetCardListRequest(String openid, String cardId) {
		this.openid = openid;
		this.card_id = cardId;
	}

	/**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/card/user/getcardlist?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<CardUserGetCardListRespone> getResponseClass(){
        return CardUserGetCardListRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
		wxHashMap.put("openid", this.openid);
		wxHashMap.put("card_id", this.card_id);
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

	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}

}
