package org.wx.sdk.poi.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.poi.object.Business;
import org.wx.sdk.poi.object.Poi;
import org.wx.sdk.poi.response.AddPoiRespone;
import java.util.HashMap;
import java.util.Map;

/**
 * 创建门店请求对象
 * @author Rocye
 * @version 2017.10.16
 */
public class AddPoiRequest implements Request<AddPoiRespone> {

	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
    /** 门店数据 */
    private Poi poi;

    /**
     * 构造器
     * @param poi  门店数据
     */
    public AddPoiRequest(Poi poi) {
        this.poi = poi;
    }

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "http://api.weixin.qq.com/cgi-bin/poi/addpoi?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<AddPoiRespone> getResponseClass(){
        return AddPoiRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("business", new Business(poi));
        wxHashMap.put("buffer", paraMap);
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

    public Poi getPoi() {
        return poi;
    }
    public void setPoi(Poi poi) {
        this.poi = poi;
    }

}
