package org.wx.sdk.sendmsg.object;

/**
 * 发送音频消息实体内部类
 * @author Rocye
 * @version 2016-04-12
 */
public class VoiceMsg{
	/** 发送的语音的媒体ID */
    private String media_id;
    
    public VoiceMsg(String media_id) {
        this.media_id = media_id;
    }

    public String getMedia_id() {
        return media_id;
    }
    public void setMedia_id(String mediaId) {
        media_id = mediaId;
    }
}
