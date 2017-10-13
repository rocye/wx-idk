package org.wx.sdk.menu.response;

import org.wx.sdk.base.Response;
import org.wx.sdk.menu.object.WXMenu;

/**
 * 测试个性化菜单匹配结果返回对象
 * @author Rocye
 * @version 2016-09-03
 */
public class ConditionalTrymatchRespone extends Response {
    private static final long serialVersionUID = -726749650368256814L;
    
    /** 匹配上的菜单配置 */
    private WXMenu menu;

    public WXMenu getMenu() {
        return menu;
    }
    public void setMenu(WXMenu menu) {
        this.menu = menu;
    }
    
}
