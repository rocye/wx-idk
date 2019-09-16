package org.wx.sdk.wifi.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.wifi.response.WifiStatisticsListRespone;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>查询门店Wi-Fi信息请求对象
 * <p>通过此接口查询某一门店的详细Wi-Fi信息，包括门店内的设备类型、ssid、密码、设备数量、商家主页URL、顶部常驻入口文案。
 * @author Rocye
 * @version 2017.10.30
 */
public class WifiStatisticsListRequest implements Request<WifiStatisticsListRespone> {

	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();

    /** 起始日期时间，格式yyyy-mm-dd，最长时间跨度为30天 */
    private String begin_date;
    /** 结束日期时间戳，格式yyyy-mm-dd，最长时间跨度为30天 */
    private String end_date;
	/** 按门店ID搜索，-1为总统计 */
	private Integer shop_id;

	/**
	 * 构造器
	 * @param beginDate		起始日期时间，格式yyyy-mm-dd，最长时间跨度为30天
	 * @param endDate		结束日期时间戳，格式yyyy-mm-dd，最长时间跨度为30天
	 */
	public WifiStatisticsListRequest(String beginDate, String endDate) {
		this.begin_date = beginDate;
		this.end_date = endDate;
	}

	/**
	 * 构造器
	 * @param beginDate		起始日期时间，格式yyyy-mm-dd，最长时间跨度为30天
	 * @param endDate		结束日期时间戳，格式yyyy-mm-dd，最长时间跨度为30天
	 * @param shopId		门店ID
	 */
	public WifiStatisticsListRequest(String beginDate, String endDate, Integer shopId) {
		this.begin_date = beginDate;
		this.end_date = endDate;
		this.shop_id = shopId;
	}

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/bizwifi/statistics/list?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<WifiStatisticsListRespone> getResponseClass(){
        return WifiStatisticsListRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
		wxHashMap.put("begin_date", this.begin_date);
		wxHashMap.put("end_date", this.end_date);
		if(this.shop_id != null){
			wxHashMap.put("shop_id", this.shop_id);
		}
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

	public String getBegin_date() {
		return begin_date;
	}
	public void setBegin_date(String begin_date) {
		this.begin_date = begin_date;
	}

	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

}
