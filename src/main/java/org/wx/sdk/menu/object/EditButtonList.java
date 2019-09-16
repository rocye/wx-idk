package org.wx.sdk.menu.object;

import java.util.List;
import com.alibaba.fastjson.JSON;

/**
 * 获取编辑模式或开发模式自定义菜单配置接口返回子菜单列表对象
 * @author Rocye
 * @version 2016-09-03
 */
public class EditButtonList {
    /** 菜单列表 */
    protected List<EditButton> list;

    public List<EditButton> getList() {
        return list;
    }
    public void setList(List<EditButton> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
    
}
