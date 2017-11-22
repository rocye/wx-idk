package org.wx.pay.tool.request;

import org.wx.pay.base.Request;
import org.wx.pay.tool.response.GetQyTransferinfoRespone;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>查询企业付款请求对象
 * <p>用于商户的企业付款操作进行结果查询，返回付款操作详细结果。
 * <p>查询企业付款API只支持查询30天内的订单，30天之前的订单请登录商户平台查询。
 * @author Rocye
 * @version 2017.11.16
 */
public class GetQyTransferinfoRequest implements Request<GetQyTransferinfoRespone> {
    /** 请求参数的Map */
	private Map<String, Object> wxHashMap = new HashMap<String, Object>();

    /** 随机字符串，不长于32位 */
	private String nonce_str;
	/** 商户订单号 */
	private String partner_trade_no;
	/** 商户号 */
	private String mch_id;
	/** 商户账号appid */
	private String appid;

	/**
	 * 无参构造器
	 */
	public GetQyTransferinfoRequest() {
	}

	/**
	 * 全参构造器
	 * @param nonceStr			随机字符串
	 * @param appid				商户账号appid
	 * @param mchid				商户号
	 * @param partnerTradeNo	商户订单号
	 */
	public GetQyTransferinfoRequest(String nonceStr, String appid, String mchid, String partnerTradeNo) {
		this.nonce_str = nonceStr;
		this.appid = appid;
		this.mch_id = mchid;
		this.partner_trade_no = partnerTradeNo;
	}

	/**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.mch.weixin.qq.com/mmpaymkttransfers/gettransferinfo";
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<GetQyTransferinfoRespone> getResponseClass(){
        return GetQyTransferinfoRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
		wxHashMap.put("nonce_str", this.nonce_str);
		wxHashMap.put("partner_trade_no", this.partner_trade_no);
		wxHashMap.put("mch_id", this.mch_id);
		wxHashMap.put("appid", this.appid);
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

	public String getPartner_trade_no() {
		return partner_trade_no;
	}
	public void setPartner_trade_no(String partner_trade_no) {
		this.partner_trade_no = partner_trade_no;
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

}
