package org.wx.sdk.wifi.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.wifi.response.WifiShopCleanRespone;
import org.wx.sdk.wifi.response.WifiShopGetRespone;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>清空门店网络及设备请求对象
 * <p>通过此接口清空门店的网络配置及所有设备，恢复空门店状态。
 * @author Rocye
 * @version 2017.10.30
 */
public class WifiShopCleanRequest implements Request<WifiShopCleanRespone> {

	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();

    /** 门店ID */
    private Integer shop_id;

	/** 无线网络设备的ssid */
	private String ssid;

    /**
     * 构造器
     */
    public WifiShopCleanRequest() {
    }

	/**
	 * 构造器
	 * @param shopId	门店ID
	 */
	public WifiShopCleanRequest(Integer shopId) {
		this.shop_id = shopId;
	}

	/**
	 * 构造器
	 * @param shopId	门店ID
	 * @param ssid		无线网络设备的ssid
	 */
	public WifiShopCleanRequest(Integer shopId, String ssid) {
		this.shop_id = shopId;
		this.ssid = ssid;
	}

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/bizwifi/shop/clean?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<WifiShopCleanRespone> getResponseClass(){
        return WifiShopCleanRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("shop_id", this.shop_id);
        paraMap.put("ssid", this.ssid);
        return wxHashMap;
    }
    
    /**
     * 获取请求是否是Https
     */
    public boolean getUseHttps(){
        return true;
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

	public String getSsid() {
		return ssid;
	}
	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

}
