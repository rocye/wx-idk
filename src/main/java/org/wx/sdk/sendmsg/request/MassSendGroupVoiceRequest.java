package org.wx.sdk.sendmsg.request;

import java.util.Map;
import org.wx.sdk.sendmsg.object.FilterObj;
import org.wx.sdk.sendmsg.object.VoiceMsg;

/**
 * 根据分组进行群发语音消息请求对象
 * @author Rocye
 * @version 2016-09-23
 */
public class MassSendGroupVoiceRequest extends MassSendGroupRequest {
	/** 语音消息对象 */
    private VoiceMsg voice;
    
    /**
     * 构造器
     * @param isToAll   用于设定是否向全部用户发送，值为true或false，选择true该消息群发给所有用户，选择false可根据group_id发送给指定群组的用户
     * @param mediaId   发送的语音消息的媒体ID
     */
    public MassSendGroupVoiceRequest(Boolean isToAll, String mediaId) {
        this(isToAll, null, mediaId);
    }
    
    /**
     * 构造器
     * @param isToAll   用于设定是否向全部用户发送，值为true或false，选择true该消息群发给所有用户，选择false可根据group_id发送给指定群组的用户
     * @param groupId   群发到的分组的group_id，参加用户管理中用户分组接口，若is_to_all值为true，可不填写group_id
     * @param mediaId   发送的语音消息的媒体ID
     */
    public MassSendGroupVoiceRequest(Boolean isToAll, Integer groupId, String mediaId) {
        super(new FilterObj(isToAll, groupId), "voice");
        this.voice = new VoiceMsg(mediaId);
    }
    
    @Override
    public Map<String, Object> getWxHashMap() {
        Map<String, Object> wxHashMap = super.getWxHashMap();
        wxHashMap.put("voice", voice);
        return wxHashMap;
    }

}
