package org.wx.sdk.material.response;

import org.wx.sdk.base.Response;

/**
 * 获取永久视频素材返回对象
 * @author Rocye
 * @version 2016-04-12
 */
public class PerpetualVideoGetRespone extends Response {
    private static final long serialVersionUID = -7404165460936886596L;
    
    /** 标题 */
    private String title;
    /** 描述 */
    private String description;
    /** 下载链接 */
    private String down_url;
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getDown_url() {
        return down_url;
    }
    public void setDown_url(String downUrl) {
        down_url = downUrl;
    }
        
}
