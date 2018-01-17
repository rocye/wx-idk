package org.wx.sdk.sendmsg.request;

import org.wx.sdk.sendmsg.object.MiniprogramPageMsg;
import java.util.Map;

/**
 * 发送小程序卡片(48小时)请求对象
 * @author Rocye
 * @version 2017.12.28
 */
public class KfSendMiniprogramPageRequest extends KfSendRequest {

	/** 小程序卡片对象 */
    private MiniprogramPageMsg miniprogrampage;

	/**
	 * 构造器
	 * @param touser    接收者openid
	 * @param appid		小程序的appid，要求小程序的appid需要与公众号有关联关系
	 * @param pagepath	小程序的页面路径，跟app.json对齐，支持参数，比如pages/index/index?foo=bar
	 * @param thumbMediaId	缩略图/小程序卡片图片的媒体ID，小程序卡片图片建议大小为520*416
	 */
	public KfSendMiniprogramPageRequest(String touser, String appid, String pagepath, String thumbMediaId) {
		super(touser, "miniprogrampage");
		this.miniprogrampage = new MiniprogramPageMsg(appid, pagepath, thumbMediaId);
	}

    /**
     * 构造器
     * @param touser    接收者openid
     * @param title		小程序卡片的标题(否)
	 * @param appid		小程序的appid，要求小程序的appid需要与公众号有关联关系
	 * @param pagepath	小程序的页面路径，跟app.json对齐，支持参数，比如pages/index/index?foo=bar
	 * @param thumbMediaId	缩略图/小程序卡片图片的媒体ID，小程序卡片图片建议大小为520*416
     */
    public KfSendMiniprogramPageRequest(String touser, String title, String appid, String pagepath, String thumbMediaId) {
        super(touser, "miniprogrampage");
        this.miniprogrampage = new MiniprogramPageMsg(title, appid, pagepath, thumbMediaId);
    }
    
    @Override
    public Map<String, Object> getWxHashMap() {
        Map<String, Object> wxHashMap = super.getWxHashMap();
        wxHashMap.put("miniprogrampage", this.miniprogrampage);
        return wxHashMap;
    }

}
