package org.wx.sdk.menu.response;

import org.wx.sdk.base.Response;

/**
 * 个性化菜单创建返回对象
 * @author Rocye
 * @version 2016-08-31
 */
public class ConditionalAddRespone extends Response {

    /** 菜单ID */
    private Long menuid;

    public Long getMenuid() {
        return menuid;
    }
    public void setMenuid(Long menuid) {
        this.menuid = menuid;
    }
    
}
