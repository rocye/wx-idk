package org.wx.sdk.material.request;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.wx.sdk.base.Request;
import org.wx.sdk.material.response.TempMaterialAddRespone;

/**
 * <p>新增临时素材请求对象
 * <p>图片（image）: 2M，支持bmp/png/jpeg/jpg/gif格式
 * <p>语音（voice）：2M，播放长度不超过60s，支持AMR\MP3格式
 * <p>视频（video）：10MB，支持MP4格式
 * <p>缩略图（thumb）：64KB，支持JPG格式
 * <p>媒体文件在后台保存时间为3天，即3天后media_id失效。
 * @author Rocye
 * @version 2016-04-08
 */
public class TempMaterialAddRequest implements Request<TempMaterialAddRespone> {
    
	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
    /**
     * 媒体文件类型，分别有图片image、语音voice、视频video和缩略图thumb
     */
    private String type;
    /**
     * 媒体文件路径
     */
    private String filePath;
    /**
     * 媒体文件名
     */
    private String fileName;
    
    /**
     * 构造器
     * @param type          媒体文件类型，分别有图片image、语音voice、视频video和缩略图thumb
     * @param fullFilePath  媒体文件路径+文件名
     */
    public TempMaterialAddRequest(String type, String fullFilePath) {
        this.type = type;
        this.fileName = StringUtils.substringAfterLast(fullFilePath, File.separator);
        this.filePath = StringUtils.substringBeforeLast(fullFilePath, File.separator) + File.separator;
    }

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token="+ this.accessToken +"&type="+ this.type;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<TempMaterialAddRespone> getResponseClass(){
        return TempMaterialAddRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
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
        return 5;
    }
    
    /**
     * 请求参数格式(kv,json,xml)
     */
    public String getParamFormat(){
        return null;
    }
    
    /**
     * 设置AccessToken
     */
    public void setAccessToken(String accessToken){
        this.accessToken = accessToken;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
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
