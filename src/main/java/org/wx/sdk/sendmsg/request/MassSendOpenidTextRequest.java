package org.wx.sdk.sendmsg.request;

import java.util.List;
import java.util.Map;
import org.wx.sdk.sendmsg.object.TextMsg;

/**
 * 根据分组进行群发文本消息请求对象
 * @author Rocye
 * @version 2016-09-29
 */
public class MassSendOpenidTextRequest extends MassSendOpenidRequest {
	/** 文本消息对象 */
    private TextMsg text;
    
    /**
     * 构造器
     * @param touser    填写图文消息的接收者，一串OpenID列表，OpenID最少2个，最多10000个
     * @param content   群发文本
     */
    public MassSendOpenidTextRequest(List<String> touser, String content) {
        super(touser, "text");
        this.text = new TextMsg(content);
    }
    
    @Override
    public Map<String, Object> getWxHashMap() {
        Map<String, Object> wxHashMap = super.getWxHashMap();
        wxHashMap.put("text", text);
        return wxHashMap;
    }

}
