package org.wx.pay.mode.response;

import org.wx.pay.base.Response;

/**
 * 查询退款返回对象
 * @author Rocye
 * @version 2017.11.20
 */
public class RefundQueryRespone extends Response {
	/** 公众账号ID */
	private String appid;
	/** 商户号 */
	private String mch_id;
	/** 订单总退款次数 */
	private Integer total_refund_count;
	/** 微信订单号 */
	private String transaction_id;
	/** 商户订单号 */
	private String out_trade_no;
	/** 订单总金额，单位为分 */
	private Integer total_fee;
	/** 当订单使用了免充值型优惠券后返回该参数，应结订单金额=订单金额-免充值优惠券金额 (否)*/
	private Integer settlement_total_fee;
	/** 货币种类，默认人民币：CNY (否) */
	private String fee_type;
	/** 现金支付金额 */
	private Integer cash_fee;
	/** 退款笔数 */
	private Integer refund_count;

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

	public Integer getTotal_refund_count() {
		return total_refund_count;
	}
	public void setTotal_refund_count(Integer total_refund_count) {
		this.total_refund_count = total_refund_count;
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

	public Integer getRefund_count() {
		return refund_count;
	}
	public void setRefund_count(Integer refund_count) {
		this.refund_count = refund_count;
	}

}
