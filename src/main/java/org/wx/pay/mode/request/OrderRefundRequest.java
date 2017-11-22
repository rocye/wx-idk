package org.wx.pay.mode.request;

import org.wx.pay.base.Request;
import org.wx.pay.mode.response.OrderRefundRespone;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>申请退款请求对象
 * <p>当交易发生之后一段时间内，由于买家或者卖家的原因需要退款时，卖家可以通过退款接口将支付款退还给买家，微信支付将在收到退款请求并且验证成功之后，按照退款规则将支付款按原路退到买家帐号上。
 * <p>注意：
 * <br>1、交易时间超过一年的订单无法提交退款；
 * <br>2、微信支付退款支持单笔交易分多次退款，多次退款需要提交原支付订单的商户订单号和设置不同的退款单号。申请退款总金额不能超过订单金额。 一笔退款失败后重新提交，请不要更换退款单号，请使用原商户退款单号；
 * <br>3、请求频率限制：150qps，即每秒钟正常的申请退款请求次数不超过150次错误或无效请求频率限制：6qps，即每秒钟异常或错误的退款申请请求不超过6次；
 * <br>4、每个支付订单的部分退款次数不能超过50次；
 * <p>请求需要双向证书
 * @author Rocye
 * @version 2017.11.20
 */
public class OrderRefundRequest implements Request<OrderRefundRespone> {
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
	/** 商户退款单号 */
	private String out_refund_no;
	/** 订单金额 */
	private Integer total_fee;
	/** 退款金额 */
	private Integer refund_fee;
	/** 货币种类 (否) */
	private String refund_fee_type;
	/** 退款原因 (否) */
	private String refund_desc;
	/** 退款资金来源 (否) */
	private String refund_account;

	/**
	 * 构造器
	 * @param appid			公众账号appid
	 * @param mchId			微信支付分配的商户号
	 * @param transactionId	微信订单号
	 * @param nonceStr		随机字符串
	 * @param outRefundNo	商户退款单号
	 * @param totalFee		订单金额
	 * @param refundFee		退款金额
	 */
	public OrderRefundRequest(String appid, String mchId, String transactionId, String nonceStr,
							  String outRefundNo, Integer totalFee, Integer refundFee) {
		this.appid = appid;
		this.mch_id = mchId;
		this.transaction_id = transactionId;
		this.nonce_str = nonceStr;
		this.out_refund_no = outRefundNo;
		this.total_fee = totalFee;
		this.refund_fee = refundFee;
	}

	/**
	 * 全参构造器
	 * @param appid			公众账号appid
	 * @param mchId			微信支付分配的商户号
	 * @param outTradeNo	商户订单号
	 * @param nonceStr		随机字符串
	 * @param signType		签名类型，默认为MD5，支持HMAC-SHA256和MD5 (否)
	 * @param outRefundNo	商户退款单号
	 * @param totalFee		订单金额
	 * @param refundFee		退款金额
	 */
	public OrderRefundRequest(String appid, String mchId, String outTradeNo, String nonceStr,
							  String signType, String outRefundNo, Integer totalFee, Integer refundFee) {
		this.appid = appid;
		this.mch_id = mchId;
		this.out_trade_no = outTradeNo;
		this.nonce_str = nonceStr;
		if(signType != null){
			this.sign_type = signType;
		}else{
			this.sign_type = "MD5";
		}
		this.out_refund_no = outRefundNo;
		this.total_fee = totalFee;
		this.refund_fee = refundFee;
	}

	/**
	 * 全参构造器
	 * @param appid			公众账号appid
	 * @param mchId			微信支付分配的商户号
	 * @param transactionId	微信订单号
	 * @param outTradeNo	商户订单号
	 * @param nonceStr		随机字符串
	 * @param signType		签名类型，默认为MD5，支持HMAC-SHA256和MD5 (否)
	 * @param outRefundNo	商户退款单号
	 * @param totalFee		订单金额
	 * @param refundFee		退款金额
	 * @param refundFeeType	货币种类 (否)
	 * @param refundDesc	退款原因 (否)
	 * @param refundAccount	退款资金来源 (否)
	 */
	public OrderRefundRequest(String appid, String mchId, String transactionId, String outTradeNo, String nonceStr,
							  String signType, String outRefundNo, Integer totalFee, Integer refundFee,
							  String refundFeeType, String refundDesc, String refundAccount) {
		this.appid = appid;
		this.mch_id = mchId;
		if(transactionId != null){
			this.transaction_id = transactionId;
		}
		if(outTradeNo != null){
			this.out_trade_no = outTradeNo;
		}
		this.nonce_str = nonceStr;
		this.sign_type = signType;
		this.out_refund_no = outRefundNo;
		this.total_fee = totalFee;
		this.refund_fee = refundFee;
		this.refund_fee_type = refundFeeType;
		this.refund_desc = refundDesc;
		this.refund_account = refundAccount;
	}

	/**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.mch.weixin.qq.com/secapi/pay/refund";
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<OrderRefundRespone> getResponseClass(){
        return OrderRefundRespone.class;
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
		wxHashMap.put("out_refund_no", this.out_refund_no);
		wxHashMap.put("total_fee", this.total_fee);
		wxHashMap.put("refund_fee", this.refund_fee);
		if(this.refund_fee_type != null){
			wxHashMap.put("refund_fee_type", this.refund_fee_type);
		}
		if(this.refund_desc != null){
			wxHashMap.put("refund_desc", this.refund_desc);
		}
		if(this.refund_account != null){
			wxHashMap.put("refund_account", this.refund_account);
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
		return true;
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

	public Integer getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(Integer total_fee) {
		this.total_fee = total_fee;
	}

	public Integer getRefund_fee() {
		return refund_fee;
	}
	public void setRefund_fee(Integer refund_fee) {
		this.refund_fee = refund_fee;
	}

	public String getRefund_fee_type() {
		return refund_fee_type;
	}
	public void setRefund_fee_type(String refund_fee_type) {
		this.refund_fee_type = refund_fee_type;
	}

	public String getRefund_desc() {
		return refund_desc;
	}
	public void setRefund_desc(String refund_desc) {
		this.refund_desc = refund_desc;
	}

	public String getRefund_account() {
		return refund_account;
	}
	public void setRefund_account(String refund_account) {
		this.refund_account = refund_account;
	}

}
