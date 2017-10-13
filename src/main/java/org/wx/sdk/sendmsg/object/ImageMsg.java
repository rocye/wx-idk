package org.wx.sdk.sendmsg.object;

/**
 * 发送图片消息实体类
 * @author Rocye
 * @version 2016-04-05
 */
public class ImageMsg{
	/** 发送的图片的媒体ID */
    private String media_id;
    
    public ImageMsg(String media_id) {
        this.media_id = media_id;
    }

    public String getMedia_id() {
        return media_id;
    }
    public void setMedia_id(String mediaId) {
        media_id = mediaId;
    }
}
