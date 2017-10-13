package org.wx.sdk.user.object;

import java.util.List;

/**
 * 获取用户列表Openid列表实体
 * @author Rocye
 * @version 2016-10-27
 */
public class OpenidList {
	/** 用户OpenId列表 */
    private List<String> openid;

    public List<String> getOpenid() {
        return openid;
    }
    public void setOpenid(List<String> openid) {
        this.openid = openid;
    }
    
}
