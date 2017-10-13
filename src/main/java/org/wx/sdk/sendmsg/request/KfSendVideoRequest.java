package org.wx.sdk.sendmsg.request;

import java.util.Map;
import org.wx.sdk.sendmsg.object.VideoMsg;

/**
 * 发送客服视频消息(48小时)请求对象
 * @author Rocye
 * @version 2016-04-18
 */
public class KfSendVideoRequest extends KfSendRequest {
	/** 视频消息对象 */
    private VideoMsg video;
    
    /**
     * 构造器
     * @param touser            接收用户openid
     * @param mediaId           发送的视频的媒体ID
     * @param thumb_media_id    发送的视频的缩略图的媒体ID
     */
    public KfSendVideoRequest(String touser, String mediaId, String thumb_media_id) {
        super(touser, "video");
        this.video = new VideoMsg(mediaId, thumb_media_id);
    }
    
    /**
     * 构造器
     * @param touser            接收用户openid
     * @param mediaId           发送的视频的媒体ID
     * @param thumb_media_id    发送的视频的缩略图的媒体ID
     * @param title             视频消息的标题
     */
    public KfSendVideoRequest(String touser, String mediaId, String thumb_media_id, String title) {
        super(touser, "video");
        this.video = new VideoMsg(mediaId, thumb_media_id, title);
    }
    
    /**
     * 构造器
     * @param touser            接收用户openid
     * @param mediaId           发送的视频的媒体ID
     * @param thumb_media_id    发送的视频的缩略图的媒体ID
     * @param title             视频消息的标题
     * @param description       视频消息的描述
     */
    public KfSendVideoRequest(String touser, String mediaId, String thumb_media_id, String title, String description) {
        super(touser, "video");
        this.video = new VideoMsg(mediaId, thumb_media_id, title, description);
    }
    
    @Override
    public Map<String, Object> getWxHashMap() {
        Map<String, Object> wxHashMap = super.getWxHashMap();
        wxHashMap.put("video", video);
        return wxHashMap;
    }

}
