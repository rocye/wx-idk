package org.wx.sdk.menu.object;

import java.io.Serializable;
import com.alibaba.fastjson.JSON;

/**
 * 获取编辑模式下自定义菜单中的图文返回对象
 * @author Rocye
 * @version 2016-09-03
 */
public class EditNews {
    /** 标题 */
    private String title;
    /** 作者 */
    private String author;
    /** 摘要 */
    private String digest;
    /** 是否显示封面，0为不显示，1为显示 */
    private Short show_cover;
    /** 封面图片的URL */
    private String cover_url;
    /** 正文的URL */
    private String content_url;
    /** 原文的URL，若置空则无查看原文入口 */
    private String source_url;
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public String getDigest() {
        return digest;
    }
    public void setDigest(String digest) {
        this.digest = digest;
    }

    public Short getShow_cover() {
        return show_cover;
    }
    public void setShow_cover(Short showCover) {
        show_cover = showCover;
    }

    public String getCover_url() {
        return cover_url;
    }
    public void setCover_url(String coverUrl) {
        cover_url = coverUrl;
    }

    public String getContent_url() {
        return content_url;
    }
    public void setContent_url(String contentUrl) {
        content_url = contentUrl;
    }

    public String getSource_url() {
        return source_url;
    }
    public void setSource_url(String sourceUrl) {
        source_url = sourceUrl;
    }
    
    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
    
}
