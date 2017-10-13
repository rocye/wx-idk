package org.wx.sdk.material.request;

import java.util.HashMap;
import java.util.Map;
import org.wx.sdk.base.Request;
import org.wx.sdk.material.response.TempVideoAddRespone;

/**
 * <p>新增临时素材的视频第二次上传请求对象
 * <p>主要用于高级群发接口中的视频素材群发
 * @author Rocye
 * @version 2016-09-23
 */
public class TempVideoAddRequest implements Request<TempVideoAddRespone> {
    
	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
    /**
     * 临时视频素材第一次上传所得
     */
    private String media_id;
    /**
     * 视频素材标题
     */
    private String title;
    /**
     * 视频素材描述
     */
    private String description;
    
    /**
     * 构造器
     * @param media_id      临时视频素材第一次上传所得
     * @param title         视频素材标题
     * @param description   视频素材描述
     */
    public TempVideoAddRequest(String media_id, String title, String description) {
        this.media_id = media_id;
        this.title = title;
        this.description = description;
    }

    /**
     * 获取接口请求地址(这里用https有问题)
     */
    public String getApiUrl(){
        String url = "http://file.api.weixin.qq.com/cgi-bin/media/uploadvideo?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<TempVideoAddRespone> getResponseClass(){
        return TempVideoAddRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        wxHashMap.put("media_id", this.media_id);
        wxHashMap.put("title", this.title);
        wxHashMap.put("description", this.description);
        return wxHashMap;
    }
    
    /**
     * 获取请求是否是Https(这里用https有问题)
     */
    public boolean getUseHttps(){
        return false;
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

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
}
