package org.wx.sdk.material.response;

import java.util.List;
import org.wx.sdk.base.Response;
import org.wx.sdk.material.object.MediaItem;

/**
 * 获取批量永久图文素材列表返回对象
 * @author Rocye
 * @version 2016-06-27
 */
public class PerpetualMaterialBatGetRespone extends Response {

    /** 该类型的素材的总数 */
    private Integer total_count;
    /** 本次调用获取的素材的数量 */
    private Integer item_count;
    /** 其它素材列表 */
    private List<MediaItem> item;
    
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

    public List<MediaItem> getItem() {
        return item;
    }
    public void setItem(List<MediaItem> item) {
        this.item = item;
    }
        
}
