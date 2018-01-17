package org.wx.sdk.card.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.card.respone.CardCodeCheckRespone;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>核查code请求对象
 * <p>为了避免出现导入差错，强烈建议开发者在查询完code数目的时候核查code接口校验code导入微信后台的情况。
 * <p>支持开发者调用该接口查询code导入微信后台的情况。
 * @author Rocye
 * @version 2017.12.26
 */
public class CardCodeCheckRequest implements Request<CardCodeCheckRespone> {

	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();

    /** 进行导入code的卡券ID */
    private String card_id;
	/** 已经微信卡券后台的自定义code，上限为100个 */
    private List<String> code;

	/**
	 * 构造器
	 * @param cardId	进行导入code的卡券ID
	 * @param code		已经微信卡券后台的自定义code，上限为100个
	 */
	public CardCodeCheckRequest(String cardId, List<String> code) {
		this.card_id = cardId;
		this.code = code;
	}

	/**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "http://api.weixin.qq.com/card/code/checkcode?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<CardCodeCheckRespone> getResponseClass(){
        return CardCodeCheckRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        wxHashMap.put("card_id", this.card_id);
        wxHashMap.put("code", this.code);
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

	public List<String> getCode() {
		return code;
	}
	public void setCode(List<String> code) {
		this.code = code;
	}

}
