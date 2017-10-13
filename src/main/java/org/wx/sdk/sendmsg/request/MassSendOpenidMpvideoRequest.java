package org.wx.sdk.sendmsg.request;

import java.util.List;
import java.util.Map;
import org.wx.sdk.sendmsg.object.MpvideoMsg;

/**
 * 根据分组进行群发视频消息请求对象
 * @author Rocye
 * @version 2016-09-23
 */
public class MassSendOpenidMpvideoRequest extends MassSendOpenidRequest {
	/** 视频消息对象 */
    private MpvideoMsg mpvideo;
    
    /**
     * 构造器
     * @param touser        填写图文消息的接收者，一串OpenID列表，OpenID最少2个，最多10000个
     * @param mediaId       用于群发的图文消息的media_id
     */
    public MassSendOpenidMpvideoRequest(List<String> touser, String mediaId) {
        this(touser, mediaId, null, null);
    }
    
    /**
     * 构造器
     * @param touser        填写图文消息的接收者，一串OpenID列表，OpenID最少2个，最多10000个
     * @param mediaId       用于群发的图文消息的media_id
     * @param title         消息的标题
     */
    public MassSendOpenidMpvideoRequest(List<String> touser, String mediaId, String title) {
        this(touser, mediaId, title, null);
    }
    
    /**
     * 构造器
     * @param touser        填写图文消息的接收者，一串OpenID列表，OpenID最少2个，最多10000个
     * @param mediaId       用于群发的图文消息的media_id
     * @param title         消息的标题
     * @param description   消息的描述
     */
    public MassSendOpenidMpvideoRequest(List<String> touser, String mediaId, String title, String description) {
        super(touser, "mpvideo");
        this.mpvideo = new MpvideoMsg(mediaId, title, description);
    }
    
    @Override
    public Map<String, Object> getWxHashMap() {
        Map<String, Object> wxHashMap = super.getWxHashMap();
        wxHashMap.put("mpvideo", mpvideo);
        return wxHashMap;
    }

}
