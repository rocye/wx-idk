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
	/** 客服昵称 */
	private String kf_nick;
	/** 客服编号 */
	private String kf_id;
    /** 客服头像 */
    private String kf_headimgurl;
	/** 如果客服帐号已绑定了客服人员微信号，则此处显示微信号 */
	private String kf_wx;
	/** 如果客服帐号尚未绑定微信号，但是已经发起了一个绑定邀请，则此处显示绑定邀请的微信号 */
	private String invite_wx;
	/** 如果客服帐号尚未绑定微信号，但是已经发起过一个绑定邀请，邀请的过期时间，为unix 时间戳 */
	private Long invite_expire_time;
	/** 邀请的状态，有等待确认“waiting”，被拒绝“rejected”，过期“expired” */
	private String invite_status;

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

	public String getKf_wx() {
		return kf_wx;
	}
	public void setKf_wx(String kf_wx) {
		this.kf_wx = kf_wx;
	}

	public String getInvite_wx() {
		return invite_wx;
	}
	public void setInvite_wx(String invite_wx) {
		this.invite_wx = invite_wx;
	}

	public Long getInvite_expire_time() {
		return invite_expire_time;
	}
	public void setInvite_expire_time(Long invite_expire_time) {
		this.invite_expire_time = invite_expire_time;
	}

	public String getInvite_status() {
		return invite_status;
	}
	public void setInvite_status(String invite_status) {
		this.invite_status = invite_status;
	}

}
