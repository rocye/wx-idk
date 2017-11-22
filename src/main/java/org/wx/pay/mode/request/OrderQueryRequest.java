package org.wx.pay.mode.request;

import org.wx.pay.base.Request;
import org.wx.pay.mode.response.OrderQueryRespone;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>查询订单请求对象
 * <p>该接口提供所有微信支付订单的查询，商户可以通过查询订单接口主动查询订单状态，完成下一步的业务逻辑。
 * <p>需要调用查询接口的情况：
 * <br>1.当商户后台、网络、服务器等出现异常，商户系统最终未接收到支付通知；
 * <br>2.调用支付接口后，返回系统错误或未知交易状态情况；
 * <br>3.调用刷卡支付API，返回USERPAYING的状态；
 * <br>4.调用关单或撤销接口API之前，需确认支付状态；
 * <p>不需要证书
 * @author Rocye
 * @version 2017.11.20
 */
public class OrderQueryRequest implements Request<OrderQueryRespone> {
    /** 请求参数的Map */
	private Map<String, Object> wxHashMap = new HashMap<String, Object>();

	/** 公众账号appid */
	private String appid;
	/** 微信支付分配的商户号 */
	private String mch_id;
	/** 微信订单号 */
	private String transaction_id;
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
	 * @param transactionId	微信订单号
	 * @param nonceStr		随机字符串
	 */
	public OrderQueryRequest(String appid, String mchId, String transactionId, String nonceStr) {
		this.appid = appid;
		this.mch_id = mchId;
		this.transaction_id = transactionId;
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
	public OrderQueryRequest(String appid, String mchId, String outTradeNo, String nonceStr, String signType) {
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
        String url = "https://api.mch.weixin.qq.com/pay/orderquery";
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<OrderQueryRespone> getResponseClass(){
        return OrderQueryRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
		wxHashMap.put("appid", this.appid);
		wxHashMap.put("mch_id", this.mch_id);
		wxHashMap.put("nonce_str", this.nonce_str);
		wxHashMap.put("sign_type", this.sign_type);
		if(this.transaction_id != null){
			wxHashMap.put("transaction_id", this.transaction_id);
		}
		if(this.out_trade_no != null){
			wxHashMap.put("out_trade_no", this.out_trade_no);
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

	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
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
