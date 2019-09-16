package org.wx.sdk.material.request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.wx.sdk.base.Request;
import org.wx.sdk.material.object.News;
import org.wx.sdk.material.response.NewsUploadRespone;

/**
 * 高级群发接口中的上传图文消息素材请求对象
 * @author Rocye
 * @version 2016-09-20
 */
public class NewsUploadRequest implements Request<NewsUploadRespone> {
    
	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
    /**
     * 图文列表,最多8个
     */
    private List<News> articles;
    
    /**
     * 构造器
     * @param articles  图文列表
     */
    public NewsUploadRequest(List<News> articles) {
        this.articles = articles;
    }

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<NewsUploadRespone> getResponseClass(){
        return NewsUploadRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        wxHashMap.put("articles", this.articles);
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

    public List<News> getArticles() {
        return articles;
    }
    public void setArticles(List<News> articles) {
        this.articles = articles;
    }
    
}
