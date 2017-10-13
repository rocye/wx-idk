package org.wx.sdk.material.response;

import org.wx.sdk.base.Response;

/**
 * 上传图文消息内的图片获取URL返回对象
 * @author Rocye
 * @version 2016-04-12
 */
public class NewsInnerImgAddRespone extends Response {
    private static final long serialVersionUID = 1140366440595903998L;
    
    /** 上传图片的URL */
    private String url;

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    
}
