package org.wx.sdk.user.object;

/**
 * 批量获取用户信息参数实体
 * @author Rocye
 * @version 2016-10-27
 */
public class OpenidObj {
	/** 用户唯一标识 */
    private String openid;
    /** 国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语 */
    private String lang;
    
    /**
     * 构造函数
     */
    public OpenidObj() {
    }
    
    /**
     * 构造函数
     * @param openid	用户唯一标识
     */
    public OpenidObj(String openid) {
        this(openid, null);
    }
    
    /**
     * 构造函数
     * @param openid	用户唯一标识
     * @param lang	国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
     */
    public OpenidObj(String openid, String lang) {
        this.openid = openid;
        this.lang = lang;
    }
    
    public String getOpenid() {
        return openid;
    }
    public void setOpenid(String openid) {
        this.openid = openid;
    }
    
    public String getLang() {
        return lang;
    }
    public void setLang(String lang) {
        this.lang = lang;
    }

}
