package org.wx.sdk.wifi.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.wifi.response.WifiDeviceListRespone;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>查询设备请求对象
 * <p>可通过指定分页或具体门店ID的方式，查询当前MP账号下指定门店连网成功的设备信息。
 * 一次最多能查询20个门店的设备信息。
 * @author Rocye
 * @version 2017.11.01
 */
public class WifiDeviceListRequest implements Request<WifiDeviceListRespone> {

	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();

    /** 分页下标，默认从1开始(否) */
    private Integer pageindex;
	/** 每页的个数，默认10个，最大20个(否) */
    private Integer pagesize;
	/** 根据门店id查询(否) */
    private Integer shop_id;

    /**
     * 构造器
     */
    public WifiDeviceListRequest() {
    }

	/**
	 * 构造器
	 * @param pageindex		分页下标，默认从1开始(否)
	 * @param pagesize		每页的个数，默认10个，最大20个(否)
	 */
	public WifiDeviceListRequest(Integer pageindex, Integer pagesize) {
		this.pageindex = pageindex;
		this.pagesize = pagesize;
	}

	/**
	 * 构造器
	 * @param pageindex		分页下标，默认从1开始(否)
	 * @param pagesize		每页的个数，默认10个，最大20个(否)
	 * @param shopId		根据门店id查询(否)
	 */
	public WifiDeviceListRequest(Integer pageindex, Integer pagesize, Integer shopId) {
		this.pageindex = pageindex;
		this.pagesize = pagesize;
		this.shop_id = shopId;
	}

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/bizwifi/device/list?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<WifiDeviceListRespone> getResponseClass(){
        return WifiDeviceListRespone.class;
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
        if(this.shop_id != null){
			wxHashMap.put("shop_id", this.shop_id);
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

	public Integer getShop_id() {
		return shop_id;
	}
	public void setShop_id(Integer shop_id) {
		this.shop_id = shop_id;
	}

}
