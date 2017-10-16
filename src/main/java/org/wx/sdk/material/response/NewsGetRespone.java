package org.wx.sdk.material.response;

import java.util.List;

import org.wx.sdk.base.Response;
import org.wx.sdk.material.object.ResNews;

/**
 * 获取永久图文素材返回对象
 * @author Rocye
 * @version 2016-04-12
 */
public class NewsGetRespone extends Response {

    /** 图文列表 */
    private List<ResNews> news_item;

    public List<ResNews> getNews_item() {
        return news_item;
    }
    public void setNews_item(List<ResNews> newsItem) {
        news_item = newsItem;
    }
        
}
