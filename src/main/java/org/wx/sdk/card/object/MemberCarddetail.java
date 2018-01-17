package org.wx.sdk.card.object;

/**
 * 单张会员卡数据
 * @author Rocye
 * @version 2018.01.15
 */
public class MemberCarddetail {
	/** 日期信息 */
	private String ref_date;
	/** 子商户类型 */
	private Integer merchanttype;
	/** 卡券ID */
	private String cardid;
	/** 子商户ID */
	private String submerchantid;
	/** 浏览次数 */
	private Integer view_cnt;
	/** 浏览人数 */
	private Integer view_user;
	/** 领取次数 */
	private Integer receive_cnt;
	/** 领取人数 */
	private Integer receive_user;
	/** 使用次数 */
	private Integer verify_cnt;
	/** 使用人数 */
	private Integer verify_user;
	/** 激活次数 */
	private Integer active_cnt;
	/** 激活人数 */
	private Integer active_user;
	/** 有效会员总人数 */
	private Integer total_user;
	/** 新用户数 */
	private Integer new_user;
	/** 应收金额（仅限使用快速买单的会员卡） */
	private Integer payOriginalFee;
	/** 实收金额（仅限使用快速买单的会员卡） */
	private Integer fee;

	public String getRef_date() {
		return ref_date;
	}
	public void setRef_date(String ref_date) {
		this.ref_date = ref_date;
	}

	public Integer getView_cnt() {
		return view_cnt;
	}
	public void setView_cnt(Integer view_cnt) {
		this.view_cnt = view_cnt;
	}

	public Integer getView_user() {
		return view_user;
	}
	public void setView_user(Integer view_user) {
		this.view_user = view_user;
	}

	public Integer getReceive_cnt() {
		return receive_cnt;
	}
	public void setReceive_cnt(Integer receive_cnt) {
		this.receive_cnt = receive_cnt;
	}

	public Integer getReceive_user() {
		return receive_user;
	}
	public void setReceive_user(Integer receive_user) {
		this.receive_user = receive_user;
	}

	public Integer getVerify_cnt() {
		return verify_cnt;
	}
	public void setVerify_cnt(Integer verify_cnt) {
		this.verify_cnt = verify_cnt;
	}

	public Integer getVerify_user() {
		return verify_user;
	}
	public void setVerify_user(Integer verify_user) {
		this.verify_user = verify_user;
	}

	public Integer getMerchanttype() {
		return merchanttype;
	}
	public void setMerchanttype(Integer merchanttype) {
		this.merchanttype = merchanttype;
	}

	public String getCardid() {
		return cardid;
	}
	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	public String getSubmerchantid() {
		return submerchantid;
	}
	public void setSubmerchantid(String submerchantid) {
		this.submerchantid = submerchantid;
	}

	public Integer getActive_cnt() {
		return active_cnt;
	}
	public void setActive_cnt(Integer active_cnt) {
		this.active_cnt = active_cnt;
	}

	public Integer getActive_user() {
		return active_user;
	}
	public void setActive_user(Integer active_user) {
		this.active_user = active_user;
	}

	public Integer getTotal_user() {
		return total_user;
	}
	public void setTotal_user(Integer total_user) {
		this.total_user = total_user;
	}

	public Integer getNew_user() {
		return new_user;
	}
	public void setNew_user(Integer new_user) {
		this.new_user = new_user;
	}

	public Integer getPayOriginalFee() {
		return payOriginalFee;
	}
	public void setPayOriginalFee(Integer payOriginalFee) {
		this.payOriginalFee = payOriginalFee;
	}

	public Integer getFee() {
		return fee;
	}
	public void setFee(Integer fee) {
		this.fee = fee;
	}
}
