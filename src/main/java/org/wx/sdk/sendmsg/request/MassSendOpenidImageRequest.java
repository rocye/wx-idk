package org.wx.sdk.sendmsg.request;

import java.util.List;
import java.util.Map;
import org.wx.sdk.sendmsg.object.ImageMsg;

/**
 * 根据分组进行群发图片消息请求对象
 * @author Rocye
 * @version 2016-09-29
 */
public class MassSendOpenidImageRequest extends MassSendOpenidRequest {
	/** 图片消息对象 */
    private ImageMsg image;
    
    /**
     * 构造器
     * @param touser    填写图文消息的接收者，一串OpenID列表，OpenID最少2个，最多10000个
     * @param mediaId   发送的图片消息的媒体ID
     */
    public MassSendOpenidImageRequest(List<String> touser, String mediaId) {
        super(touser, "image");
        this.image = new ImageMsg(mediaId);
    }
    
    @Override
    public Map<String, Object> getWxHashMap() {
        Map<String, Object> wxHashMap = super.getWxHashMap();
        wxHashMap.put("image", image);
        return wxHashMap;
    }

}
