package org.wx.sdk.card.object;

/**
 * 免费券数据
 * @author Rocye
 * @version 2018.01.02
 */
public class Cardinfo {
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
	/** 转赠次数 */
	private Integer given_cnt;
	/** 转赠人数 */
	private Integer given_user;
	/** 过期次数 */
	private Integer expire_cnt;
	/** 过期人数 */
	private Integer expire_user;

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

	public Integer getGiven_user() {
		return given_user;
	}
	public void setGiven_user(Integer given_user) {
		this.given_user = given_user;
	}

	public Integer getGiven_cnt() {
		return given_cnt;
	}
	public void setGiven_cnt(Integer given_cnt) {
		this.given_cnt = given_cnt;
	}

	public Integer getExpire_cnt() {
		return expire_cnt;
	}
	public void setExpire_cnt(Integer expire_cnt) {
		this.expire_cnt = expire_cnt;
	}

	public Integer getExpire_user() {
		return expire_user;
	}
	public void setExpire_user(Integer expire_user) {
		this.expire_user = expire_user;
	}

}
