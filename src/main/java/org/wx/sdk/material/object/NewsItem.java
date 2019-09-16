package org.wx.sdk.material.object;

/**
 * 批量返回的图文列表中的一篇图文素材项
 * @author Rocye
 * @version 2016.06.27
 */
public class NewsItem {
    /** 图文素材ID */
    private String media_id;
    /** 图文素材内容 */
    private NewsContent content;
    /** 图文素材最后更新时间 */
    private Long update_time;
    
    public String getMedia_id() {
        return media_id;
    }
    public void setMedia_id(String mediaId) {
        media_id = mediaId;
    }
    
    public NewsContent getContent() {
        return content;
    }
    public void setContent(NewsContent content) {
        this.content = content;
    }
    
    public Long getUpdate_time() {
        return update_time;
    }
    public void setUpdate_time(Long updateTime) {
        update_time = updateTime;
    }

}
