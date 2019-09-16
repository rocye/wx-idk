package org.wx.sdk.poi.request;

import org.apache.commons.lang3.StringUtils;
import org.wx.sdk.base.Request;
import org.wx.sdk.poi.response.UploadPoiImgRespone;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>上传图片请求对象
 * <p>用POI 接口新建门店时所使用的图片url 必须为微信域名的url，因此需要先用上传图片接口上传图片并获取url，再创建门店。
 * <p>上传的图片限制文件大小限制1MB，支持JPG 格式。
 * @author Rocye
 * @version 2017.12.19
 */
public class UploadPoiImgRequest implements Request<UploadPoiImgRespone> {

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
	 * 上传图片名字
	 */
    private String name = "buffer";

    /**
     * 构造器
     * @param fullFilePath  媒体文件路径+文件名
     */
    public UploadPoiImgRequest(String fullFilePath) {
        this.fileName = Paths.get(fullFilePath).getFileName().toString();
        this.filePath = StringUtils.remove(fullFilePath, this.fileName);
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
    public Class<UploadPoiImgRespone> getResponseClass(){
        return UploadPoiImgRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
		wxHashMap.put("name", this.name);
		wxHashMap.put("filePath", this.filePath);
		wxHashMap.put("fileName", this.fileName);
        return wxHashMap;
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
