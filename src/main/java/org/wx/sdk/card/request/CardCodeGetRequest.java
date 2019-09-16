package org.wx.sdk.card.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.card.respone.CardCodeGetRespone;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>查询Code请求对象
 * <p>强烈建议开发者在调用核销code接口之前调用查询code接口，并在核销之前对非法状态的code(如转赠中、已删除、已核销等)做出处理。
 * <p>注意事项：
 * <p>1.固定时长有效期会根据用户实际领取时间转换，如用户2013年10月1日领取，固定时长有效期为90天，即有效时间为2013年10月1日-12月29日有效。
 * <p>2.无论check_consume填写的是true还是false,当code未被添加或者code被转赠领取是统一报错：invalid serial code
 * @author Rocye
 * @version 2017.12.28
 */
public class CardCodeGetRequest implements Request<CardCodeGetRespone> {

	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();

	/** 单张卡券的唯一标准 */
	private String code;
    /** 卡券ID代表一类卡券。自定义code卡券必填 */
    private String card_id;
	/** 是否校验code核销状态，填入true和false时的code异常状态返回数据不同 */
    private Boolean check_consume;

	/**
	 * 构造器
	 * @param code	单张卡券的唯一标准。
	 */
	public CardCodeGetRequest(String code) {
		this(code, null, null);
	}

	/**
	 * 构造器
	 * @param code			单张卡券的唯一标准。
	 * @param cardId		卡券ID代表一类卡券。自定义code卡券必填。
	 */
	public CardCodeGetRequest(String code, String cardId) {
		this(code, cardId, null);
	}

	/**
	 * 构造器
	 * @param code			单张卡券的唯一标准。
	 * @param cardId		卡券ID代表一类卡券。自定义code卡券必填。
	 * @param checkConsume	是否校验code核销状态，填入true和false时的code异常状态返回数据不同。
	 */
	public CardCodeGetRequest(String code, String cardId, Boolean checkConsume) {
		this.code = code;
		this.card_id = cardId;
		this.check_consume = checkConsume;
	}

	/**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/card/code/get?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<CardCodeGetRespone> getResponseClass(){
        return CardCodeGetRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
		wxHashMap.put("code", this.code);
		if(this.card_id != null){
			wxHashMap.put("card_id", this.card_id);
		}
		if(this.check_consume != null){
			wxHashMap.put("check_consume", this.check_consume);
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

	public Boolean getCheck_consume() {
		return check_consume;
	}
	public void setCheck_consume(Boolean check_consume) {
		this.check_consume = check_consume;
	}

}
