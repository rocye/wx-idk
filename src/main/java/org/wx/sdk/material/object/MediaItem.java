package org.wx.sdk.material.object;

import java.io.Serializable;

/**
 * 批量返回的其它素材（图片、语音、视频）列表中的一个素材项
 * @author Rocye
 * @version 2016-06-27
 */
public class MediaItem {
    /** 素材ID */
    private String media_id;
    /** 素材名称 */
    private String name;
    /** 素材最后更新时间 */
    private Long update_time;
    /** 素材链接 */
    private String url;
    
    public String getMedia_id() {
        return media_id;
    }
    public void setMedia_id(String mediaId) {
        media_id = mediaId;
    }
    
    public Long getUpdate_time() {
        return update_time;
    }
    public void setUpdate_time(Long updateTime) {
        update_time = updateTime;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

}
