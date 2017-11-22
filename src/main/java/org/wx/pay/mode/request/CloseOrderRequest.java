package org.wx.pay.mode.request;

import org.wx.pay.base.Request;
import org.wx.pay.mode.response.CloseOrderRespone;
import org.wx.pay.mode.response.OrderQueryRespone;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>关闭订单请求对象
 * <p>以下情况需要调用关单接口：
 * <br>商户订单支付失败需要生成新单号重新发起支付，要对原订单号调用关单，避免重复支付；
 * <br>系统下单后，用户支付超时，系统退出不再受理，避免用户继续，请调用关单接口。
 * <p>注意：订单生成后不能马上调用关单接口，最短调用时间间隔为5分钟。
 * <p>不需要证书
 * @author Rocye
 * @version 2017.11.20
 */
public class CloseOrderRequest implements Request<CloseOrderRespone> {
    /** 请求参数的Map */
	private Map<String, Object> wxHashMap = new HashMap<String, Object>();

	/** 公众账号appid */
	private String appid;
	/** 微信支付分配的商户号 */
	private String mch_id;
	/** 商户订单号 */
	private String out_trade_no;
	/** 随机字符串，不长于32位 */
    private String nonce_str;
	/** 签名类型，默认为MD5，支持HMAC-SHA256和MD5 (否) */
	private String sign_type = "MD5";

	/**
	 * 全参构造器
	 * @param appid			公众账号appid
	 * @param mchId			微信支付分配的商户号
	 * @param outTradeNo	商户订单号
	 * @param nonceStr		随机字符串
	 */
	public CloseOrderRequest(String appid, String mchId, String outTradeNo, String nonceStr) {
		this.appid = appid;
		this.mch_id = mchId;
		this.out_trade_no = outTradeNo;
		this.nonce_str = nonceStr;
	}

	/**
	 * 全参构造器
	 * @param appid			公众账号appid
	 * @param mchId			微信支付分配的商户号
	 * @param outTradeNo	商户订单号
	 * @param nonceStr		随机字符串
	 * @param signType		签名类型，默认为MD5，支持HMAC-SHA256和MD5
	 */
	public CloseOrderRequest(String appid, String mchId, String outTradeNo, String nonceStr, String signType) {
		this.appid = appid;
		this.mch_id = mchId;
		this.out_trade_no = outTradeNo;
		this.nonce_str = nonceStr;
		if(signType != null){
			this.sign_type = signType;
		}else{
			this.sign_type = "MD5";
		}
	}

	/**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.mch.weixin.qq.com/pay/closeorder";
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<CloseOrderRespone> getResponseClass(){
        return CloseOrderRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
		wxHashMap.put("appid", this.appid);
		wxHashMap.put("mch_id", this.mch_id);
		wxHashMap.put("nonce_str", this.nonce_str);
		wxHashMap.put("sign_type", this.sign_type);
		wxHashMap.put("out_trade_no", this.out_trade_no);
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

	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
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

}
