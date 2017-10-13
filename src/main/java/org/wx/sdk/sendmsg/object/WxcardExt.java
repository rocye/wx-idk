package org.wx.sdk.sendmsg.object;

/**
 * 高级接口发送卡券消息实体内部类
 * @author Rocye
 * @version 2016-09-23
 */
public class WxcardExt{
	/** 发送的卡券ID */
    private String card_id;
    /** 卡券扩展信息 */
    private CardExt card_ext;
    
    /**
     * 预览群发卡券实体构造方法
     * @param cardId	发送的卡券ID
     * @param cardExt	卡券扩展信息
     */
    public WxcardExt(String cardId, CardExt cardExt) {
        this.card_id = cardId;
        this.card_ext = cardExt;
    }

    public String getCard_id() {
        return card_id;
    }
    public void setCard_id(String cardId) {
        card_id = cardId;
    }

    public CardExt getCard_ext() {
        return card_ext;
    }
    public void setCard_ext(CardExt cardExt) {
        card_ext = cardExt;
    }
    
}
