package org.wx.sdk.card.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.card.respone.CardCodeUpdateRespone;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>更改Code请求对象
 * <p>为确保转赠后的安全性，微信允许自定义Code的商户对已下发的code进行更改。
 * <p>注：为避免用户疑惑，建议仅在发生转赠行为后（发生转赠后，微信会通过事件推送的方式告知商户被转赠的卡券Code）对用户的Code进行更改。
 * @author Rocye
 * @version 2017.12.29
 */
public class CardCodeUpdateRequest implements Request<CardCodeUpdateRespone> {

	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();

	/** 需变更的Code码。 */
	private String code;
	/** 变更后的有效Code码。 */
    private String new_code;
	/** 卡券ID（否）。自定义Code码卡券为必填。*/
	private String card_id;

	/**
	 * 构造器
	 * @param code		需变更的Code码
	 * @param newCode	变更后的有效Code码
	 */
	public CardCodeUpdateRequest(String code, String newCode) {
		this.code = code;
		this.new_code = newCode;
	}

	/**
	 * 构造器
	 * @param code		需变更的Code码
	 * @param newCode	变更后的有效Code码
	 * @param cardId	卡券ID。自定义Code码卡券为必填。
	 */
	public CardCodeUpdateRequest(String code, String newCode, String cardId) {
		this.code = code;
		this.new_code = newCode;
		this.card_id = cardId;
	}

	/**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/card/code/update?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<CardCodeUpdateRespone> getResponseClass(){
        return CardCodeUpdateRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
		wxHashMap.put("code", this.code);
		wxHashMap.put("new_code", this.new_code);
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

	public String getNew_code() {
		return new_code;
	}
	public void setNew_code(String new_code) {
		this.new_code = new_code;
	}

}
