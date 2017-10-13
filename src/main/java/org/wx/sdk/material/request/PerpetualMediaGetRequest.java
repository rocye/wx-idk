package org.wx.sdk.material.request;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.wx.sdk.base.Request;
import org.wx.sdk.material.response.PerpetualMediaGetRespone;

/**
 * 获取永久图片、缩略图、音频素材请求对象
 * @author Rocye
 * @version 2016-04-08
 */
public class PerpetualMediaGetRequest implements Request<PerpetualMediaGetRespone> {
    
	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
    /**
     * 媒体文件ID
     */
    private String media_id;
    /**
     * 下载路径
     */
    private String filePath;
    /**
     * 下载文件名
     */
    private String fileName;
    
    /**
     * 构造器
     * @param mediaId  		媒体文件ID
     * @param fullDownPath  下载文件路径+文件名
     */
    public PerpetualMediaGetRequest(String mediaId, String fullDownPath) {
        this.media_id = mediaId;
        this.fileName = StringUtils.substringAfterLast(fullDownPath, File.separator);
        this.filePath = StringUtils.substringBeforeLast(fullDownPath, File.separator) + File.separator;
    }

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<PerpetualMediaGetRespone> getResponseClass(){
        return PerpetualMediaGetRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        wxHashMap.put("media_id", this.media_id);
        wxHashMap.put("filePath", this.filePath);
        wxHashMap.put("fileName", this.fileName);
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
        return 4;
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

    public String getFilePath() {
        return filePath;
    }
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
}
