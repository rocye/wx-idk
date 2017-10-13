package org.wx.sdk.sendmsg.request;

import java.util.List;
import java.util.Map;
import org.wx.sdk.sendmsg.object.MpnewsMsg;

/**
 * 根据分组进行群发图文素材的请求对象
 * @author Rocye
 * @version 2016-09-29
 */
public class MassSendOpenidMpnewsRequest extends MassSendOpenidRequest {
	/** 图文消息对象 */
    private MpnewsMsg mpnews;
    
    /**
     * 构造器
     * @param touser    填写图文消息的接收者，一串OpenID列表，OpenID最少2个，最多10000个
     * @param mediaId   发送的图文素材的媒体ID
     */
    public MassSendOpenidMpnewsRequest(List<String> touser, String mediaId) {
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
