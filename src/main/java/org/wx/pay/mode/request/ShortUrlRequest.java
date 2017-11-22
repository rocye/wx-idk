package org.wx.pay.mode.request;

import org.wx.pay.base.Request;
import org.wx.pay.mode.response.ShortUrlRespone;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>转换短链接请求对象
 * <p>该接口主要用于扫码原生支付模式一中的二维码链接转成短链接(weixin://wxpay/s/XXXXXX)，减小二维码数据量，提升扫描速度和精确度。
 * <p>不需要证书
 * @author Rocye
 * @version 2017.11.21
 */
public class ShortUrlRequest implements Request<ShortUrlRespone> {
    /** 请求参数的Map */
	private Map<String, Object> wxHashMap = new HashMap<String, Object>();

	/** 公众账号appid */
	private String appid;
	/** 微信支付分配的商户号 */
	private String mch_id;
	/** 随机字符串，不长于32位 */
    private String nonce_str;
	/** 签名类型，默认为MD5，支持HMAC-SHA256和MD5 (否) */
	private String sign_type = "MD5";
	/** 需要转换的URL，签名用原串，传输需URLencode */
	private String long_url;

	/**
	 * 构造器
	 * @param appid		公众账号appid
	 * @param mchId		微信支付分配的商户号
	 * @param nonceStr	随机字符串
	 * @param longUrl	需要转换的URL，签名用原串，传输需URLencode
	 */
	public ShortUrlRequest(String appid, String mchId, String nonceStr, String longUrl) {
		this(appid, mchId, nonceStr, "MD5", longUrl);
	}

	/**
	 * 全参构造器
	 * @param appid		公众账号appid
	 * @param mchId		微信支付分配的商户号
	 * @param nonceStr	随机字符串
	 * @param signType	签名类型，默认为MD5，支持HMAC-SHA256和MD5 (否)
	 * @param longUrl	需要转换的URL，签名用原串，传输需URLencode
	 */
	public ShortUrlRequest(String appid, String mchId, String nonceStr, String signType, String longUrl) {
		this.appid = appid;
		this.mch_id = mchId;
		this.nonce_str = nonceStr;
		this.sign_type = signType;
		this.long_url = longUrl;
	}

	/**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.mch.weixin.qq.com/tools/shorturl";
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<ShortUrlRespone> getResponseClass(){
        return ShortUrlRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
		wxHashMap.put("appid", this.appid);
		wxHashMap.put("mch_id", this.mch_id);
		wxHashMap.put("nonce_str", this.nonce_str);
		wxHashMap.put("sign_type", this.sign_type);
		wxHashMap.put("long_url", this.long_url);
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
        return "xml";
    }

	/**
	 * 获取请求是否需要证书
	 * @return 是否证书请求
	 */
	public boolean getUseCert() {
		return false;
	}

	///////////////////////////////////////Get&Set////////////////////////////////////
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMch_id() {
		return mch_id;
	}
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getNonce_str() {
		return nonce_str;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getSign_type() {
		return sign_type;
	}
	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	public String getLong_url() {
		return long_url;
	}
	public void setLong_url(String long_url) {
		this.long_url = long_url;
	}

}
