package org.wx.sdk.card.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.card.respone.CardCreateRespone;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>创建卡券请求对象
 * <p>创建卡券接口是微信卡券的基础接口，用于创建一类新的卡券，获取card_id，创建成功并通过审核后，
 * 商家可以通过文档提供的其他接口将卡券下发给用户，每次成功领取，库存数量相应扣除。
 * <p>开发者须知：
 * <p>1.需自定义Code码的商家必须在创建卡券时候，设定use_custom_code为true，且在调用投放卡券接口时填入指定的Code码。指定OpenID同理。
 * 特别注意：在公众平台创建的卡券均为非自定义Code类型。
 * <p>2.can_share字段指领取卡券原生页面是否可分享，建议指定Code码、指定OpenID等强限制条件的卡券填写false。
 * <p>3.特别注意：编码方式仅支持使用UTF-8，否则会报错。
 * <p>4.创建成功后该卡券会自动提交审核，审核结果将通过事件通知商户。
 * @author Rocye
 * @version 2017.12.19
 */
public class CardCreateRequest implements Request<CardCreateRespone> {

	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();

    /** 卡券数据 */
    private Map<String, Object> card;

    /**
     * 构造器
     * @param card  卡券数据
     */
    public CardCreateRequest(Map<String, Object> card) {
        this.card = card;
    }

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/card/create?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<CardCreateRespone> getResponseClass(){
        return CardCreateRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        wxHashMap.put("card", card);
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

	public Map<String, Object> getCard() {
		return card;
	}
	public void setCard(Map<String, Object> card) {
		this.card = card;
	}

}
