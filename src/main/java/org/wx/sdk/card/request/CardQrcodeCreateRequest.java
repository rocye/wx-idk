package org.wx.sdk.card.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.card.object.Card;
import org.wx.sdk.card.respone.CardQrcodeCreateRespone;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>创建单卡券二维码请求对象
 * <p>开发者可调用该接口生成一张卡券二维码供用户扫码后添加卡券到卡包。
 * <p>自定义Code码的卡券调用接口时，POST数据中需指定code，非自定义code不需指定，指定openid同理。指定后的二维码只能被用户扫描领取一次。
 * <p>获取二维码ticket后，开发者可用通过ticket换取二维码接口换取二维码图片详情。
 * <p>注意事项：
 * <p>1.自定义code的卡券，生成的二维码每次只能领取一次，若开发者想要使用自己的串码系统并且想要用微信的二维码投放，须先将自定义code导入；
 * <p>2.领取多张的二维码一次最多填入5个card_id，否则报错。
 * @author Rocye
 * @version 2017.12.25
 */
public class CardQrcodeCreateRequest implements Request<CardQrcodeCreateRespone> {

	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();

	/** 指定二维码的有效时间，范围是60 ~ 1800秒。不填默认为365天有效 */
	private Integer expire_seconds;

	private String action_name = "QR_CARD";

    /** 卡券信息 */
    private Card card;

	/**
	 * 构造器
	 * @param card  		卡券信息
	 */
	public CardQrcodeCreateRequest(Card card) {
		this.card = card;
	}

    /**
     * 构造器
     * @param card  		卡券信息
	 * @param expireSeconds 指定二维码的有效时间
     */
    public CardQrcodeCreateRequest(Card card, Integer expireSeconds) {
        this.card = card;
        this.expire_seconds = expireSeconds;
    }

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/card/qrcode/create?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<CardQrcodeCreateRespone> getResponseClass(){
        return CardQrcodeCreateRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        wxHashMap.put("action_name", this.action_name);
        if(this.expire_seconds != null){
			wxHashMap.put("expire_seconds", this.expire_seconds);
		}
        Map<String, Object> actionInfo = new HashMap<String, Object>();
        actionInfo.put("card", this.card);
		wxHashMap.put("action_info", actionInfo);
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

	public Integer getExpire_seconds() {
		return expire_seconds;
	}
	public void setExpire_seconds(Integer expire_seconds) {
		this.expire_seconds = expire_seconds;
	}

	public String getAction_name() {
		return action_name;
	}
	public void setAction_name(String action_name) {
		this.action_name = action_name;
	}

	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}

}
