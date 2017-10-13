package org.wx.sdk.generalize.response;

import org.wx.sdk.base.Response;

/**
 * <p>将一条长链接转成短链接返回对象
 * @author Rocye
 * @version 2016-10-27
 */
public class Long2ShortUrlRespone extends Response {
    private static final long serialVersionUID = -5554680907963811373L;
    
    /** 短链接 */
    private String short_url;

    public String getShort_url() {
        return short_url;
    }
    public void setShort_url(String shortUrl) {
        short_url = shortUrl;
    }
    
}
