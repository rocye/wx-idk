package org.wx.sdk.card.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.card.respone.CardModifyStockRespone;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>修改库存请求对象
 * <p>调用修改库存接口增减某张卡券的库存
 * @author Rocye
 * @version 2017.12.29
 */
public class CardModifyStockRequest implements Request<CardModifyStockRespone> {

	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();

    /** 卡券ID */
    private String card_id;
	/** 增加多少库存，支持不填或填0 */
    private Integer increase_stock_value;
	/** 减少多少库存，可以不填或填0 */
    private Integer reduce_stock_value;

	/**
	 * 构造器
	 * @param cardId	卡券ID
	 */
	public CardModifyStockRequest(String cardId) {
		this(cardId, null, null);
	}

	/**
	 * 构造器
	 * @param cardId				卡券ID
	 * @param increaseStockValue	增加多少库存，支持不填或填0
	 */
	public CardModifyStockRequest(String cardId, Integer increaseStockValue) {
		this(cardId, increaseStockValue, null);
	}

	/**
	 * 构造器
	 * @param cardId				卡券ID
	 * @param increaseStockValue	增加多少库存，支持不填或填0
	 * @param reduceStockValue		减少多少库存，可以不填或填0
	 */
	public CardModifyStockRequest(String cardId, Integer increaseStockValue, Integer reduceStockValue) {
		this.card_id = cardId;
		this.increase_stock_value = increaseStockValue;
		this.reduce_stock_value = reduceStockValue;
	}

	/**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/card/modifystock?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<CardModifyStockRespone> getResponseClass(){
        return CardModifyStockRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        wxHashMap.put("card_id", this.card_id);
        if(this.increase_stock_value != null){
        	wxHashMap.put("increase_stock_value", this.increase_stock_value);
		}
		if(this.reduce_stock_value != null){
			wxHashMap.put("reduce_stock_value", this.reduce_stock_value);
		}
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

	public Integer getIncrease_stock_value() {
		return increase_stock_value;
	}
	public void setIncrease_stock_value(Integer increase_stock_value) {
		this.increase_stock_value = increase_stock_value;
	}

	public Integer getReduce_stock_value() {
		return reduce_stock_value;
	}
	public void setReduce_stock_value(Integer reduce_stock_value) {
		this.reduce_stock_value = reduce_stock_value;
	}

}
