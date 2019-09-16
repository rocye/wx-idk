package org.wx.sdk.card.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.card.respone.CardGetRespone;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>查看卡券详情请求对象
 * <p>开发者可以调用该接口查询某个card_id的创建信息、审核状态以及库存数量。
 * <p>开发者注意事项：
 * <p>1.对于部分有特殊权限的商家，查询卡券详情得到的返回可能含特殊接口的字段。
 * <p>2.由于卡券字段会持续更新，实际返回字段包含但不限于文档中的字段，建议开发者开发时对于不理解的字段不做处理，以免出错。
 * @author Rocye
 * @version 2017.12.29
 */
public class CardGetRequest implements Request<CardGetRespone> {

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
	public CardGetRequest(String cardId) {
		this.card_id = cardId;
	}

	/**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/card/get?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<CardGetRespone> getResponseClass(){
        return CardGetRespone.class;
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

}
