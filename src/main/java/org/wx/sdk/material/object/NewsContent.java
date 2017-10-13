package org.wx.sdk.material.object;

import java.io.Serializable;
import java.util.List;

/**
 * 批量返回的图文列表中的一篇图文素材项的内容
 * @author Rocye
 * @version 2016-06-27
 */
public class NewsContent implements Serializable{
    private static final long serialVersionUID = 5842918193497394174L;
    
    /** 图文素材的文章列表 */
    private List<ResNews> news_item;
    /** 图文素材创建时间 */
    private Long create_time;
    /** 图文素材更新时间 */
    private Long update_time;

    public List<ResNews> getNews_item() {
        return news_item;
    }
    public void setNews_item(List<ResNews> newsItem) {
        news_item = newsItem;
    }
    
    public Long getCreate_time() {
        return create_time;
    }
    public void setCreate_time(Long createTime) {
        create_time = createTime;
    }
    
    public Long getUpdate_time() {
        return update_time;
    }
    public void setUpdate_time(Long updateTime) {
        update_time = updateTime;
    }
    
}
