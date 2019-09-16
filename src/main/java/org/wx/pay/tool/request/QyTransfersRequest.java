package org.wx.pay.tool.request;

import org.wx.pay.base.Request;
import org.wx.pay.tool.response.QyTransfersRespone;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>企业付款请求对象
 * <p>用于企业向微信用户个人付款目前支持向指定微信用户的openid付款。
 * <p>接口调用规则：
 * <br>1.给同一个实名用户付款，单笔单日限额2W/2W
 * <br>2.不支持给非实名用户打款
 * <br>3.一个商户同一日付款总额限额100W
 * <br>4.单笔最小金额默认为1元
 * <br>5.每个用户每天最多可付款10次，可以在商户平台--API安全进行设置
 * <br>6.给同一个用户付款时间间隔不得低于15秒
 * <p>注意1-当返回错误码为“SYSTEMERROR”时，一定要使用原单号重试，否则可能造成重复支付等资金风险。
 * <br>注意2-根据监管要求，新申请商户号使用企业付款需要满足两个条件：1、入驻时间超过90天 2、连续正常交易30天。
 * @author Rocye
 * @version 2017.11.15
 */
public class QyTransfersRequest implements Request<QyTransfersRespone> {
    /** 请求参数的Map */
	private Map<String, Object> wxHashMap = new HashMap<String, Object>();

    /** 随机字符串，不长于32位 */
	private String nonce_str;
	/** 商户账号appid */
	private String mch_appid;
	/** 商户号 */
	private String mchid;
	/** 设备号(否) */
	private String device_info;
	/** 商户订单号 */
	private String partner_trade_no;
	/** 用户openid */
	private String openid;
	/** 校验用户姓名选项：NO_CHECK：不校验真实姓名 FORCE_CHECK：强校验真实姓名 */
	private String check_name;
	/** 收款用户姓名(如果check_name设置为FORCE_CHECK，则必填用户真实姓名) */
	private String re_user_name;
	/** 金额 */
	private Integer amount;
	/** 企业付款描述信息 */
	private String desc;
	/** Ip地址 */
	private String spbill_create_ip;

	/**
	 * 无参构造器
	 */
	public QyTransfersRequest() {
	}

	/**
	 * 全参构造器
	 * @param nonceStr			随机字符串
	 * @param mchAppid			商户账号appid
	 * @param mchid				商户号
	 * @param partnerTradeNo	商户订单号
	 * @param openid			用户openid
	 * @param amount			企业付款金额，单位为分
	 * @param desc				企业付款操作说明信息
	 * @param spbillCreateIp	调用接口的机器Ip地址
	 */
	public QyTransfersRequest(String nonceStr, String mchAppid, String mchid, String partnerTradeNo,
							  String openid, Integer amount, String desc, String spbillCreateIp) {
		this.nonce_str = nonceStr;
		this.mch_appid = mchAppid;
		this.mchid = mchid;
		this.partner_trade_no = partnerTradeNo;
		this.openid = openid;
		this.check_name = "NO_CHECK";
		this.amount = amount;
		this.desc = desc;
		this.spbill_create_ip = spbillCreateIp;
	}

	/**
	 * 全参构造器
	 * @param nonceStr			随机字符串
	 * @param mchAppid			商户账号appid
	 * @param mchid				商户号
	 * @param deviceInfo		设备号(否)
	 * @param partnerTradeNo	商户订单号
	 * @param openid		用户openid
	 * @param reUsername	收款用户姓名
	 * @param amount		企业付款金额，单位为分
	 * @param desc			企业付款操作说明信息
	 * @param spbillCreateIp	调用接口的机器Ip地址
	 */
	public QyTransfersRequest(String nonceStr, String mchAppid, String mchid, String deviceInfo, String partnerTradeNo,
							  String openid, String reUsername, Integer amount, String desc, String spbillCreateIp) {
		this.nonce_str = nonceStr;
		this.mch_appid = mchAppid;
		this.mchid = mchid;
		this.device_info = deviceInfo;
		this.partner_trade_no = partnerTradeNo;
		this.openid = openid;
		this.check_name = "FORCE_CHECK";
		this.re_user_name = reUsername;
		this.amount = amount;
		this.desc = desc;
		this.spbill_create_ip = spbillCreateIp;
	}

	/**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<QyTransfersRespone> getResponseClass(){
        return QyTransfersRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
		wxHashMap.put("nonce_str", this.nonce_str);
		wxHashMap.put("mch_appid", this.mch_appid);
		wxHashMap.put("mchid", this.mchid);
		if(this.device_info != null){
			wxHashMap.put("device_info", this.device_info);
		}
		wxHashMap.put("partner_trade_no", this.partner_trade_no);
		wxHashMap.put("openid", this.openid);
		wxHashMap.put("check_name", this.check_name);
		if(this.check_name.equals("FORCE_CHECK")){
			wxHashMap.put("re_user_name", this.re_user_name);
		}
		wxHashMap.put("amount", this.amount);
		wxHashMap.put("desc", this.desc);
		wxHashMap.put("spbill_create_ip", this.spbill_create_ip);
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
	public String getNonce_str() {
		return nonce_str;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getMch_appid() {
		return mch_appid;
	}
	public void setMch_appid(String mch_appid) {
		this.mch_appid = mch_appid;
	}

	public String getMchid() {
		return mchid;
	}
	public void setMchid(String mchid) {
		this.mchid = mchid;
	}

	public String getDevice_info() {
		return device_info;
	}
	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}

	public String getPartner_trade_no() {
		return partner_trade_no;
	}
	public void setPartner_trade_no(String partner_trade_no) {
		this.partner_trade_no = partner_trade_no;
	}

	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getCheck_name() {
		return check_name;
	}
	public void setCheck_name(String check_name) {
		this.check_name = check_name;
	}

	public String getRe_user_name() {
		return re_user_name;
	}
	public void setRe_user_name(String re_user_name) {
		this.re_user_name = re_user_name;
	}

	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}
	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}
}
