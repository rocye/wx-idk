package org.wx.sdk.sendmsg.request;

import java.util.Map;
import org.wx.sdk.sendmsg.object.TextMsg;

/**
 * 发送客服文本消息(48小时)请求对象
 * @author Rocye
 * @version 2016-04-05
 */
public class KfSendTextRequest extends KfSendRequest {
	/** 文本消息 */
    private TextMsg text;
    
    /**
     * 构造函数
     * @param touser	普通用户openid
     * @param content	文本消息内容
     */
    public KfSendTextRequest(String touser, String content) {
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
