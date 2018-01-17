package org.wx.sdk.sendmsg.request;

import org.wx.sdk.sendmsg.object.WxcardMsg;
import java.util.Map;

/**
 * 发送卡券消息(48小时)请求对象
 * @author Rocye
 * @version 2017.12.28
 */
public class KfSendWxcardRequest extends KfSendRequest {

	/** 图文消息对象 */
    private WxcardMsg wxcard;

    /**
     * 构造器
     * @param touser    接收者openid
     * @param cardId    卡券ID
     */
    public KfSendWxcardRequest(String touser, String cardId) {
        super(touser, "wxcard");
        this.wxcard = new WxcardMsg(cardId);
    }
    
    @Override
    public Map<String, Object> getWxHashMap() {
        Map<String, Object> wxHashMap = super.getWxHashMap();
        wxHashMap.put("wxcard", wxcard);
        return wxHashMap;
    }

}
