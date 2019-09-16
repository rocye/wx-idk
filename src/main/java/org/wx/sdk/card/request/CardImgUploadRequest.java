package org.wx.sdk.card.request;

import org.apache.commons.lang3.StringUtils;
import org.wx.sdk.base.Request;
import org.wx.sdk.card.respone.CardImgUploadRespone;
import java.io.File;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>上传卡券图片素材请求对象
 * <p>开发者需调用该接口上传商户图标至微信服务器，获取相应logo_url/icon_list/image_url，用于卡券创建
 * <p>开发者注意事项：
 * <br>1.上传的图片限制文件大小限制1MB，仅支持JPG、PNG格式。
 * <br>2.调用接口获取图片url仅支持在微信相关业务下使用。
 * @author Rocye
 * @version 2017.12.19
 */
public class CardImgUploadRequest implements Request<CardImgUploadRespone> {

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
    public CardImgUploadRequest(String fullFilePath) {
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
    public Class<CardImgUploadRespone> getResponseClass(){
        return CardImgUploadRespone.class;
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
