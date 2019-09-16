package org.wx.sdk.poi.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.poi.response.GetPoiListRespone;
import java.util.HashMap;
import java.util.Map;

/**
 * 查询门店列表请求对象
 * @author Rocye
 * @version 2017.10.16
 */
public class GetPoiListRequest implements Request<GetPoiListRespone> {

	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
    /** 开始位置，0 即为从第一条开始查询 */
    private Integer begin;
    /** 返回数据条数，最大允许50，默认为20 */
    private Integer limit;

    /**
     * 构造器
     * @param begin 开始位置，0 即为从第一条开始查询
     * @param limit 返回数据条数，最大允许50，默认为20
     */
    public GetPoiListRequest(Integer begin, Integer limit) {
        this.begin = begin;
        this.limit = limit;
    }

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/cgi-bin/poi/getpoilist?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<GetPoiListRespone> getResponseClass(){
        return GetPoiListRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("begin", this.begin);
        paramMap.put("limit", this.limit);
        wxHashMap.put("buffer", paramMap);
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

    public Integer getBegin() {
        return begin;
    }
    public void setBegin(Integer begin) {
        this.begin = begin;
    }

    public Integer getLimit() {
        return limit;
    }
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

}
