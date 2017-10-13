package org.wx.sdk.material.response;

import java.util.List;
import org.wx.sdk.base.Response;
import org.wx.sdk.material.object.NewsItem;

/**
 * 获取批量永久图文素材列表返回对象
 * @author Rocye
 * @version 2016-06-27
 */
public class NewsBatGetRespone extends Response {
    private static final long serialVersionUID = 8036558928328371711L;
    
    /** 本次调用获取的素材的数量 */
    private Integer total_count;
    /** 本次调用获取的素材的数量 */
    private Integer item_count;
    /** 图文素材列表 */
    private List<NewsItem> item;
    
    public Integer getTotal_count() {
        return total_count;
    }
    public void setTotal_count(Integer totalCount) {
        total_count = totalCount;
    }

    public Integer getItem_count() {
        return item_count;
    }
    public void setItem_count(Integer itemCount) {
        item_count = itemCount;
    }

    public List<NewsItem> getItem() {
        return item;
    }
    public void setItem(List<NewsItem> item) {
        this.item = item;
    }
        
}
