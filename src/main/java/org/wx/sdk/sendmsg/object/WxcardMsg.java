package org.wx.sdk.sendmsg.object;

/**
 * 高级接口发送卡券消息实体内部类
 * @author Rocye
 * @version 2016-09-23
 */
public class WxcardMsg{
	/** 发送的卡券ID */
    private String card_id;
    
    public WxcardMsg(String cardId) {
        this.card_id = cardId;
    }

    public String getCard_id() {
        return card_id;
    }
    public void setCard_id(String cardId) {
        card_id = cardId;
    }
    
}
