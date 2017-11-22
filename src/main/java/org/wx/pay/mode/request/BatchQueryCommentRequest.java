package org.wx.pay.mode.request;

import org.wx.pay.base.Request;
import org.wx.pay.mode.response.BatchQueryCommentRespone;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>拉取订单评价数据请求对象
 * <p>商户可以通过该接口拉取用户在微信支付交易记录中针对你的支付记录进行的评价内容。
 * <p>注意：
 * <br>1.该内容所有权为提供内容的微信用户，商户在使用内容的过程中应遵从用户意愿
 * <br>2.一次最多拉取200条评价数据，可根据时间区间分批次拉取
 * <br>3.接口只能拉取最近三个月以内的评价数据
 * <p>需要证书
 * @author Rocye
 * @version 2017.11.21
 */
public class BatchQueryCommentRequest implements Request<BatchQueryCommentRespone> {
    /** 请求参数的Map */
	private Map<String, Object> wxHashMap = new HashMap<String, Object>();

	/** 公众账号appid */
	private String appid;
	/** 微信支付分配的商户号 */
	private String mch_id;
	/** 随机字符串，不长于32位 */
    private String nonce_str;
	/** 签名类型，目前仅支持HMAC-SHA256，默认就是HMAC-SHA256 (否) */
	private String sign_type = "HMAC-SHA256";
	/** 按用户评论时间批量拉取的起始时间，格式为yyyyMMddHHmmss */
	private String begin_time;
	/** 按用户评论时间批量拉取的结束时间，格式为yyyyMMddHHmmss */
	private String end_time;
	/**
	 * 指定从某条记录的下一条开始返回记录。接口调用成功时，会返回本次查询最后一条数据的offset。
	 * 商户需要翻页时，应该把本次调用返回的offset 作为下次调用的入参。
	 * 注意offset是评论数据在微信支付后台保存的索引，未必是连续的
	 */
	private Long offset;
	/** 一次拉取的条数, 最大值是200，默认是200 (否) */
	private Integer limit;

	/** 下载文件路径 (否) */
	private String filePath;
	/** 下载文件名 (否) */
	private String fileName;

	/**
	 * 全参构造器
	 * @param appid		 	公众账号ID
	 * @param mchId			商户号
	 * @param nonceStr		随机字符串
	 * @param beginTime		开始时间，格式为yyyyMMddHHmmss
	 * @param endTime		结束时间，格式为yyyyMMddHHmmss
	 * @param offset		指定从某条记录的下一条开始返回记录
	 */
	public BatchQueryCommentRequest(String appid, String mchId, String nonceStr, String beginTime, String endTime, Long offset) {
		this(appid, mchId, nonceStr, "HMAC-SHA256", beginTime, endTime, offset, null, null, null);
	}

	/**
	 * 全参构造器
	 * @param appid		 	公众账号ID
	 * @param mchId			商户号
	 * @param nonceStr		随机字符串
	 * @param signType		签名类型，目前仅支持HMAC-SHA256，默认就是HMAC-SHA256 (否)
	 * @param beginTime		开始时间，格式为yyyyMMddHHmmss
	 * @param endTime		结束时间，格式为yyyyMMddHHmmss
	 * @param offset		指定从某条记录的下一条开始返回记录
	 * @param limit			一次拉取的条数, 最大值是200，默认是200 (否)
	 * @param filePath		下载文件路径 (否)
	 * @param fileName		下载文件名 (否)
	 */
	public BatchQueryCommentRequest(String appid, String mchId, String nonceStr, String signType, String beginTime,
									String endTime, Long offset, Integer limit, String filePath, String fileName) {
		this.appid = appid;
		this.mch_id = mchId;
		this.nonce_str = nonceStr;
		this.sign_type = signType;
		this.begin_time = beginTime;
		this.end_time = endTime;
		this.offset = offset;
		this.limit = limit;
		this.filePath = filePath;
		this.fileName = fileName;
	}

	/**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.mch.weixin.qq.com/billcommentsp/batchquerycomment";
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<BatchQueryCommentRespone> getResponseClass(){
        return BatchQueryCommentRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
		wxHashMap.put("appid", this.appid);
		wxHashMap.put("mch_id", this.mch_id);
		wxHashMap.put("nonce_str", this.nonce_str);
		wxHashMap.put("sign_type", this.sign_type);
		wxHashMap.put("begin_time", this.begin_time);
		wxHashMap.put("end_time", this.end_time);
		wxHashMap.put("offset", this.offset);
		if(this.limit != null){
			wxHashMap.put("limit", this.limit);
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

	public String getBegin_time() {
		return begin_time;
	}
	public void setBegin_time(String begin_time) {
		this.begin_time = begin_time;
	}

	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public Long getOffset() {
		return offset;
	}
	public void setOffset(Long offset) {
		this.offset = offset;
	}

	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
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
