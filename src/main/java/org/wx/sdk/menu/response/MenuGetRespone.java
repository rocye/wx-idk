package org.wx.sdk.menu.response;

import java.util.List;

import org.wx.sdk.base.Response;
import org.wx.sdk.menu.object.WXConditionalMenu;
import org.wx.sdk.menu.object.WXMenu;

/**
 * 自定义菜单查询返回对象
 * @author Rocye
 * @version 2016-08-31
 */
public class MenuGetRespone extends Response {
    private static final long serialVersionUID = 6500231422675694310L;
    
    /** 默认菜单 */
    private WXMenu menu;
    /** 个性化菜单列表 */
    private List<WXConditionalMenu> conditionalmenu;
    
    public WXMenu getMenu() {
        return menu;
    }
    public void setMenu(WXMenu menu) {
        this.menu = menu;
    }
    
    public List<WXConditionalMenu> getConditionalmenu() {
        return conditionalmenu;
    }
    public void setConditionalmenu(List<WXConditionalMenu> conditionalmenu) {
        this.conditionalmenu = conditionalmenu;
    }
    
}
