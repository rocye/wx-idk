package org.wx.sdk.sendmsg.request;

import java.util.Map;
import org.wx.sdk.sendmsg.object.FilterObj;
import org.wx.sdk.sendmsg.object.WxcardMsg;

/**
 * 根据分组进行群发卡券消息请求对象
 * @author Rocye
 * @version 2017.10.20
 */
public class MassSendTagWxcardRequest extends MassSendTagRequest {
	/** 卡券消息对象 */
    private WxcardMsg wxcard;
    
    /**
     * 构造器
     * @param isToAll   用于设定是否向全部用户发送，值为true或false，选择true该消息群发给所有用户，选择false可根据group_id发送给指定群组的用户
     * @param cardId   	发送的卡券消息的ID
     */
    public MassSendTagWxcardRequest(Boolean isToAll, String cardId) {
        this(isToAll, null, cardId);
    }
    
    /**
     * 构造器
     * @param isToAll   用于设定是否向全部用户发送，值为true或false，选择true该消息群发给所有用户，选择false可根据group_id发送给指定群组的用户
     * @param tagId		群发到的标签的tag_id，参加用户管理中用户分组接口，若is_to_all值为true，可不填写tag_id
     * @param cardId    发送的卡券消息的ID
     */
    public MassSendTagWxcardRequest(Boolean isToAll, Integer tagId, String cardId) {
        super(new FilterObj(isToAll, tagId), "wxcard");
        this.wxcard = new WxcardMsg(cardId);
    }
    
    @Override
    public Map<String, Object> getWxHashMap() {
        Map<String, Object> wxHashMap = super.getWxHashMap();
        wxHashMap.put("wxcard", wxcard);
        return wxHashMap;
    }

}
