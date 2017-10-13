package org.wx.sdk.sendmsg.object;

/**
 * 高级接口发送卡券消息实体类
 * @author Rocye
 * @version 2016-09-23
 */
public class CardExt{
	/** 编码 */
    private String code;
    /** 唯一标识 */
    private String openid;
    /** 时间 */
    private Long timestamp;
    /** 签名 */
    private String signature;
    
    /**
     * 卡券扩展类构造方法
     * @param code		编码
     * @param openid	唯一标识
     * @param timestamp	时间
     * @param signature	签名
     */
    public CardExt(String code, String openid, Long timestamp, String signature) {
        this.code = code;
        this.openid = openid;
        this.timestamp = timestamp;
        this.signature = signature;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }


    public String getOpenid() {
        return openid;
    }
    public void setOpenid(String openid) {
        this.openid = openid;
    }


    public Long getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }


    public String getSignature() {
        return signature;
    }
    public void setSignature(String signature) {
        this.signature = signature;
    }
    
}
