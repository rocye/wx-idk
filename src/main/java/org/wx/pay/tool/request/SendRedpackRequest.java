package org.wx.pay.tool.request;

import org.wx.pay.tool.response.SendRedpackRespone;
import org.wx.pay.base.Request;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>发放普通红包请求对象
 * <p>发放规则：
 * <br>1.发送频率限制------默认1800/min
 * <br>2.发送个数上限------按照默认1800/min算
 * <br>3.金额上限------根据传入场景id不同默认上限不同，可以在商户平台产品设置进行设置和申请，最大不大于4999元/个
 * <br>4.其他的“量”上的限制还有哪些？------用户当天的领取上限次数,默认是10
 * <br>5.如果量上满足不了我们的需求，如何提高各个上限？------金额上限和用户当天领取次数上限可以在商户平台进行设置
 * <p>注意1-红包金额大于200时，请求参数scene_id必传，参数说明见下文。
 * <br>注意2-根据监管要求，新申请商户号使用现金红包需要满足两个条件：1、入驻时间超过90天 2、连续正常交易30天。
 * @author Rocye
 * @version 2017.11.13
 */
public class SendRedpackRequest implements Request<SendRedpackRespone> {
    /** 请求参数的Map */
	protected Map<String, Object> wxHashMap = new HashMap<String, Object>();

    /** 随机字符串，不长于32位 */
    protected String nonce_str;
	/** 商户订单号（每个订单号必须唯一。取值范围：0~9，a~z，A~Z） */
	protected String mch_billno;
	/** 微信支付分配的商户号 */
	protected String mch_id;
	/** 公众账号appid */
	protected String wxappid;
	/** 商户名称即红包发送者名称 */
	protected String send_name;
	/** 接受红包的用户openid */
	protected String re_openid;
	/** 付款金额，单位分 */
	protected Integer total_amount;
	/** 红包发放总人数 */
	protected Integer total_num;
	/** 红包祝福语 */
	protected String wishing;
	/** 调用接口的机器Ip地址 */
	protected String client_ip;
	/** 活动名称 */
	protected String act_name;
	/** 备注信息 */
	protected String remark;
	/** 发放红包使用场景，红包金额大于200时必传(否) */
	protected String scene_id;
	/** 活动信息(否) */
	protected String risk_info;
	/** 资金授权商户号(否) */
	protected String consume_mch_id;

	/**
	 * 无参构造器
	 */
	public SendRedpackRequest() {
	}

	/**
	 * 构造器
	 * @param sendName		商户名称即红包发送者名称
	 * @param reOpenid		接受红包的用户openid
	 * @param totalAmount	付款金额，单位分
	 * @param totalNum		红包发放总人数
	 * @param wishing		红包祝福语
	 * @param actName		活动名称
	 * @param remark		备注信息
	 */
	public SendRedpackRequest(String sendName, String reOpenid, Integer totalAmount, Integer totalNum,
							  String wishing, String actName, String remark) {
		this.send_name = sendName;
		this.re_openid = reOpenid;
		this.total_amount = totalAmount;
		this.total_num = totalNum;
		this.wishing = wishing;
		this.act_name = actName;
		this.remark = remark;
	}

	/**
	 * 构造器
	 * @param nonceStr		随机字符串，不长于32位
	 * @param mchBillno		商户订单号
	 * @param mchId			微信支付分配的商户号
	 * @param wxappid		公众账号appid
	 * @param sendName		商户名称即红包发送者名称
	 * @param reOpenid		接受红包的用户openid
	 * @param totalAmount	付款金额，单位分
	 * @param totalNum		红包发放总人数
	 * @param wishing		红包祝福语
	 * @param clientIp		调用接口的机器Ip地址
	 * @param actName		活动名称
	 * @param remark		备注信息
	 */
	public SendRedpackRequest(String nonceStr, String mchBillno, String mchId, String wxappid, String sendName,
							  String reOpenid, Integer totalAmount, Integer totalNum, String wishing,
							  String clientIp, String actName, String remark) {
		this(nonceStr, mchBillno, mchId, wxappid, sendName, reOpenid, totalAmount, totalNum, wishing, clientIp, actName, remark, null, null, null);
	}

	/**
	 * 构造器
	 * @param nonceStr		随机字符串，不长于32位
	 * @param mchBillno		商户订单号
	 * @param mchId			微信支付分配的商户号
	 * @param wxappid		公众账号appid
	 * @param sendName		商户名称即红包发送者名称
	 * @param reOpenid		接受红包的用户openid
	 * @param totalAmount	付款金额，单位分
	 * @param totalNum		红包发放总人数
	 * @param wishing		红包祝福语
	 * @param clientIp		调用接口的机器Ip地址
	 * @param actName		活动名称
	 * @param remark		备注信息
	 * @param sceneId		发放红包使用场景，红包金额大于200时必传(否)
	 */
	public SendRedpackRequest(String nonceStr, String mchBillno, String mchId, String wxappid, String sendName,
							  String reOpenid, Integer totalAmount, Integer totalNum, String wishing,
							  String clientIp, String actName, String remark, String sceneId) {
		this(nonceStr, mchBillno, mchId, wxappid, sendName, reOpenid, totalAmount, totalNum, wishing, clientIp, actName, remark, sceneId, null, null);
	}

