package org.wx.sdk.card.respone;

import org.wx.sdk.base.Response;
import org.wx.sdk.card.object.Cardx;

/**
 * Code解码返回对象
 * @author Rocye
 * @version 2017.12.29
 */
public class CardCodeDecryptRespone extends Response {

	/** 解密后获取的真实Code码 */
	private String code;

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

}
