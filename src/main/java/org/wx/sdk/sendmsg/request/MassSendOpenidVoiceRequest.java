package org.wx.sdk.sendmsg.request;

import java.util.List;
import java.util.Map;
import org.wx.sdk.sendmsg.object.VoiceMsg;

/**
 * 根据分组进行群发语音消息请求对象
 * @author Rocye
 * @version 2016-09-29
 */
public class MassSendOpenidVoiceRequest extends MassSendOpenidRequest {
	/** 语音消息对象 */
    private VoiceMsg voice;
    
    /**
     * 构造器
     * @param touser    填写图文消息的接收者，一串OpenID列表，OpenID最少2个，最多10000个
     * @param mediaId   发送的语音消息的媒体ID
     */
    public MassSendOpenidVoiceRequest(List<String> touser, String mediaId) {
        super(touser, "voice");
        this.voice = new VoiceMsg(mediaId);
    }
    
    @Override
    public Map<String, Object> getWxHashMap() {
        Map<String, Object> wxHashMap = super.getWxHashMap();
        wxHashMap.put("voice", voice);
        return wxHashMap;
    }

}
