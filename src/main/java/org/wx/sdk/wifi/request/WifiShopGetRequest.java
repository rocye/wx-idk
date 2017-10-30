package org.wx.sdk.wifi.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.wifi.response.WifiShopGetRespone;
import org.wx.sdk.wifi.response.WifiShopListRespone;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>查询门店Wi-Fi信息请求对象
 * <p>通过此接口查询某一门店的详细Wi-Fi信息，包括门店内的设备类型、ssid、密码、设备数量、商家主页URL、顶部常驻入口文案。
 * @author Rocye
 * @version 2017.10.30
 */
public class WifiShopGetRequest implements Request<WifiShopGetRespone> {

	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();

    /** 门店ID */
    private Integer shop_id;

    /**
     * 构造器
     */
    public WifiShopGetRequest() {
    }

	/**
	 * 构造器
	 * @param shopId	门店ID
	 */
	public WifiShopGetRequest(Integer shopId) {
		this.shop_id = shopId;
	}

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/bizwifi/shop/get?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<WifiShopGetRespone> getResponseClass(){
        return WifiShopGetRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("shop_id", this.shop_id);
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

}
