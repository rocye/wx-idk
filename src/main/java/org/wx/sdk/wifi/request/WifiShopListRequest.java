package org.wx.sdk.wifi.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.poi.object.Business;
import org.wx.sdk.poi.object.Poi;
import org.wx.sdk.poi.response.AddPoiRespone;
import org.wx.sdk.wifi.response.WifiShopListRespone;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>获取Wi-Fi门店列表请求对象
 * <p>通过此接口获取WiFi的门店列表，该列表包括公众平台的门店信息、以及添加设备后的WiFi相关信息。
 * <p>注：微信连Wi-Fi下的所有接口中的shop_id，必需先通过此接口获取。
 * @author Rocye
 * @version 2017.10.16
 */
public class WifiShopListRequest implements Request<WifiShopListRespone> {

	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();

    /** 分页下标，默认从1开始(否) */
    private Integer pageindex;
	/** 每页的个数，默认10个，最大20个(否) */
    private Integer pagesize;

    /**
     * 构造器
     */
    public WifiShopListRequest() {
    }

	/**
	 * 构造器
	 * @param pageindex		分页下标，默认从1开始(否)
	 * @param pagesize		每页的个数，默认10个，最大20个(否)
	 */
	public WifiShopListRequest(Integer pageindex, Integer pagesize) {
		this.pageindex = pageindex;
		this.pagesize = pagesize;
	}

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/bizwifi/shop/list?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<WifiShopListRespone> getResponseClass(){
        return WifiShopListRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        if(this.pageindex != null){
			wxHashMap.put("pageindex", this.pageindex);
		}
		if(this.pagesize != null){
			wxHashMap.put("pagesize", this.pagesize);
		}
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

	public Integer getPageindex() {
		return pageindex;
	}
	public void setPageindex(Integer pageindex) {
		this.pageindex = pageindex;
	}

	public Integer getPagesize() {
		return pagesize;
	}
	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}

}
