package org.wx.sdk.card.respone;

import org.wx.sdk.base.Response;

/**
 * 上传卡券图片素材返回对象
 * @author Rocye
 * @version 2017.12.19
 */
public class CardImgUploadRespone extends Response {

    /** 商户图片url，用于创建卡券接口中填入 */
    private String url;

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
