package org.wx.sdk.sendmsg.request;

import java.util.List;
import java.util.Map;
import org.wx.sdk.sendmsg.object.WxcardMsg;

/**
 * 根据分组进行群发卡券消息请求对象
 * @author Rocye
 * @version 2016-09-29
 */
public class MassSendOpenidWxcardRequest extends MassSendOpenidRequest {
	/** 卡券消息对象 */
    private WxcardMsg wxcard;
    
    /**
     * 构造器
     * @param touser    填写图文消息的接收者，一串OpenID列表，OpenID最少2个，最多10000个
     * @param cardId    发送的卡券消息的ID
     */
    public MassSendOpenidWxcardRequest(List<String> touser, String cardId) {
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
