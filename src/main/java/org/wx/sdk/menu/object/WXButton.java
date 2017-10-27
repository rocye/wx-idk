package org.wx.sdk.menu.object;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * 公众平台自定义菜单中按钮的实体类
 * 1、自定义菜单最多包括3个一级菜单，每个一级菜单最多包含5个二级菜单。
 * 2、一级菜单最多4个汉字，二级菜单最多7个汉字，多出来的部分将会以“...”代替。
 * 3、创建自定义菜单后，菜单的刷新策略是，在用户进入公众号会话页或公众号profile页时，
 * 如果发现上一次拉取菜单的请求在5分钟以前，就会拉取一下菜单，如果菜单有更新，就会刷新客户端的菜单。
 * 测试时可以尝试取消关注公众账号后再次关注，则可以看到创建后的效果。
 * @author Rocye
 * @version 2016-08-16
 */
public class WXButton {
    /** (不能为空)菜单的响应动作类型 */
	private String type;
	/** (不能为空)菜单标题，不超过16个字节，子菜单不超过40个字节 */
	private String name;
	/** (click等点击类型必须)菜单KEY值，用于消息接口推送，不超过128字节 */
	private String key;
	/** (view类型必须)网页链接，用户点击菜单可打开链接，不超过1024字节 */
	private String url;
	/** 下发消息（除文本消息），永久素材类型可以是图片、音频、视频、图文消息  */
	private String media_id;
	/** (可以为空)二级菜单数组，个数应为1~5个 */
	private List<WXButton> sub_button;
	
	public WXButton() {
    }
	
	/**
	 * 构造器
	 * @param type     菜单的响应动作类型(1、click：点击推事件  2、view：跳转URL  3、scancode_push：扫码推事件
	 *                 4、scancode_waitmsg：扫码推事件且弹出“消息接收中”提示框    5、pic_sysphoto：弹出系统拍照发图
	 *                 6、pic_photo_or_album：弹出拍照或者相册发图    7、pic_weixin：弹出微信相册发图器 
	 *                 8、location_select：弹出地理位置选择器)
	 * @param name     菜单标题，不超过16个字节，子菜单不超过40个字节
	 * @param mediaId  下发消息（除文本消息）用户点击media_id类型按钮后，微信服务器会将开发者填写的永久素材id对应的素材下发给用户，
	 * 				          永久素材类型可以是图片、音频、视频、图文消息。请注意：永久素材id必须是在“素材管理/新增永久素材”接口上传后获得的合法id。
	 * @return 按钮对象{@link WXButton}
	 */
	public static WXButton getInstance(String type, String name, String mediaId) {
		WXButton button = new WXButton(type, name);
		button.setMedia_id(mediaId);
		return button;
    }
	
	/**
	 * 构造器
	 * @param type     菜单的响应动作类型(1、click：点击推事件  2、view：跳转URL  3、scancode_push：扫码推事件
	 *                 4、scancode_waitmsg：扫码推事件且弹出“消息接收中”提示框    5、pic_sysphoto：弹出系统拍照发图
	 *                 6、pic_photo_or_album：弹出拍照或者相册发图    7、pic_weixin：弹出微信相册发图器 
	 *                 8、location_select：弹出地理位置选择器)
	 * @param name     菜单标题，不超过16个字节，子菜单不超过40个字节
	 */
    public WXButton(String type, String name) {
		this.type = type;
		this.name = name;
	}

	/**
	 * 构造器
	 * @param type     菜单的响应动作类型(1、click：点击推事件  2、view：跳转URL  3、scancode_push：扫码推事件
	 *                 4、scancode_waitmsg：扫码推事件且弹出“消息接收中”提示框    5、pic_sysphoto：弹出系统拍照发图
	 *                 6、pic_photo_or_album：弹出拍照或者相册发图    7、pic_weixin：弹出微信相册发图器 
	 *                 8、location_select：弹出地理位置选择器)
	 * @param name     菜单标题，不超过16个字节，子菜单不超过40个字节
	 * @param key      菜单KEY值，用于消息接口推送，不超过128字节
	 */
    public WXButton(String type, String name, String key) {
		this.type = type;
		this.name = name;
		this.key = key;
	}
	
    /**
     * 构造器
     * @param type     菜单的响应动作类型(1、click：点击推事件  2、view：跳转URL  3、scancode_push：扫码推事件
     *                 4、scancode_waitmsg：扫码推事件且弹出“消息接收中”提示框    5、pic_sysphoto：弹出系统拍照发图
     *                 6、pic_photo_or_album：弹出拍照或者相册发图    7、pic_weixin：弹出微信相册发图器 
     *                 8、location_select：弹出地理位置选择器)
     * @param name     菜单标题，不超过16个字节，子菜单不超过40个字节
     * @param url      网页链接，用户点击菜单可打开链接，不超过1024字节
     * @param key      菜单KEY值，用于消息接口推送，不超过128字节
     */
	public WXButton(String type, String name, String url, String key) {
		this.type = type;
		this.name = name;
		this.url = url;
		this.key = key;
	}
	
	/**
     * 构造器
	 * @param name       菜单标题，不超过16个字节，子菜单不超过40个字节
	 * @param subButton  二级菜单数组，个数应为1~5个
	 */
	public WXButton(String name, List<WXButton> subButton) {
        this.name = name;
		this.sub_button = subButton;
	}

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

    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public List<WXButton> getSub_button() {
        return sub_button;
    }
    public void setSub_button(List<WXButton> subButton) {
        sub_button = subButton;
    }
    
    public String getMedia_id() {
		return media_id;
	}
	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}

	@Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
