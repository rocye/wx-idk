package org.wx.sdk.sendmsg.object;

import java.io.Serializable;

/**
 * 客服（48小时）发送图文（点击跳转到外链）对象
 * @author Rocye
 * @version 2016-04-19
 */
public class News implements Serializable{
    private static final long serialVersionUID = 1014952024084110195L;
    
    /** 图文消息的标题 */
    private String title;
    /** 图文消息的描述 */
    private String description;
    /** 图文消息被点击后跳转的链接 */
    private String url;
    /** 图文消息的图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80 */
    private String picurl;
    
    /**
     * 构造函数
     */
    public News() {
    }
    
    /**
     * 构造函数
     * @param title         图文消息的标题
     * @param description   图文消息的描述
     * @param url           图文消息被点击后跳转的链接
     * @param picurl        图文消息的图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80
     */
    public News(String title, String description, String url, String picurl) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.picurl = picurl;
    }
    
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

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public String getPicurl() {
        return picurl;
    }
    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }
    
}
