package org.wx.sdk.wifi.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.wifi.response.WifiBarSetRespone;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>设置微信首页欢迎语请求对象
 * <p>设置微信首页欢迎语，可选择“欢迎光临XXX”或“已连接XXXWiFi”，XXX为公众号名称或门店名称。
 * <p>注：设置微信首页欢迎语的接口，未审核的门店不能设置包含门店名称（bar_type为1、3）的欢迎语内容。
 * @author Rocye
 * @version 2017.11.01
 */
public class WifiBarSetRequest implements Request<WifiBarSetRespone> {

	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();

    /** 门店ID */
    private Integer shop_id;
	/** 微信首页欢迎语的文本内容：
	 *  0--欢迎光临+公众号名称；
	 *  1--欢迎光临+门店名称；
	 *  2--已连接+公众号名称+WiFi；
	 *  3--已连接+门店名称+Wi-Fi。 */
    private Short bar_type;

	/**
	 * 构造器
	 * @param shopId		门店ID
	 * @param barType		微信首页欢迎语的文本内容
	 */
	public WifiBarSetRequest(Integer shopId, Short barType) {
		this.shop_id = shopId;
		this.bar_type = barType;
	}

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/bizwifi/bar/set?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<WifiBarSetRespone> getResponseClass(){
        return WifiBarSetRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
		wxHashMap.put("shop_id", this.shop_id);
		wxHashMap.put("bar_type", this.bar_type);
        return wxHashMap;
    }
    
    /**
     * 请求类型：1-普通Get 2-下载GET 3-普通POST 4-下载POST 5-无参上传   6-有参上传
     */
    public int getReqType(){
        return 3;
    }
    
    /**
     * 请求参数格式(kv,json,xml)
     */
    public String getParamFormat(){
        return "json";
    }
    
    /**
     * 设置AccessToken
     */
    public void setAccessToken(String accessToken){
        this.accessToken = accessToken;
    }

	public Integer getShop_id() {
		return shop_id;
	}
	public void setShop_id(Integer shop_id) {
		this.shop_id = shop_id;
	}

	public Short getBar_type() {
		return bar_type;
	}
	public void setBar_type(Short bar_type) {
		this.bar_type = bar_type;
	}

}
