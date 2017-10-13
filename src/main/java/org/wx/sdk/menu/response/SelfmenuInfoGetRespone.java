package org.wx.sdk.menu.response;

import org.wx.sdk.base.Response;
import org.wx.sdk.menu.object.EditSelfmenu;

/**
 * <p>获取自定义菜单配置返回对象
 * <p>如果公众号是通过API调用设置的菜单，则返回菜单的开发配置
 * <p>如果公众号是在公众平台官网通过网站功能发布菜单，则本接口返回运营者设置的菜单配置
 * <p>但是无法获取个性化菜单
 * @author Rocye
 * @version 2016-09-03
 */
public class SelfmenuInfoGetRespone extends Response {
    private static final long serialVersionUID = -6949050006471928136L;
    
    /** 菜单是否开启，0代表未开启，1代表开启 */
    private Short is_menu_open;
    /** 菜单信息 */
    private EditSelfmenu selfmenu_info;
    
    public Short getIs_menu_open() {
        return is_menu_open;
    }
    public void setIs_menu_open(Short isMenuOpen) {
        is_menu_open = isMenuOpen;
    }
    
    public EditSelfmenu getSelfmenu_info() {
        return selfmenu_info;
    }
    public void setSelfmenu_info(EditSelfmenu selfmenuInfo) {
        selfmenu_info = selfmenuInfo;
    }
    
}
