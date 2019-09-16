package org.wx.sdk.poi.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.poi.object.PoiPara;
import org.wx.sdk.poi.response.UpdatePoiRespone;
import java.util.HashMap;
import java.util.Map;

/**
 * 修改门店服务信息请求对象
 * @author Rocye
 * @version 2017.10.16
 */
public class UpdatePoiRequest implements Request<UpdatePoiRespone> {

	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
    /** 门店更新数据 */
    private PoiPara poi;

    /**
     * 构造器
     * @param poi  门店数据
     */
    public UpdatePoiRequest(PoiPara poi) {
        this.poi = poi;
    }

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/cgi-bin/poi/updatepoi?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<UpdatePoiRespone> getResponseClass(){
        return UpdatePoiRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        Map<String, Object> baseMap = new HashMap<String, Object>();
        baseMap.put("base_info", this.poi);
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("business", baseMap);
        wxHashMap.put("buffer", paraMap);
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

    public PoiPara getPoi() {
        return poi;
    }
    public void setPoi(PoiPara poi) {
        this.poi = poi;
    }

}
