package org.wx.sdk.material.object;

/**
 * 永久图文素材返回数据对象
 * @author Rocye
 * @version 2016-04-12
 */
public class ResNews extends News{
    /** 图文消息的封面图片的地址，第三方开发者也可以使用这个URL下载图片到自己服务器中，然后显示在自己网站上 */
    private String thumb_url;
    /** 图文页的URL */
    private String url;
    
    public String getThumb_url() {
        return thumb_url;
    }
    public void setThumb_url(String thumbUrl) {
        thumb_url = thumbUrl;
    }
    
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    
}
