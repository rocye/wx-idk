package org.wx.sdk.material.response;

import org.wx.sdk.base.Response;

/**
 * 新增永久图文返回对象
 * @author Rocye
 * @version 2016-04-12
 */
public class NewsAddRespone extends Response {
    private static final long serialVersionUID = -3336647331605122090L;
    /**
     * 新增的永久图文的media_id
     */
    private String media_id;

    public String getMedia_id() {
        return media_id;
    }
    public void setMedia_id(String mediaId) {
        media_id = mediaId;
    }
    
}