	/**
	 * 全参构造器
	 * @param nonceStr		随机字符串，不长于32位
	 * @param mchBillno		商户订单号
	 * @param mchId			微信支付分配的商户号
	 * @param wxappid		公众账号appid
	 * @param sendName		商户名称即红包发送者名称
	 * @param reOpenid		接受红包的用户openid
	 * @param totalAmount	付款金额，单位分
	 * @param totalNum		红包发放总人数
	 * @param wishing		红包祝福语
	 * @param clientIp		调用接口的机器Ip地址
	 * @param actName		活动名称
	 * @param remark		备注信息
	 * @param sceneId		发放红包使用场景，红包金额大于200时必传(否)
	 * @param riskInfo		活动信息(否)
	 * @param consumeMchId	资金授权商户号(否)
	 */
	public SendRedpackRequest(String nonceStr, String mchBillno, String mchId, String wxappid, String sendName,
							  String reOpenid, Integer totalAmount, Integer totalNum, String wishing, String clientIp,
							  String actName, String remark, String sceneId, String riskInfo, String consumeMchId) {
		this.nonce_str = nonceStr;
		this.mch_billno = mchBillno;
		this.mch_id = mchId;
		this.wxappid = wxappid;
		this.send_name = sendName;
		this.re_openid = reOpenid;
		this.total_amount = totalAmount;
		this.total_num = totalNum;
		this.wishing = wishing;
		this.client_ip = clientIp;
		this.act_name = actName;
		this.remark = remark;
		this.scene_id = sceneId;
		this.risk_info = riskInfo;
		this.consume_mch_id = consumeMchId;
	}

	/**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack";
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<SendRedpackRespone> getResponseClass(){
        return SendRedpackRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
		wxHashMap.put("nonce_str", this.nonce_str);
		wxHashMap.put("mch_billno", this.mch_billno);
		wxHashMap.put("mch_id", this.mch_id);
		wxHashMap.put("wxappid", this.wxappid);
		wxHashMap.put("send_name", this.send_name);
		wxHashMap.put("re_openid", this.re_openid);
		wxHashMap.put("total_amount", this.total_amount);
		wxHashMap.put("total_num", this.total_num);
		wxHashMap.put("wishing", this.wishing);
		wxHashMap.put("client_ip", this.client_ip);
		wxHashMap.put("act_name", this.act_name);
		wxHashMap.put("remark", this.remark);
		if(this.scene_id != null){
			wxHashMap.put("scene_id", this.scene_id);
		}
		if(this.risk_info != null){
			wxHashMap.put("risk_info", this.risk_info);
		}
		if(this.consume_mch_id != null){
			wxHashMap.put("consume_mch_id", this.consume_mch_id);
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

	public String getWxappid() {
		return wxappid;
	}
	public void setWxappid(String wxappid) {
		this.wxappid = wxappid;
	}

	public String getSend_name() {
		return send_name;
	}
	public void setSend_name(String send_name) {
		this.send_name = send_name;
	}

	public String getRe_openid() {
		return re_openid;
	}
	public void setRe_openid(String re_openid) {
		this.re_openid = re_openid;
	}

	public Integer getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(Integer total_amount) {
		this.total_amount = total_amount;
	}

	public Integer getTotal_num() {
		return total_num;
	}
	public void setTotal_num(Integer total_num) {
		this.total_num = total_num;
	}

	public String getWishing() {
		return wishing;
	}
	public void setWishing(String wishing) {
		this.wishing = wishing;
	}

	public String getClient_ip() {
		return client_ip;
	}
	public void setClient_ip(String client_ip) {
		this.client_ip = client_ip;
	}

	public String getAct_name() {
		return act_name;
	}
	public void setAct_name(String act_name) {
		this.act_name = act_name;
	}

	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getScene_id() {
		return scene_id;
	}
	public void setScene_id(String scene_id) {
		this.scene_id = scene_id;
	}

	public String getRisk_info() {
		return risk_info;
	}
	public void setRisk_info(String risk_info) {
		this.risk_info = risk_info;
	}

	public String getConsume_mch_id() {
		return consume_mch_id;
	}
	public void setConsume_mch_id(String consume_mch_id) {
		this.consume_mch_id = consume_mch_id;
	}

}
