package org.wx.sdk.card.respone;

import org.wx.sdk.base.Response;

/**
 * 查询导入code数目返回对象
 * @author Rocye
 * @version 2017.12.26
 */
public class CardCodeGetDepositCountRespone extends Response {

	/** 已经成功存入的code数目 */
	private Integer count;

	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}

}
