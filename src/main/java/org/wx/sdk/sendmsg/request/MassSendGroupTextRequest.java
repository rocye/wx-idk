package org.wx.sdk.sendmsg.request;

import java.util.Map;

import org.wx.sdk.sendmsg.object.FilterObj;
import org.wx.sdk.sendmsg.object.TextMsg;

/**
 * 根据分组进行群发文本消息请求对象
 * @author Rocye
 * @version 2016-09-21
 */
public class MassSendGroupTextRequest extends MassSendGroupRequest {
	/** 文本消息对象 */
    private TextMsg text;
    
    /**
     * 构造器
     * @param isToAll   用于设定是否向全部用户发送，值为true或false，选择true该消息群发给所有用户，选择false可根据group_id发送给指定群组的用户
     * @param content   群发文本
     */
    public MassSendGroupTextRequest(Boolean isToAll, String content) {
        this(isToAll, null, content);
    }
    
    /**
     * 构造器
     * @param isToAll   用于设定是否向全部用户发送，值为true或false，选择true该消息群发给所有用户，选择false可根据group_id发送给指定群组的用户
     * @param groupId   群发到的分组的group_id，参加用户管理中用户分组接口，若is_to_all值为true，可不填写group_id
     * @param content   群发文本
     */
    public MassSendGroupTextRequest(Boolean isToAll, Integer groupId, String content) {
        super(new FilterObj(isToAll, groupId), "text");
        this.text = new TextMsg(content);
    }
    
    @Override
    public Map<String, Object> getWxHashMap() {
        Map<String, Object> wxHashMap = super.getWxHashMap();
        wxHashMap.put("text", text);
        return wxHashMap;
    }

}
