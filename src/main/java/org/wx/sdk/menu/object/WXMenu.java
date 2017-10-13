package org.wx.sdk.menu.object;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * 公众平台自定义菜单实体类
 * @author Rocye
 * @version 2016-08-16
 */
public class WXMenu implements Serializable {
    private static final long serialVersionUID = -3671040261996819174L;
    
    /** 菜单列表 */
	protected List<WXButton> button;
	/** 菜单ID */
	protected Long menuid;
	
	public WXMenu() {
    }
	
    public WXMenu(List<WXButton> button) {
        this.button = button;
    }
    
    public List<WXButton> getButton() {
        return button;
    }
    public void setButton(List<WXButton> button) {
        this.button = button;
    }

    public Long getMenuid() {
        return menuid;
    }
    public void setMenuid(Long menuid) {
        this.menuid = menuid;
    }
    
    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
	
}
