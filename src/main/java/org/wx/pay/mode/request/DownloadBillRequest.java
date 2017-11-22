package org.wx.pay.mode.request;

import org.wx.pay.base.Request;
import org.wx.pay.mode.response.DownloadBillRespone;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>下载对账单请求对象
 * <p>商户可以通过该接口下载历史交易清单。比如掉单、系统错误等导致商户侧和微信侧数据不一致，通过对账单核对后可校正支付状态。注意：
 * <p>1、微信侧未成功下单的交易不会出现在对账单中。支付成功后撤销的交易会出现在对账单中，跟原支付单订单号一致；
 * <br>2、微信在次日9点启动生成前一天的对账单，建议商户10点后再获取；
 * <br>3、对账单中涉及金额的字段单位为“元”。
 * <br>4、对账单接口只能下载三个月以内的账单。
 * <p>不需要证书
 * @author Rocye
 * @version 2017.11.20
 */
public class DownloadBillRequest implements Request<DownloadBillRespone> {
    /** 请求参数的Map */
	private Map<String, Object> wxHashMap = new HashMap<String, Object>();

	/** 公众账号appid */
	private String appid;
	/** 微信支付分配的商户号 */
	private String mch_id;
	/** 微信支付分配的终端设备号 (否) */
	private String device_info;
	/** 随机字符串，不长于32位 */
    private String nonce_str;
	/** 签名类型，默认为MD5，支持HMAC-SHA256和MD5 (否) */
	private String sign_type = "MD5";
	/** 对账单日期 */
	private String bill_date;
	/** 账单类型：
	 * ALL，返回当日所有订单信息，默认值
	 * SUCCESS，返回当日成功支付的订单
	 * REFUND，返回当日退款订单
	 * RECHARGE_REFUND，返回当日充值退款订单 */
	private String bill_type = "ALL";
	/** 压缩账单：非必传参数，固定值：GZIP，返回格式为.gzip的压缩包账单。不传则默认为数据流形式。(否) */
	private String tar_type;

	/** 下载文件路径 (否) */
	private String filePath;
	/** 下载文件名 (否) */
	private String fileName;

	/**
	 * 全参构造器
	 * @param appid		 公众账号appid
	 * @param mchId		 微信支付分配的商户号
	 * @param nonceStr	 随机字符串
	 * @param billDate	 对账单日期
	 * @param billType	 账单类型：ALL，返回当日所有订单信息，默认值 SUCCESS，返回当日成功支付的订单 REFUND，返回当日退款订单 RECHARGE_REFUND，返回当日充值退款订单
	 */
	public DownloadBillRequest(String appid, String mchId, String nonceStr, String billDate, String billType) {
		this(appid, mchId, null, nonceStr, null, billDate, billType, null, null, null);
	}

	/**
	 * 全参构造器
	 * @param appid		 公众账号appid
	 * @param mchId		 微信支付分配的商户号
	 * @param nonceStr	 随机字符串
	 * @param signType	 签名类型
	 * @param billDate	 对账单日期
	 * @param billType	 账单类型：ALL，返回当日所有订单信息，默认值 SUCCESS，返回当日成功支付的订单 REFUND，返回当日退款订单 RECHARGE_REFUND，返回当日充值退款订单
	 */
	public DownloadBillRequest(String appid, String mchId, String nonceStr, String signType, String billDate, String billType) {
		this(appid, mchId, null, nonceStr, signType, billDate, billType, null, null, null);
	}

	/**
	 * 全参构造器
	 * @param appid		 公众账号appid
	 * @param mchId		 微信支付分配的商户号
	 * @param deviceInfo 微信支付分配的终端设备号
	 * @param nonceStr	 随机字符串
	 * @param signType	 签名类型
	 * @param billDate	 对账单日期
	 * @param billType	 账单类型：ALL，返回当日所有订单信息，默认值 SUCCESS，返回当日成功支付的订单 REFUND，返回当日退款订单 RECHARGE_REFUND，返回当日充值退款订单
	 * @param tarType	 压缩账单：非必传参数，固定值：GZIP，返回格式为.gzip的压缩包账单。不传则默认为数据流形式。
	 * @param filePath	 下载文件路径
	 * @param fileName	 下载文件名
	 */
	public DownloadBillRequest(String appid, String mchId, String deviceInfo, String nonceStr, String signType,
							   String billDate, String billType, String tarType, String filePath, String fileName) {
		this.appid = appid;
		this.mch_id = mchId;
		this.device_info = deviceInfo;
		this.nonce_str = nonceStr;
		this.sign_type = signType;
		this.bill_date = billDate;
		this.bill_type = billType;
		this.tar_type = tarType;
		this.filePath = filePath;
		this.fileName = fileName;
	}

	/**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.mch.weixin.qq.com/pay/downloadbill";
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<DownloadBillRespone> getResponseClass(){
        return DownloadBillRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
		wxHashMap.put("appid", this.appid);
		wxHashMap.put("mch_id", this.mch_id);
		if(this.device_info != null){
			wxHashMap.put("device_info", this.device_info);
		}
		wxHashMap.put("nonce_str", this.nonce_str);
		if(this.sign_type != null){
			wxHashMap.put("sign_type", this.sign_type);
		}else{
			wxHashMap.put("sign_type", "MD5");
		}
		wxHashMap.put("bill_date", this.bill_date);
		wxHashMap.put("bill_type", this.bill_type);
		if(this.tar_type != null){
			wxHashMap.put("tar_type", this.tar_type);
		}
		if(this.filePath != null){
			wxHashMap.put("filePath", this.filePath);
		}
		if(this.fileName != null){
			wxHashMap.put("fileName", this.fileName);
		}
        return wxHashMap;
    }
    
    /**
     * 请求类型：1-普通Get 2-下载GET 3-普通POST 4-下载POST 5-无参上传   6-有参上传
     */
    public int getReqType(){
        return 4;
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

	public String getDevice_info() {
		return device_info;
	}
	public void setDevice_info(String device_info) {
		this.device_info = device_info;
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

	public String getBill_date() {
		return bill_date;
	}
	public void setBill_date(String bill_date) {
		this.bill_date = bill_date;
	}

	public String getBill_type() {
		return bill_type;
	}
	public void setBill_type(String bill_type) {
		this.bill_type = bill_type;
	}

	public String getTar_type() {
		return tar_type;
	}
	public void setTar_type(String tar_type) {
		this.tar_type = tar_type;
	}

	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
