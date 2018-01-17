package org.wx.sdk.card.respone;

import org.wx.sdk.base.Response;

/**
 * 更改卡券信息返回对象
 * @author Rocye
 * @version 2017.12.29
 */
public class CardUpdateRespone extends Response {

	/** 是否提交审核，false为修改后不会重新提审，true为修改字段后重新提审，该卡券的状态变为审核中。 */
	private Boolean send_check;

	public Boolean getSend_check() {
		return send_check;
	}
	public void setSend_check(Boolean send_check) {
		this.send_check = send_check;
	}

}
