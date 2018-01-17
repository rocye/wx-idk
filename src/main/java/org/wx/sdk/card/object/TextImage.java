package org.wx.sdk.card.object;

/**
 * 图文结构体
 * @author Rocye
 * @version 2017.12.19
 */
public class TextImage {
	/** 图片链接，必须调用上传图片接口上传图片获得链接，并在此填入， 否则报错 */
	private String image_url;
	/** 图文描述 */
	private String text;

	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

}
