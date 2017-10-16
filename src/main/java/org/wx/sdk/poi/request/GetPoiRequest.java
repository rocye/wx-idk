package org.wx.sdk.poi.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.poi.object.Business;
import org.wx.sdk.poi.object.Poi;
import org.wx.sdk.poi.response.AddPoiRespone;
import org.wx.sdk.poi.response.GetPoiRespone;

import java.util.HashMap;
import java.util.Map;

/**
 * 查询门店信息请求对象
 * @author Rocye
 * @version 2017.10.16
 */
public class GetPoiRequest implements Request<GetPoiRespone> {

	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
    /** 门店ID */
    private String poi_id;

    /**
     * 构造器
     * @param poiId 门店ID
     */
    public GetPoiRequest(String poiId) {
        this.poi_id = poiId;
    }

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "http://api.weixin.qq.com/cgi-bin/poi/getpoi?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<GetPoiRespone> getResponseClass(){
        return GetPoiRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("poi_id", this.poi_id);
        wxHashMap.put("buffer", paramMap);
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

    public String getPoi_id() {
        return poi_id;
    }
    public void setPoi_id(String poi_id) {
        this.poi_id = poi_id;
    }

}
