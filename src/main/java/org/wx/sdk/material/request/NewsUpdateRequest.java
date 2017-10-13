package org.wx.sdk.material.request;

import java.util.HashMap;
import java.util.Map;
import org.wx.sdk.base.Request;
import org.wx.sdk.material.object.News;
import org.wx.sdk.material.response.NewsUpdateRespone;

/**
 * 修改永久图文素材请求对象
 * @author Rocye
 * @version 2016-06-25
 */
public class NewsUpdateRequest implements Request<NewsUpdateRespone> {
    
	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
    /**
     * 媒体文件ID
     */
    private String media_id;
    /**
     * 第几篇文章
     */
    private Integer index;
    /**
     * 更新的图文内容
     */
    private News articles;
    
    /**
     * 构造器
     * @param mediaId  素材ID
     * @param index  第几篇文章
     * @param articles  更改的图文
     */
    public NewsUpdateRequest(String mediaId, Integer index, News articles) {
        this.media_id = mediaId;
        this.index = index;
        this.articles = articles;
    }

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/cgi-bin/material/update_news?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<NewsUpdateRespone> getResponseClass(){
        return NewsUpdateRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        wxHashMap.put("media_id", this.media_id);
        wxHashMap.put("index", this.index);
        wxHashMap.put("articles", this.articles);
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

    public String getMedia_id() {
        return media_id;
    }
    public void setMedia_id(String mediaId) {
        media_id = mediaId;
    }

    public Integer getIndex() {
        return index;
    }
    public void setIndex(Integer index) {
        this.index = index;
    }

    public News getArticles() {
        return articles;
    }
    public void setArticles(News articles) {
        this.articles = articles;
    }
    
}
