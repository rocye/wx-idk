package org.wx.sdk.material.response;

import org.wx.sdk.base.Response;

/**
 * 高级群发接口中的上传图文消息素材返回对象
 * @author Rocye
 * @version 2016-09-20
 */
public class NewsUploadRespone extends Response {

    /** 媒体文件类型 */
    private String type;
    /** 图文的media_id */
    private String media_id;
    /** 上传时间 */
    private Long created_at;

    public String getMedia_id() {
        return media_id;
    }
    public void setMedia_id(String mediaId) {
        media_id = mediaId;
    }
    
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    
    public Long getCreated_at() {
        return created_at;
    }
    public void setCreated_at(Long createdAt) {
        created_at = createdAt;
    }
    
}
