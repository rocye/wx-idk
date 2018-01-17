package org.wx.sdk.card.respone;

import org.wx.sdk.base.Response;

/**
 *  导入code返回对象
 * @author Rocye
 * @version 2017.12.26
 */
public class CardCodeDepositRespone extends Response {

	/** 成功个数 */
	private Integer succ_code;
	/** 重复导入的code会自动被过滤 */
	private Integer duplicate_code;
	/** 失败个数 */
	private Integer fail_code;

	public Integer getSucc_code() {
		return succ_code;
	}
	public void setSucc_code(Integer succ_code) {
		this.succ_code = succ_code;
	}

	public Integer getDuplicate_code() {
		return duplicate_code;
	}
	public void setDuplicate_code(Integer duplicate_code) {
		this.duplicate_code = duplicate_code;
	}

	public Integer getFail_code() {
		return fail_code;
	}
	public void setFail_code(Integer fail_code) {
		this.fail_code = fail_code;
	}

}
