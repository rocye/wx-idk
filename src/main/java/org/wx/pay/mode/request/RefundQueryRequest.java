package org.wx.pay.mode.request;

import org.wx.pay.base.Request;
import org.wx.pay.mode.response.RefundQueryRespone;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>查询退款请求对象
 * <p>提交退款申请后，通过调用该接口查询退款状态。退款有一定延时，用零钱支付的退款20分钟内到账，银行卡支付的退款3个工作日后重新查询退款状态。
 * <p>注意：如果单个支付订单部分退款次数超过20次请使用退款单号查询
 * <p>分页查询
 * <p>当一个订单部分退款超过10笔后，商户用微信订单号或商户订单号调退款查询API查询退款时，默认返回前10笔和total_refund_count（订单总退款次数）。
 * 商户需要查询同一订单下超过10笔的退款单时，可传入订单号及offset来查询，微信支付会返回offset及后面的10笔，以此类推。
 * 当商户传入的offset超过total_refund_count，则系统会返回报错PARAM_ERROR。
 * <p>不需要证书
 * @author Rocye
 * @version 2017.11.20
 */
public class RefundQueryRequest implements Request<RefundQueryRespone> {
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
	/** 微信订单号：查询的优先级是： refund_id 大于 out_refund_no 大于 transaction_id 大于 out_trade_no */
	private String transaction_id;
	/** 商户订单号 */
	private String out_trade_no;
	/** 商户退款单号 */
	private String out_refund_no;
	/** 微信生成的退款单号，在申请退款接口有返回 */
	private String refund_id;
	/** 偏移量，当部分退款次数超过10次时可使用，表示返回的查询结果从这个偏移量开始取记录 */
	private Integer offset;

	/**
	 * 微信退款单号静态构造器
	 * @param appid			公众账号ID
	 * @param mchId			微信支付分配的商户号
	 * @param nonceStr		随机字符串
	 * @param refundId		微信退款单号
	 * @return 请求对象
	 */
	public static RefundQueryRequest getRequestByRefundId(String appid, String mchId, String nonceStr, String refundId){
		return new RefundQueryRequest(appid, mchId, nonceStr, null, null, null, null, refundId, null);
	}

	/**
	 * 商户退款单号静态构造器
	 * @param appid			公众账号ID
	 * @param mchId			微信支付分配的商户号
	 * @param nonceStr		随机字符串
	 * @param outRefundNo	商户退款单号
	 * @return 请求对象
	 */
	public static RefundQueryRequest getRequestByRefundNo(String appid, String mchId, String nonceStr, String outRefundNo){
		return new RefundQueryRequest(appid, mchId, nonceStr, null, null, null, outRefundNo, null, null);
	}

	/**
	 * 微信订单号静态构造器
	 * @param appid			公众账号ID
	 * @param mchId			微信支付分配的商户号
	 * @param nonceStr		随机字符串
	 * @param transactionId	微信订单号
	 * @return 请求对象
	 */
	public static RefundQueryRequest getRequestByTransactionId(String appid, String mchId, String nonceStr, String transactionId){
		return new RefundQueryRequest(appid, mchId, nonceStr, null, transactionId, null, null, null, null);
	}

	/**
	 * 商户订单号静态构造器
	 * @param appid			公众账号ID
	 * @param mchId			微信支付分配的商户号
	 * @param nonceStr		随机字符串
	 * @param outTradeNo	商户订单号
	 * @return 请求对象
	 */
	public static RefundQueryRequest getRequestByTradeNo(String appid, String mchId, String nonceStr, String outTradeNo){
		return new RefundQueryRequest(appid, mchId, nonceStr, null, null, outTradeNo, null, null, null);
	}

	/**
	 * 全参构造器
	 * @param appid			公众账号ID
	 * @param mchId			微信支付分配的商户号
	 * @param nonceStr		随机字符串
	 * @param signType		签名类型
	 * @param transactionId	微信订单号
	 * @param outTradeNo	商户订单号
	 * @param outRefundNo	商户退款单号
	 * @param refundId		微信退款单号
	 * @param offset		偏移量
	 */
	public RefundQueryRequest(String appid, String mchId, String nonceStr, String signType, String transactionId,
							  String outTradeNo, String outRefundNo, String refundId, Integer offset) {
		this.appid = appid;
		this.mch_id = mchId;
		this.nonce_str = nonceStr;
		this.sign_type = signType;
		this.transaction_id = transactionId;
		this.out_trade_no = outTradeNo;
		this.out_refund_no = outRefundNo;
		this.refund_id = refundId;
		this.offset = offset;
	}

	/**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.mch.weixin.qq.com/pay/refundquery";
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<RefundQueryRespone> getResponseClass(){
        return RefundQueryRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
		wxHashMap.put("appid", this.appid);
		wxHashMap.put("mch_id", this.mch_id);
		wxHashMap.put("nonce_str", this.nonce_str);
		if(this.sign_type != null){
			wxHashMap.put("sign_type", this.sign_type);
		}else{
			wxHashMap.put("sign_type", "MD5");
		}
		if(this.transaction_id != null){
			wxHashMap.put("transaction_id", this.transaction_id);
		}else{
			wxHashMap.put("transaction_id", "");
		}
		if(this.out_trade_no != null){
			wxHashMap.put("out_trade_no", this.out_trade_no);
		}else{
			wxHashMap.put("out_trade_no", "");
		}
		if(this.out_refund_no != null){
			wxHashMap.put("out_refund_no", this.out_refund_no);
		}else{
			wxHashMap.put("out_refund_no", "");
		}
		if(this.refund_id != null){
			wxHashMap.put("refund_id", this.refund_id);
		}else{
			wxHashMap.put("refund_id", "");
		}
		if(this.offset != null){
			wxHashMap.put("offset", this.offset);
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

	public String getOut_refund_no() {
		return out_refund_no;
	}
	public void setOut_refund_no(String out_refund_no) {
		this.out_refund_no = out_refund_no;
	}

	public String getRefund_id() {
		return refund_id;
	}
	public void setRefund_id(String refund_id) {
		this.refund_id = refund_id;
	}

	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}

}
