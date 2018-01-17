package org.wx.sdk.card.object;

/**
 * 会员卡概况数据
 * @author Rocye
 * @version 2018.01.15
 */
public class MemberCardinfo {
	/** 日期信息 */
	private String ref_date;
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
	/** 激活人数 */
	private Integer active_user;
	/** 有效会员总人数 */
	private Integer total_user;
	/** 历史领取会员卡总人数 */
	private Integer total_receive_user;

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

	public Integer getTotal_receive_user() {
		return total_receive_user;
	}
	public void setTotal_receive_user(Integer total_receive_user) {
		this.total_receive_user = total_receive_user;
	}
}
