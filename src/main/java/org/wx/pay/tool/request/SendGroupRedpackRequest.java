package org.wx.pay.tool.request;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>发放裂变红包请求对象
 * <p>发放规则：
 * <br>一次可以发放一组红包。首先领取的用户为种子用户，种子用户领取一组红包当中的一个，并可以通过社交分享将剩下的红包给其他用户。
 * 裂变红包充分利用了人际传播的优势。
 * @author Rocye
 * @version 2017.11.14
 */
public class SendGroupRedpackRequest extends SendRedpackRequest {

    /** 红包金额设置方式：ALL_RAND—全部随机,商户指定总金额和红包发放总人数，由微信支付随机计算出各红包金额 */
    private String amt_type = "ALL_RAND";

	/**
	 * 无参构造器
	 */
	public SendGroupRedpackRequest() {
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
	public SendGroupRedpackRequest(String sendName, String reOpenid, Integer totalAmount, Integer totalNum,
								   String wishing, String actName, String remark) {
		super(sendName, reOpenid, totalAmount, totalNum, wishing, actName, remark);
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
	public SendGroupRedpackRequest(String nonceStr, String mchBillno, String mchId, String wxappid, String sendName,
								   String reOpenid, Integer totalAmount, Integer totalNum, String wishing,
								   String clientIp, String actName, String remark) {
		super(nonceStr, mchBillno, mchId, wxappid, sendName, reOpenid, totalAmount, totalNum, wishing, clientIp, actName, remark, null, null, null);
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
	public SendGroupRedpackRequest(String nonceStr, String mchBillno, String mchId, String wxappid, String sendName,
								   String reOpenid, Integer totalAmount, Integer totalNum, String wishing,
								   String clientIp, String actName, String remark, String sceneId) {
		super(nonceStr, mchBillno, mchId, wxappid, sendName, reOpenid, totalAmount, totalNum, wishing, clientIp, actName, remark, sceneId, null, null);
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
	public SendGroupRedpackRequest(String nonceStr, String mchBillno, String mchId, String wxappid, String sendName,
								   String reOpenid, Integer totalAmount, Integer totalNum, String wishing, String clientIp,
								   String actName, String remark, String sceneId, String riskInfo, String consumeMchId) {
		super(nonceStr, mchBillno, mchId, wxappid, sendName, reOpenid, totalAmount, totalNum, wishing, clientIp, actName, remark, sceneId, riskInfo, consumeMchId);
	}

	/**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendgroupredpack";
        return url;
    }

    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
		super.getWxHashMap();
		wxHashMap.put("amt_type", this.amt_type);
        return wxHashMap;
    }

	public String getAmt_type() {
		return amt_type;
	}
	public void setAmt_type(String amt_type) {
		this.amt_type = amt_type;
	}

}
