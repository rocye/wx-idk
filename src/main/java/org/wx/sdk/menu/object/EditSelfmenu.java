package org.wx.sdk.menu.object;

import java.util.List;
import com.alibaba.fastjson.JSON;

/**
 * 获取编辑模式或开发模式自定义菜单配置接口返回对象
 * @author Rocye
 * @version 2016-09-03
 */
public class EditSelfmenu {
    /** 菜单列表 */
    protected List<EditButton> button;

    public List<EditButton> getButton() {
        return button;
    }
    public void setButton(List<EditButton> button) {
        this.button = button;
    }
	
    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
