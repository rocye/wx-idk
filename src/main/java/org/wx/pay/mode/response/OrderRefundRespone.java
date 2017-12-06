package org.wx.pay.mode.response;

import org.wx.pay.base.Response;

/**
 * 申请退款返回对象
 * @author Rocye
 * @version 2017.11.20
 */
public class OrderRefundRespone extends Response {
	/** 公众账号ID */
	private String appid;
	/** 商户号 */
	private String mch_id;
	/** 微信订单号 */
	private String transaction_id;
	/** 商户订单号 */
	private String out_trade_no;
	/** 商户退款单号 */
	private String out_refund_no;
	/** 微信退款单号 */
	private String refund_id;
	/** 退款总金额,单位为分,可以做部分退款 */
	private Integer refund_fee;
	/** 去掉非充值代金券退款金额后的退款金额，退款金额=申请退款金额-非充值代金券退款金额，退款金额&lt;=申请退款金额 (否) */
	private Integer settlement_refund_fee;
	/** 订单总金额，单位为分 */
	private Integer total_fee;
	/** 去掉非充值代金券金额后的订单总金额，应结订单金额=订单金额-非充值代金券金额，应结订单金额&lt;=订单金额 (否) */
	private Integer settlement_total_fee;
	/** 标价币种，默认人民币：CNY (否) */
	private String fee_type;
	/** 现金支付金额 */
	private Integer cash_fee;
	/** 现金支付币种，默认人民币：CNY (否) */
	private String cash_fee_type;
	/** 现金退款金额，单位为分 (否) */
	private Integer cash_refund_fee;
	/** 代金券退款金额&lt;=退款金额，退款金额-代金券或立减优惠退款金额为现金 (否) */
	private Integer coupon_refund_fee;
	/** 退款代金券使用数量 (否) */
	private Integer coupon_refund_count;

////自行从ResultMap中去取////
//	/** 代金券类型：CASH--充值代金券 NO_CASH---非充值优惠券
//	 * 开通免充值券功能，并且订单使用了优惠券后有返回（取值：CASH、NO_CASH）。
//	 * $n为下标,从0开始编号，举例：coupon_type_$0 (否) */
//	private Integer coupon_type_$n;
//	/** 单个代金券退款金额 (否) */
//	private Integer coupon_refund_fee_$n;
//	/** 退款代金券ID (否) */
//	private String coupon_refund_id_$n;

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

	public Integer getRefund_fee() {
		return refund_fee;
	}
	public void setRefund_fee(Integer refund_fee) {
		this.refund_fee = refund_fee;
	}

	public Integer getSettlement_refund_fee() {
		return settlement_refund_fee;
	}
	public void setSettlement_refund_fee(Integer settlement_refund_fee) {
		this.settlement_refund_fee = settlement_refund_fee;
	}

	public Integer getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(Integer total_fee) {
		this.total_fee = total_fee;
	}

	public Integer getSettlement_total_fee() {
		return settlement_total_fee;
	}
	public void setSettlement_total_fee(Integer settlement_total_fee) {
		this.settlement_total_fee = settlement_total_fee;
	}

	public String getFee_type() {
		return fee_type;
	}
	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}

	public Integer getCash_fee() {
		return cash_fee;
	}
	public void setCash_fee(Integer cash_fee) {
		this.cash_fee = cash_fee;
	}

	public String getCash_fee_type() {
		return cash_fee_type;
	}
	public void setCash_fee_type(String cash_fee_type) {
		this.cash_fee_type = cash_fee_type;
	}

	public Integer getCash_refund_fee() {
		return cash_refund_fee;
	}
	public void setCash_refund_fee(Integer cash_refund_fee) {
		this.cash_refund_fee = cash_refund_fee;
	}

	public Integer getCoupon_refund_fee() {
		return coupon_refund_fee;
	}
	public void setCoupon_refund_fee(Integer coupon_refund_fee) {
		this.coupon_refund_fee = coupon_refund_fee;
	}

	public Integer getCoupon_refund_count() {
		return coupon_refund_count;
	}
	public void setCoupon_refund_count(Integer coupon_refund_count) {
		this.coupon_refund_count = coupon_refund_count;
	}

}
