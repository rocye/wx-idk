package org.wx.sdk.card.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.card.respone.CardDeleteRespone;
import org.wx.sdk.card.respone.CardGetRespone;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>删除卡券请求对象
 * <p>删除卡券接口允许商户删除任意一类卡券。删除卡券后，该卡券对应已生成的领取用二维码、添加到卡包JS API均会失效。
 * <p>注意：如用户在商家删除卡券前已领取一张或多张该卡券依旧有效。即删除卡券不能删除已被用户领取，保存在微信客户端中的卡券。
 * @author Rocye
 * @version 2018.01.02
 */
public class CardDeleteRequest implements Request<CardDeleteRespone> {

	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();

    /** 卡券ID */
    private String card_id;

	/**
	 * 构造器
	 * @param cardId	单张卡券的唯一标准。
	 */
	public CardDeleteRequest(String cardId) {
		this.card_id = cardId;
	}

	/**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/card/delete?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<CardDeleteRespone> getResponseClass(){
        return CardDeleteRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
		wxHashMap.put("card_id", this.card_id);
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

	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}

}
