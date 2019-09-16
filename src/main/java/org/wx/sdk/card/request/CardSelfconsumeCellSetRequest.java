package org.wx.sdk.card.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.card.respone.CardSelfconsumeCellSetRespone;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>设置自助核销接口请求对象
 * <p>创建卡券之后，开发者可以通过设置微信买单接口设置该card_id支持自助核销功能。
 * 值得开发者注意的是，设置自助核销的card_id必须已经配置了门店，否则会报错。
 * <p>注意事项：
 * <p>1.设置自助核销的卡券须支持至少一家门店，否则无法设置成功；
 * <p>2.若该卡券设置了center_url（居中使用跳转链接）,须先将该设置更新为空后再设置自助核销功能方可生效。
 * @author Rocye
 * @version 2017.12.22
 */
public class CardSelfconsumeCellSetRequest implements Request<CardSelfconsumeCellSetRespone> {

	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();

    /** 卡券ID */
    private String card_id;
	/** 是否开启自助核销功能，填true/false，默认为false */
    private Boolean is_open;
    /** 用户核销时是否需要输入验证码，填true/false，默认为false */
    private Boolean need_verify_cod;
	/** 用户核销时是否需要备注核销金额，填true/false，默认为false */
	private Boolean need_remark_amount;

    /**
     * 构造器
     * @param cardId  卡券ID
     * @param isOpen  是否开启自助核销功能
     */
    public CardSelfconsumeCellSetRequest(String cardId, Boolean isOpen) {
        this(cardId, isOpen, null, null);
    }

	/**
	 * 构造器
	 * @param card_id				卡券ID
	 * @param is_open				是否开启自助核销功能
	 * @param need_verify_cod		用户核销时是否需要输入验证码
	 * @param need_remark_amount	用户核销时是否需要备注核销金额
	 */
	public CardSelfconsumeCellSetRequest(String card_id, Boolean is_open, Boolean need_verify_cod, Boolean need_remark_amount) {
		this.card_id = card_id;
		this.is_open = is_open;
		this.need_verify_cod = need_verify_cod;
		this.need_remark_amount = need_remark_amount;
	}

	/**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/card/selfconsumecell/set?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<CardSelfconsumeCellSetRespone> getResponseClass(){
        return CardSelfconsumeCellSetRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        wxHashMap.put("card_id", this.card_id);
        wxHashMap.put("is_open", this.is_open);
        if(this.need_verify_cod != null){
			wxHashMap.put("need_verify_cod", this.need_verify_cod);
		}
		if(this.need_remark_amount != null){
        	wxHashMap.put("need_remark_amount", this.need_remark_amount);
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

	public Boolean getIs_open() {
		return is_open;
	}
	public void setIs_open(Boolean is_open) {
		this.is_open = is_open;
	}

	public Boolean getNeed_verify_cod() {
		return need_verify_cod;
	}
	public void setNeed_verify_cod(Boolean need_verify_cod) {
		this.need_verify_cod = need_verify_cod;
	}

	public Boolean getNeed_remark_amount() {
		return need_remark_amount;
	}
	public void setNeed_remark_amount(Boolean need_remark_amount) {
		this.need_remark_amount = need_remark_amount;
	}

}
