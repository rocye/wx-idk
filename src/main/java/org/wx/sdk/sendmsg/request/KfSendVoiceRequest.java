package org.wx.sdk.sendmsg.request;

import java.util.Map;
import org.wx.sdk.sendmsg.object.VoiceMsg;

/**
 * 发送客服音频消息(48小时)请求对象
 * @author Rocye
 * @version 2016-04-12
 */
public class KfSendVoiceRequest extends KfSendRequest {
	/** 语音消息对象 */
    private VoiceMsg voice;
    
    /**
     * 构造函数
     * @author Rocye
     * @param touser	接收用户openid
     * @param mediaId	发送的语音的媒体ID
     */
    public KfSendVoiceRequest(String touser, String mediaId) {
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
