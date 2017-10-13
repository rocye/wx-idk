package org.wx.sdk.sendmsg.object;

/**
 * 发送消息的素材ID实体类
 * @author Rocye
 * @version 2016-09-30
 */
public class MediaIdObj{
	/** 发送的图片/语音/视频/图文消息（点击跳转到图文消息页）的媒体ID */
    private String media_id;
    
    public MediaIdObj(String media_id) {
        this.media_id = media_id;
    }

    public String getMedia_id() {
        return media_id;
    }
    public void setMedia_id(String mediaId) {
        media_id = mediaId;
    }
    
}
