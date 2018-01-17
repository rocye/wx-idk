package org.wx.sdk.card.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.card.respone.CardPayCellSetRespone;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>设置买单接口请求对象
 * <p>创建卡券之后，开发者可以通过设置微信买单接口设置该card_id支持微信买单功能。
 * 值得开发者注意的是，设置买单的card_id必须已经配置了门店，否则会报错。
 * <p>注意事项：
 * <p>1.设置快速买单的卡券须支持至少一家有核销员门店，否则无法设置成功；
 * <p>2.若该卡券设置了center_url（居中使用跳转链接）,须先将该设置更新为空后再设置自快速买单方可生效。
 * @author Rocye
 * @version 2017.12.22
 */
public class CardPayCellSetRequest implements Request<CardPayCellSetRespone> {

	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();

    /** 卡券ID */
    private String card_id;
	/** 是否开启买单功能 */
    private Boolean is_open;

    /**
     * 构造器
     * @param cardId  卡券ID
     * @param isOpen  是否开启买单功能
     */
    public CardPayCellSetRequest(String cardId, Boolean isOpen) {
        this.card_id = cardId;
        this.is_open = isOpen;
    }

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/card/paycell/set?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<CardPayCellSetRespone> getResponseClass(){
        return CardPayCellSetRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        wxHashMap.put("card_id", this.card_id);
        wxHashMap.put("is_open", this.is_open);
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

	public Boolean getIs_open() {
		return is_open;
	}
	public void setIs_open(Boolean is_open) {
		this.is_open = is_open;
	}

}
