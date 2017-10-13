package org.wx.sdk.material.request;

import java.util.HashMap;
import java.util.Map;
import org.wx.sdk.base.Request;
import org.wx.sdk.material.response.NewsBatGetRespone;

/**
 * 批量获取永久图文素材列表请求对象
 * @author Rocye
 * @version 2016-06-27
 */
public class NewsBatGetRequest implements Request<NewsBatGetRespone> {
    
	/** 微信公众平台唯一凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
    /** 从全部素材的该偏移位置开始返回，0表示从第一个素材 返回 */
    private Integer offset;
    /** 返回素材的数量，取值在1到20之间 */
    private Integer count;
    
    /**
     * 构造器
     * @param offset  从全部素材的该偏移位置开始返回，0表示从第一个素材 返回
     * @param count   返回素材的数量，取值在1到20之间
     */
    public NewsBatGetRequest(Integer offset, Integer count) {
        this.offset = offset;
        this.count = count;
    }

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<NewsBatGetRespone> getResponseClass(){
        return NewsBatGetRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        wxHashMap.put("type", "news");
        wxHashMap.put("offset", this.offset);
        wxHashMap.put("count", this.count);
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

    public Integer getOffset() {
        return offset;
    }
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }

}
