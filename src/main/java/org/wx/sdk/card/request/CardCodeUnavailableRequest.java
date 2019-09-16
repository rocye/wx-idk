package org.wx.sdk.card.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.card.respone.CardCodeUnavailableRespone;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>设置卡券失效请求对象
 * <p>为满足改票、退款等异常情况，可调用卡券失效接口将用户的卡券设置为失效状态。
 * <p>注意事项：
 * <p>1.设置卡券失效的操作不可逆，即无法将设置为失效的卡券调回有效状态，商家须慎重调用该接口。
 * <p>2.商户调用失效接口前须与顾客事先告知并取得同意，否则因此带来的顾客投诉，微信将会按照《微信运营处罚规则》进行处罚。
 * @author Rocye
 * @version 2018.01.02
 */
public class CardCodeUnavailableRequest implements Request<CardCodeUnavailableRespone> {

	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();

    /** 卡券ID，自定义卡券必填 */
    private String card_id;
	/** 设置失效的Code码 */
    private String code;
	/** 失效理由(否) */
    private String reason;

	/**
	 * 构造器
	 * @param code		设置失效的Code码
	 */
	public CardCodeUnavailableRequest(String code) {
		this.code = code;
	}

	/**
	 * 构造器
	 * @param cardId	卡券ID
	 * @param code		设置失效的Code码
	 * @param reason	失效理由
	 */
	public CardCodeUnavailableRequest(String cardId, String code, String reason) {
		this.card_id = cardId;
		this.code = code;
		this.reason = reason;
	}

	/**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/card/code/unavailable?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<CardCodeUnavailableRespone> getResponseClass(){
        return CardCodeUnavailableRespone.class;
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

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}

}
