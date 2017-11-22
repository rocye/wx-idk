package org.wx.pay.tool.request;

import org.wx.pay.base.Request;
import org.wx.pay.tool.response.GetRedpackInfoRespone;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>发放普通红包请求对象
 * <p>用于商户对已发放的红包进行查询红包的具体信息，可支持普通红包和裂变包。
 * @author Rocye
 * @version 2017.11.14
 */
public class GetRedpackInfoRequest implements Request<GetRedpackInfoRespone> {
    /** 请求参数的Map */
	private Map<String, Object> wxHashMap = new HashMap<String, Object>();

    /** 随机字符串，不长于32位 */
    private String nonce_str;
	/** 商户发放红包的商户订单号 */
	private String mch_billno;
	/** 微信支付分配的商户号 */
	private String mch_id;
	/** 公众账号appid */
	private String appid;
	/** 订单类型：MCHT:通过商户订单号获取红包信息 */
	private String bill_type;

	/**
	 * 无参构造器
	 */
	public GetRedpackInfoRequest() {
	}

	/**
	 * 全参构造器
	 * @param nonceStr		随机字符串，不长于32位
	 * @param mchBillno		商户订单号
	 * @param mchId			微信支付分配的商户号
	 * @param appid			公众账号appid
	 * @param billType		订单类型(MCHT:通过商户订单号获取红包信息)
	 */
	public GetRedpackInfoRequest(String nonceStr, String mchBillno, String mchId, String appid, String billType) {
		this.nonce_str = nonceStr;
		this.mch_billno = mchBillno;
		this.mch_id = mchId;
		this.appid = appid;
		this.bill_type = billType;
	}

	/**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.mch.weixin.qq.com/mmpaymkttransfers/gethbinfo";
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<GetRedpackInfoRespone> getResponseClass(){
        return GetRedpackInfoRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
		wxHashMap.put("nonce_str", this.nonce_str);
		wxHashMap.put("mch_billno", this.mch_billno);
		wxHashMap.put("mch_id", this.mch_id);
		wxHashMap.put("appid", this.appid);
		wxHashMap.put("bill_type", this.bill_type);
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

	public String getMch_billno() {
		return mch_billno;
	}
	public void setMch_billno(String mch_billno) {
		this.mch_billno = mch_billno;
	}

	public String getMch_id() {
		return mch_id;
	}
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getBill_type() {
		return bill_type;
	}
	public void setBill_type(String bill_type) {
		this.bill_type = bill_type;
	}

}
