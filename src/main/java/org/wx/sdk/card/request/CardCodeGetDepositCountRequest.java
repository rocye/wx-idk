package org.wx.sdk.card.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.card.respone.CardCodeGetDepositCountRespone;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>查询导入code数目请求对象
 * <p>支持开发者调用该接口查询code导入微信后台成功的数目
 * @author Rocye
 * @version 2017.12.26
 */
public class CardCodeGetDepositCountRequest implements Request<CardCodeGetDepositCountRespone> {

	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();

    /** 进行导入code的卡券ID */
    private String card_id;

	/**
	 * 构造器
	 * @param cardId	需要进行导入code的卡券ID
	 */
	public CardCodeGetDepositCountRequest(String cardId) {
		this.card_id = cardId;
	}

	/**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "http://api.weixin.qq.com/card/code/getdepositcount?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<CardCodeGetDepositCountRespone> getResponseClass(){
        return CardCodeGetDepositCountRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
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

	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}

}
