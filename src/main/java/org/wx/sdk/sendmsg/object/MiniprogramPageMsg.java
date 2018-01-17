package org.wx.sdk.sendmsg.object;

/**
 * 发送小程序卡片（要求小程序与公众号已关联）实体类
 * @author Rocye
 * @version 2017.12.28
 */
public class MiniprogramPageMsg {
	/** 小程序卡片的标题(否) */
	private String title;
	/** 小程序的appid，要求小程序的appid需要与公众号有关联关系 */
	private String appid;
	/** 小程序的页面路径，跟app.json对齐，支持参数，比如pages/index/index?foo=bar */
	private String pagepath;
	/** 缩略图/小程序卡片图片的媒体ID，小程序卡片图片建议大小为520*416 */
	private String thumb_media_id;

	/**
	 * 构造器
	 * @param appid		小程序的appid，要求小程序的appid需要与公众号有关联关系
	 * @param pagepath	小程序的页面路径，跟app.json对齐，支持参数，比如pages/index/index?foo=bar
	 * @param thumbMediaId	缩略图/小程序卡片图片的媒体ID，小程序卡片图片建议大小为520*416
	 */
	public MiniprogramPageMsg(String appid, String pagepath, String thumbMediaId) {
		this(null, appid, pagepath, thumbMediaId);
	}

	/**
	 * 构造器
	 * @param title		小程序卡片的标题(否)
	 * @param appid		小程序的appid，要求小程序的appid需要与公众号有关联关系
	 * @param pagepath	小程序的页面路径，跟app.json对齐，支持参数，比如pages/index/index?foo=bar
	 * @param thumbMediaId	缩略图/小程序卡片图片的媒体ID，小程序卡片图片建议大小为520*416
	 */
	public MiniprogramPageMsg(String title, String appid, String pagepath, String thumbMediaId) {
		this.title = title;
		this.appid = appid;
		this.pagepath = pagepath;
		this.thumb_media_id = thumbMediaId;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getPagepath() {
		return pagepath;
	}
	public void setPagepath(String pagepath) {
		this.pagepath = pagepath;
	}

	public String getThumb_media_id() {
		return thumb_media_id;
	}
	public void setThumb_media_id(String thumb_media_id) {
		this.thumb_media_id = thumb_media_id;
	}
}
