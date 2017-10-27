package org.wx.sdk.material.object;

import java.io.Serializable;

/**
 * 永久图文素材请求数据对象
 * @author Rocye
 * @version 2017.10.10
 */
public class News {
    /** 标题 */
    private String title;
    /** 图文消息的封面图片素材id（必须是永久mediaID） */
    private String thumb_media_id;
    /** 作者 */
    private String author;
    /** 图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空 */
    private String digest;
    /** 是否显示封面，0为false，即不显示，1为true，即显示 */
    private Short show_cover_pic;
    /** 图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS */
    private String content;
    /** 图文消息的原文地址，即点击“阅读原文”后的URL */
    private String content_source_url;
    
    /** 是否打开评论（0不打开，1打开） */
    private Short need_open_comment;
    /** 是否粉丝才可评论（0所有人可评论，1粉丝才可评论） */
    private Short only_fans_can_comment;
    
    /**
     * 构造函数
     * @author Rocye
     */
    public News() {
    }
    
    /**
     * 构造函数
     * @param title             标题
     * @param thumbMediaId      图文消息的封面图片素材id（必须是永久mediaID）
     * @param author            作者
     * @param digest            图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空
     * @param showCoverPic      是否显示封面，0为false，即不显示，1为true，即显示
     * @param content           图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS
     * @param contentSourceUrl  图文消息的原文地址，即点击“阅读原文”后的URL
     */
    public News(String title, String thumbMediaId, String author,
            String digest, Short showCoverPic, String content, String contentSourceUrl) {
        this.title = title;
        this.thumb_media_id = thumbMediaId;
        this.author = author;
        this.digest = digest;
        this.show_cover_pic = showCoverPic;
        this.content = content;
        this.content_source_url = contentSourceUrl;
    }
    
    /**
     * 构造函数
     * @author Rocye
     * @param title              标题
     * @param thumbMediaId       图文消息的封面图片素材id（必须是永久mediaID）
     * @param author             作者
     * @param digest             图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空
     * @param showCoverPic       是否显示封面，0为false，即不显示，1为true，即显示
     * @param content            图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS
     * @param contentSourceUrl   图文消息的原文地址，即点击“阅读原文”后的URL
     * @param needOpenComment  	   是否打开评论（0不打开，1打开）
     * @param onlyFansCanComment 是否粉丝才可评论（0所有人可评论，1粉丝才可评论）
     * @version 2017.10.10
     */
    public News(String title, String thumbMediaId, String author,
            String digest, Short showCoverPic, String content, String contentSourceUrl,
            Short needOpenComment, Short onlyFansCanComment) {
        this.title = title;
        this.thumb_media_id = thumbMediaId;
        this.author = author;
        this.digest = digest;
        this.show_cover_pic = showCoverPic;
        this.content = content;
        this.content_source_url = contentSourceUrl;
        this.need_open_comment = needOpenComment;
        this.only_fans_can_comment = onlyFansCanComment;
    }
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getThumb_media_id() {
        return thumb_media_id;
    }
    public void setThumb_media_id(String thumbMediaId) {
        thumb_media_id = thumbMediaId;
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
    
    public Short getShow_cover_pic() {
        return show_cover_pic;
    }
    public void setShow_cover_pic(Short showCoverPic) {
        show_cover_pic = showCoverPic;
    }
    
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    
    public String getContent_source_url() {
        return content_source_url;
    }
    public void setContent_source_url(String contentSourceUrl) {
        content_source_url = contentSourceUrl;
    }

	public Short getNeed_open_comment() {
		return need_open_comment;
	}
	public void setNeed_open_comment(Short need_open_comment) {
		this.need_open_comment = need_open_comment;
	}

	public Short getOnly_fans_can_comment() {
		return only_fans_can_comment;
	}
	public void setOnly_fans_can_comment(Short only_fans_can_comment) {
		this.only_fans_can_comment = only_fans_can_comment;
	}
    
}
