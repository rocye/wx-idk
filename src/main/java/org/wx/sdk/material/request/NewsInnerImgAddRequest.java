package org.wx.sdk.material.request;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.wx.sdk.base.Request;
import org.wx.sdk.material.response.NewsInnerImgAddRespone;

/**
 * <p>上传图文消息内的图片获取URL请求对象
 * <p>本接口所上传的图片不占用公众号的素材库中图片数量的5000个的限制。
 * <p>图片仅支持jpg/png格式，大小必须在1MB以下。
 * <p>Q：测试号中进行测试时超过1M的图片也能正常上传并且访问到？
 * @author Rocye
 * @version 2016-04-12
 */
public class NewsInnerImgAddRequest implements Request<NewsInnerImgAddRespone> {
    
	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
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
     * @param fullFilePath  媒体文件路径+文件名
     */
    public NewsInnerImgAddRequest(String fullFilePath) {
        this.fileName = StringUtils.substringAfterLast(fullFilePath, File.separator);
        this.filePath = StringUtils.substringBeforeLast(fullFilePath, File.separator) + File.separator;
    }

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<NewsInnerImgAddRespone> getResponseClass(){
        return NewsInnerImgAddRespone.class;
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
