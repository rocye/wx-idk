package org.wx.sdk.sendmsg.object;

/**
 * 发送图文消息实体类
 * @author Rocye
 * @version 2016-04-19
 */
public class MpnewsMsg{
	/** 发送的图文消息（点击跳转到图文消息页）的媒体ID */
    private String media_id;
    
    public MpnewsMsg(String media_id) {
        this.media_id = media_id;
    }

    public String getMedia_id() {
        return media_id;
    }
    public void setMedia_id(String mediaId) {
        media_id = mediaId;
    }
}
