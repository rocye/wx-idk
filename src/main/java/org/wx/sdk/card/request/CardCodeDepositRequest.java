package org.wx.sdk.card.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.card.respone.CardCodeDepositRespone;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>导入code请求对象
 * <p>在自定义code卡券成功创建并且通过审核后，必须将自定义code按照与发券方的约定数量调用导入code接口导入微信后台。
 * <p>开发者可调用该接口将自定义code导入微信卡券后台，由微信侧代理存储并下发code。
 * <p>1) 单次调用接口传入code的数量上限为100个;
 * <p>2) 每一个 code 均不能为空串;
 * <p>3) 导入结束后系统会自动判断提供方设置库存与实际导入code的量是否一致;
 * <p>4) 导入失败支持重复导入，提示成功为止。
 * @author Rocye
 * @version 2017.12.26
 */
public class CardCodeDepositRequest implements Request<CardCodeDepositRespone> {

	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();

    /** 需要进行导入code的卡券ID */
    private String card_id;
	/** 需导入微信卡券后台的自定义code，上限为100个 */
    private List<String> code;

	/**
	 * 构造器
	 * @param cardId	需要进行导入code的卡券ID
	 * @param code		需导入微信卡券后台的自定义code，上限为100个
	 */
	public CardCodeDepositRequest(String cardId, List<String> code) {
		this.card_id = cardId;
		this.code = code;
	}

	/**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "http://api.weixin.qq.com/card/code/deposit?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<CardCodeDepositRespone> getResponseClass(){
        return CardCodeDepositRespone.class;
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
