package org.wx.sdk.card.respone;

import org.wx.sdk.base.Response;

/**
 * 图文消息群发卡券返回对象
 * @author Rocye
 * @version 2017.12.26
 */
public class CardMpnewsGetHtmlRespone extends Response {

	/** 返回一段html代码，可以直接嵌入到图文消息的正文里。
	 * 即可以把这段代码嵌入到上传图文消息素材接口中的content字段里。 */
	private String content;

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}
