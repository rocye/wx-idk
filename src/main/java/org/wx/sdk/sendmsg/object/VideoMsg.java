package org.wx.sdk.sendmsg.object;

/**
 * 发送视频消息实体内部类
 * @author Rocye
 * @version 2016-04-18
 */
public class VideoMsg{
	/** 发送的视频的媒体ID */
    private String media_id;
    /** 视频的缩略图素材ID */
    private String thumb_media_id;
    /** 视频消息的标题 */
    private String title;
    /** 视频消息的描述 */
    private String description;
    
    /**
     * 构造函数
     * @param media_id          发送的视频的媒体ID
     * @param thumb_media_id    发送的视频的缩略图的媒体ID
     */
    public VideoMsg(String media_id, String thumb_media_id) {
        this.media_id = media_id;
        this.thumb_media_id = thumb_media_id;
    }
    
    /**
     * 构造函数
     * @param media_id          发送的视频的媒体ID
     * @param thumb_media_id    发送的视频的缩略图的媒体ID
     * @param title             视频消息的标题
     */
    public VideoMsg(String media_id, String thumb_media_id, String title) {
        this(media_id, thumb_media_id);
        this.title = title;
    }
    
    /**
     * 构造函数
     * @param media_id          发送的视频的媒体ID
     * @param thumb_media_id    发送的视频的缩略图的媒体ID
     * @param title             视频消息的标题
     * @param description       视频消息的描述
     */
    public VideoMsg(String media_id, String thumb_media_id, String title, String description) {
        this(media_id, thumb_media_id, title);
        this.description = description;
    }

    public String getMedia_id() {
        return media_id;
    }
    public void setMedia_id(String mediaId) {
        media_id = mediaId;
    }

    public String getThumb_media_id() {
        return thumb_media_id;
    }
    public void setThumb_media_id(String thumbMediaId) {
        thumb_media_id = thumbMediaId;
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
}
