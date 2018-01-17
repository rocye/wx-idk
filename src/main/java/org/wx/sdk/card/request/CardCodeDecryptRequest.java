package org.wx.sdk.card.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.card.respone.CardCodeDecryptRespone;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Code解码请求对象
 * <p>解码接口支持两种场景：
 * <p>1.商家获取choos_card_info后，将card_id和encrypt_code字段通过解码接口，获取真实code。
 * <p>2.卡券内跳转外链的签名中会对code进行加密处理，通过调用解码接口获取真实code。
 * <p>注意事项：
 * <p>1.只能解码本公众号卡券获取的加密code。
 * <p>2.开发者若从url上获取到加密code,请注意先进行urldecode，否则报错。
 * <p>3.encrypt_code是卡券的code码经过加密处理得到的加密code码，与code一一对应。
 * <p>4.开发者只能解密本公众号的加密code，否则报错。
 * @author Rocye
 * @version 2017.12.29
 */
public class CardCodeDecryptRequest implements Request<CardCodeDecryptRespone> {

	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();

	/** 经过加密的Code码 */
	private String encrypt_code;

	/**
	 * 构造器
	 * @param encryptCode	经过加密的Code码
	 */
	public CardCodeDecryptRequest(String encryptCode) {
		this.encrypt_code = encryptCode;
	}

	/**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/card/code/decrypt?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<CardCodeDecryptRespone> getResponseClass(){
        return CardCodeDecryptRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
		wxHashMap.put("encrypt_code", this.encrypt_code);
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

	public String getEncrypt_code() {
		return encrypt_code;
	}
	public void setEncrypt_code(String encrypt_code) {
		this.encrypt_code = encrypt_code;
	}

}
