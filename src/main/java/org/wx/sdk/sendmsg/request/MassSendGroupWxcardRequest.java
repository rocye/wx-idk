package org.wx.sdk.sendmsg.request;

import java.util.Map;
import org.wx.sdk.sendmsg.object.FilterObj;
import org.wx.sdk.sendmsg.object.WxcardMsg;

/**
 * 根据分组进行群发卡券消息请求对象
 * @author Rocye
 * @version 2016-09-23
 */
public class MassSendGroupWxcardRequest extends MassSendGroupRequest {
	/** 卡券消息对象 */
    private WxcardMsg wxcard;
    
    /**
     * 构造器
     * @param isToAll   用于设定是否向全部用户发送，值为true或false，选择true该消息群发给所有用户，选择false可根据group_id发送给指定群组的用户
     * @param cardId   	发送的卡券消息的ID
     */
    public MassSendGroupWxcardRequest(Boolean isToAll, String cardId) {
        this(isToAll, null, cardId);
    }
    
    /**
     * 构造器
     * @param isToAll   用于设定是否向全部用户发送，值为true或false，选择true该消息群发给所有用户，选择false可根据group_id发送给指定群组的用户
     * @param groupId   群发到的分组的group_id，参加用户管理中用户分组接口，若is_to_all值为true，可不填写group_id
     * @param cardId    发送的卡券消息的ID
     */
    public MassSendGroupWxcardRequest(Boolean isToAll, Integer groupId, String cardId) {
        super(new FilterObj(isToAll, groupId), "wxcard");
        this.wxcard = new WxcardMsg(cardId);
    }
    
    @Override
    public Map<String, Object> getWxHashMap() {
        Map<String, Object> wxHashMap = super.getWxHashMap();
        wxHashMap.put("wxcard", wxcard);
        return wxHashMap;
    }

}
