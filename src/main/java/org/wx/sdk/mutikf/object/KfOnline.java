package org.wx.sdk.mutikf.object;

import java.io.Serializable;

/**
 * 在线客服接待信息
 * @author Rocye
 * @version 2016-08-09
 */
public class KfOnline implements Serializable{
    private static final long serialVersionUID = 7259394406144746841L;
    
    /** 完整客服账号，格式为：账号前缀@公众号微信号 */
    private String kf_account;
    /** 客服在线状态 1：pc在线，2：手机在线。若pc和手机同时在线则为 1+2=3 */
    private Integer status;
    /** 客服工号 */
    private String kf_id;
    /** 客服设置的最大自动接入数 */
    private Integer auto_accept;
    /** 客服当前正在接待的会话数 */
    private Integer accepted_case;
    
    /**
     * 构造函数
     */
    public KfOnline() {
    }
    
    /**
     * 构造函数
     * @param kfAccount     完整客服账号，格式为：账号前缀@公众号微信号
     * @param status        客服在线状态 1：pc在线，2：手机在线。若pc和手机同时在线则为 1+2=3
     * @param kfId          客服工号
     * @param autoAccept    客服设置的最大自动接入数
     * @param acceptedCase  客服当前正在接待的会话数
     */
    public KfOnline(String kfAccount, Integer status, String kfId, Integer autoAccept, Integer acceptedCase) {
        this.kf_account = kfAccount;
        this.status = status;
        this.kf_id = kfId;
        this.auto_accept = autoAccept;
        this.accepted_case = acceptedCase;
    }

    public String getKf_account() {
        return kf_account;
    }
    public void setKf_account(String kfAccount) {
        kf_account = kfAccount;
    }

    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getKf_id() {
        return kf_id;
    }
    public void setKf_id(String kfId) {
        kf_id = kfId;
    }

    public Integer getAuto_accept() {
        return auto_accept;
    }
    public void setAuto_accept(Integer autoAccept) {
        auto_accept = autoAccept;
    }

    public Integer getAccepted_case() {
        return accepted_case;
    }
    public void setAccepted_case(Integer acceptedCase) {
        accepted_case = acceptedCase;
    }
    
}
