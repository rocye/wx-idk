package org.wx.sdk.card.respone;

import org.wx.sdk.base.Response;

import java.util.List;

/**
 * 核查code返回对象
 * @author Rocye
 * @version 2017.12.26
 */
public class CardCodeCheckRespone extends Response {

	/** 已经成功存入的code */
	private List<String> exist_code;
	/** 没有存入的code */
	private List<String> not_exist_code;

	public List<String> getExist_code() {
		return exist_code;
	}
	public void setExist_code(List<String> exist_code) {
		this.exist_code = exist_code;
	}

	public List<String> getNot_exist_code() {
		return not_exist_code;
	}
	public void setNot_exist_code(List<String> not_exist_code) {
		this.not_exist_code = not_exist_code;
	}

}
