package org.wx.sdk.sendmsg.request;

import java.util.Map;

import org.wx.sdk.sendmsg.object.FilterObj;
import org.wx.sdk.sendmsg.object.ImageMsg;

/**
 * 根据标签进行群发图片消息请求对象
 * @author Rocye
 * @version 2017.10.20
 */
public class MassSendTagImageRequest extends MassSendTagRequest {
	/** 图片消息对象 */
    private ImageMsg image;
    
    /**
     * 构造器
     * @param isToAll   用于设定是否向全部用户发送，值为true或false，选择true该消息群发给所有用户，选择false可根据group_id发送给指定群组的用户
     * @param mediaId   发送的图片消息的媒体ID
     */
    public MassSendTagImageRequest(Boolean isToAll, String mediaId) {
        this(isToAll, null, mediaId);
    }
    
    /**
     * 构造器
     * @param isToAll   用于设定是否向全部用户发送，值为true或false，选择true该消息群发给所有用户，选择false可根据group_id发送给指定群组的用户
     * @param tagId		群发到的标签的tag_id，参加用户管理中用户分组接口，若is_to_all值为true，可不填写tag_id
     * @param mediaId   发送的图片消息的媒体ID
     */
    public MassSendTagImageRequest(Boolean isToAll, Integer tagId, String mediaId) {
        super(new FilterObj(isToAll, tagId), "image");
        this.image = new ImageMsg(mediaId);
    }
    
    @Override
    public Map<String, Object> getWxHashMap() {
        Map<String, Object> wxHashMap = super.getWxHashMap();
        wxHashMap.put("image", image);
        return wxHashMap;
    }

}
