package org.wx.sdk.mutikf.object;

import java.io.Serializable;

/**
 * 客服基本信息
 * @author Rocye
 * @version 2016-08-02
 */
public class KfObj implements Serializable{
    private static final long serialVersionUID = -5607979337684854815L;
    
    /** 完整客服账号，格式为：账号前缀@公众号微信号 */
    private String kf_account;
    /** 客服图像 */
    private String kf_headimgurl;
    /** 客服工号 */
    private String kf_id;
    /** 客服昵称 */
    private String kf_nick;
    
    /**
     * 构造函数
     */
    public KfObj() {
    }
    
    /**
     * 构造函数
     * @param kfAccount         完整客服账号，格式为：账号前缀@公众号微信号
     * @param kfHeadimgurl      客服图像
     * @param kfId              客服工号
     * @param kfNick            客服昵称
     */
    public KfObj(String kfAccount, String kfHeadimgurl, String kfId, String kfNick) {
        kf_account = kfAccount;
        kf_headimgurl = kfHeadimgurl;
        kf_id = kfId;
        kf_nick = kfNick;
    }
    
    public String getKf_account() {
        return kf_account;
    }
    public void setKf_account(String kfAccount) {
        kf_account = kfAccount;
    }
    
    public String getKf_headimgurl() {
        return kf_headimgurl;
    }
    public void setKf_headimgurl(String kfHeadimgurl) {
        kf_headimgurl = kfHeadimgurl;
    }
    
    public String getKf_id() {
        return kf_id;
    }
    public void setKf_id(String kfId) {
        kf_id = kfId;
    }
    
    public String getKf_nick() {
        return kf_nick;
    }
    public void setKf_nick(String kfNick) {
        kf_nick = kfNick;
    }
    
}
