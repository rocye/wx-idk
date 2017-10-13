package org.wx.sdk.menu.object;

import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * 公众平台自定义个性化菜单实体类
 * @author Rocye
 * @version 2016-08-16
 */
public class WXConditionalMenu extends WXMenu {
    private static final long serialVersionUID = -2893761449335950272L;
    
    /** 菜单匹配规则 */
    private WXMatchrule matchrule;
    
    /**
     * 构造函数
     */
    public WXConditionalMenu() {
    }

    /**
     * 构造函数
     * @param button	菜单列表
     * @param matchrule	匹配规则
     */
    public WXConditionalMenu(List<WXButton> button, WXMatchrule matchrule) {
        super(button);
        this.matchrule = matchrule;
    }
    
    public WXMatchrule getMatchrule() {
        return matchrule;
    }
    public void setMatchrule(WXMatchrule matchrule) {
        this.matchrule = matchrule;
    }
    
    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
