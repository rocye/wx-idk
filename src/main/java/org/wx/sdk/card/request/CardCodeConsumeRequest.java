package org.wx.sdk.card.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.card.respone.CardCodeConsumeRespone;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>核销Code请求对象
 * <p>消耗code接口是核销卡券的唯一接口,开发者可以调用当前接口将用户的优惠券进行核销，该过程不可逆。
 * <p>注意事项：
 * <p>1.仅支持核销有效状态的卡券，若卡券处于异常状态，均不可核销。（异常状态包括：卡券删除、未生效、过期、转赠中、转赠退回、失效）
 * <p>2.自定义Code码（use_custom_code为true）的优惠券，在code被核销时，必须调用此接口。用于将用户客户端的code状态变更。
 * 自定义code的卡券调用接口时， post数据中需包含card_id，否则报invalid serial code，非自定义code不需上报。
 * @author Rocye
 * @version 2017.12.29
 */
public class CardCodeConsumeRequest implements Request<CardCodeConsumeRespone> {

	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();

	/** 需核销的Code码 */
	private String code;
    /** 卡券ID。创建卡券时use_custom_code填写true时必填，非自定义Code不必填写 */
    private String card_id;

	/**
	 * 构造器
	 * @param code	需核销的Code码
	 */
	public CardCodeConsumeRequest(String code) {
		this(code, null);
	}

	/**
	 * 构造器
	 * @param code			需核销的Code码
	 * @param cardId		卡券ID
	 */
	public CardCodeConsumeRequest(String code, String cardId) {
		this.code = code;
		this.card_id = cardId;
	}

	/**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/card/code/consume?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<CardCodeConsumeRespone> getResponseClass(){
        return CardCodeConsumeRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
		wxHashMap.put("code", this.code);
		if(this.card_id != null){
			wxHashMap.put("card_id", this.card_id);
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

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}

}
