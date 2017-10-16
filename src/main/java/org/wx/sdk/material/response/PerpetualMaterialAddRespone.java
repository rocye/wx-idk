package org.wx.sdk.material.response;

import org.wx.sdk.base.Response;

/**
 * 新增其他类型永久素材返回对象
 * @author Rocye
 * @version 2016-04-12
 */
public class PerpetualMaterialAddRespone extends Response {

    /** 新增的永久素材的media_id */
    private String media_id;
    /** 新增的图片素材的图片URL（仅新增图片素材时会返回该字段） */
    private String url;
    
    public String getMedia_id() {
        return media_id;
    }
    public void setMedia_id(String mediaId) {
        media_id = mediaId;
    }
    
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    
}
