package org.wx.sdk.sendmsg.object;

/**
 * 发送文本消息实体内部类
 * @author Rocye
 * @version 2016-04-05
 */
public class TextMsg{
	/** 文本消息内容 */
    private String content;
    
    public TextMsg(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
