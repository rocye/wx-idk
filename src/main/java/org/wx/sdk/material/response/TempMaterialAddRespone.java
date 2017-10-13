package org.wx.sdk.material.response;

import org.wx.sdk.base.Response;

/**
 * 新增临时素材返回对象
 * @author Rocye
 * @version 2016-04-08
 */
public class TempMaterialAddRespone extends Response {
    private static final long serialVersionUID = 1684953325284854386L;
    
    /** 媒体文件类型，分别有图片image、语音voice、视频video和缩略图thumb，主要用于视频与音乐格式的缩略图 */
    private String type;
    /** 媒体文件上传后，获取时的唯一标识 */
    private String media_id;
    /** 缩略图唯一标识 */
    private String thumb_media_id;
    /** 媒体文件上传时间戳 */
    private Long created_at;
    
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    
    public String getMedia_id() {
        return media_id;
    }
    public void setMedia_id(String mediaId) {
        media_id = mediaId;
    }
    
    public Long getCreated_at() {
        return created_at;
    }
    public void setCreated_at(Long createdAt) {
        created_at = createdAt;
    }
    
    public String getThumb_media_id() {
        return thumb_media_id;
    }
    public void setThumb_media_id(String thumbMediaId) {
        thumb_media_id = thumbMediaId;
    }
    
}
