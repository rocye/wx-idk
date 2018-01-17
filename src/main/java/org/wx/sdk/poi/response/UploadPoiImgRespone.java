package org.wx.sdk.poi.response;

import org.wx.sdk.base.Response;

/**
 * 上传图片返回对象
 * @author Rocye
 * @version 2017.12.19
 */
public class UploadPoiImgRespone extends Response {

    private String url;

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
