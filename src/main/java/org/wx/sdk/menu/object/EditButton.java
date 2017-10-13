package org.wx.sdk.menu.object;

import java.io.Serializable;
import com.alibaba.fastjson.JSON;

/**
 * 获取开发模式或编辑模式下自定义菜单中按钮的返回对象
 * @author Rocye
 * @version 2016-09-03
 */
public class EditButton implements Serializable {
    private static final long serialVersionUID = 5705923096171253378L;
    
    /** (编辑或开发)菜单的类型，公众平台官网上能够设置的菜单类型有view（跳转网页）、text（返回文本，下同）、img、photo、video、voice。使用API设置的则有8种，详见《自定义菜单创建接口》 */
    private String type;
    /** (编辑或开发)菜单名称 */
	private String name;
	/** (编辑)Text:保存文字到value；Img、voice：保存mediaID到value；Video:保存视频下载链接到value； News:保存图文消息到news_info，同时保存mediaID到value； */
	private String value;
	/** (编辑或开发)View:保存链接到url */
	private String url; 
	/** (开发))菜单KEY值，用于消息接口推送，不超过128字节 */
	private String key;
	/** (编辑)图文消息的信息 */
	private EditNews news_info;
	/** (编辑或开发)二级菜单数组，个数应为1~5个 */
	private EditButtonList sub_button;
	
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }

    public EditButtonList getSub_button() {
        return sub_button;
    }
    public void setSub_button(EditButtonList subButton) {
        sub_button = subButton;
    }
    
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    
    public EditNews getNews_info() {
        return news_info;
    }
    public void setNews_info(EditNews newsInfo) {
        news_info = newsInfo;
    }
    
    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
