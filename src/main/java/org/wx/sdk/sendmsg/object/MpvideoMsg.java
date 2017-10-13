package org.wx.sdk.sendmsg.object;

/**
 * 高级接口发送视频消息实体类
 * @author Rocye
 * @version 2016-09-29
 */
public class MpvideoMsg{
	/** 发送的视频的媒体ID */
    private String media_id;
    /** 视频消息的标题 */
    private String title;
    /** 视频消息的描述 */
    private String description;
    
    /**
     * 构造器
     * @param media_id	素材ID
     */
    public MpvideoMsg(String media_id) {
        this.media_id = media_id;
    }
    
    /**
     * 构造器
     * @param media_id	素材ID
     * @param title     视频消息的标题
     */
    public MpvideoMsg(String media_id, String title) {
        this(media_id);
        this.title = title;
    }
    
    /**
     * 构造器
     * @param media_id		素材ID
     * @param title			视频消息的标题
     * @param description	视频消息的描述
     */
    public MpvideoMsg(String media_id, String title, String description) {
        this(media_id, title);
        this.description = description;
    }
    
    public String getMedia_id() {
        return media_id;
    }
    public void setMedia_id(String mediaId) {
        media_id = mediaId;
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
