package org.wx.sdk.sendmsg.request;

import java.util.Map;

import org.wx.sdk.sendmsg.object.MpnewsMsg;

/**
 * 发送客服图文（点击跳转到图文消息页面）消息(48小时)请求对象
 * @author Rocye
 * @version 2016-04-05
 */
public class KfSendMpnewsRequest extends KfSendRequest {
	
	/** 图文消息对象 */
    private MpnewsMsg mpnews;
    
    /**
     * 构造器
     * @param touser    接收者openid
     * @param mediaId   发送的图文消息（点击跳转到图文消息页）的媒体ID
     */
    public KfSendMpnewsRequest(String touser, String mediaId) {
        super(touser, "mpnews");
        this.mpnews = new MpnewsMsg(mediaId);
    }
    
    @Override
    public Map<String, Object> getWxHashMap() {
        Map<String, Object> wxHashMap = super.getWxHashMap();
        wxHashMap.put("mpnews", mpnews);
        return wxHashMap;
    }

}
