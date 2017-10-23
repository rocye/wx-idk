package org.wx.sdk.sendmsg.request;

import java.util.Map;
import org.wx.sdk.sendmsg.object.FilterObj;
import org.wx.sdk.sendmsg.object.MpvideoMsg;

/**
 * 根据标签进行群发视频消息请求对象
 * @author Rocye
 * @version 2017.10.20
 */
public class MassSendTagMpvideoRequest extends MassSendTagRequest {
	/** 视频消息对象 */
    private MpvideoMsg mpvideo;
    
    /**
     * 构造器
     * @param isToAll   用于设定是否向全部用户发送，值为true或false，选择true该消息群发给所有用户，选择false可根据group_id发送给指定群组的用户
     * @param mediaId   发送的视频消息的媒体ID
     */
    public MassSendTagMpvideoRequest(Boolean isToAll, String mediaId) {
        this(isToAll, null, mediaId);
    }
    
    /**
     * 构造器
     * @param isToAll   用于设定是否向全部用户发送，值为true或false，选择true该消息群发给所有用户，选择false可根据group_id发送给指定群组的用户
     * @param tagId		群发到的标签的tag_id，参加用户管理中用户分组接口，若is_to_all值为true，可不填写tag_id
     * @param mediaId   发送的视频消息的媒体ID
     */
    public MassSendTagMpvideoRequest(Boolean isToAll, Integer tagId, String mediaId) {
        super(new FilterObj(isToAll, tagId), "mpvideo");
        this.mpvideo = new MpvideoMsg(mediaId);
    }
    
    @Override
    public Map<String, Object> getWxHashMap() {
        Map<String, Object> wxHashMap = super.getWxHashMap();
        wxHashMap.put("mpvideo", mpvideo);
        return wxHashMap;
    }

}
