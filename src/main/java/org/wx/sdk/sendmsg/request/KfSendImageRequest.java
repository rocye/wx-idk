package org.wx.sdk.sendmsg.request;

import java.util.Map;
import org.wx.sdk.sendmsg.object.ImageMsg;

/**
 * 发送客服图片消息(48小时)请求对象
 * @author Rocye
 * @version 2016-04-05
 */
public class KfSendImageRequest extends KfSendRequest {
	
	/** 图片消息对象 */
    private ImageMsg image;
    
    /**
     * 构造函数
     * @author Rocye
     * @param touser	接收者openid
     * @param mediaId	发送的图片消息的媒体ID
     */
    public KfSendImageRequest(String touser, String mediaId) {
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
