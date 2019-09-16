package org.wx.sdk.material.request;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.wx.sdk.base.Request;
import org.wx.sdk.material.response.PerpetualMaterialAddRespone;
import com.alibaba.fastjson.JSON;

/**
 * <p>新增其他类型永久素材
 * <p>图片大小不超过2M，支持bmp/png/jpeg/jpg/gif格式
 * <p>语音大小不超过5M，长度不超过60秒，支持mp3/wma/wav/amr格式
 * <p>视频官方文档没有说明
 * @author Rocye
 * @version 2016-04-12
 */
public class PerpetualMaterialAddRequest implements Request<PerpetualMaterialAddRespone> {
    
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
     * 视频素材标题和描述
     */
    private VideoInfo description;
    
    /**
     * 构造器
     * @param type          媒体文件类型，分别有图片image、语音voice、视频video和缩略图thumb
     * @param fullFilePath  媒体文件路径+文件名
     */
    public PerpetualMaterialAddRequest(String type, String fullFilePath) {
        this.type = type;
        this.fileName = Paths.get(fullFilePath).getFileName().toString();
        this.filePath = StringUtils.remove(fullFilePath, this.fileName);
    }
    
    /**
     * 构造器
     * @param type          媒体文件类型，分别有图片image、语音voice、视频video和缩略图thumb
     * @param fullFilePath  媒体文件路径+文件名
     * @param title         视频标题
     * @param introduction  视频描述
     */
    public PerpetualMaterialAddRequest(String type, String fullFilePath, String title, String introduction) {
        this(type, fullFilePath);
        this.description = new VideoInfo(title, introduction);
    }

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token="+ this.accessToken +"&type="+ this.type;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<PerpetualMaterialAddRespone> getResponseClass(){
        return PerpetualMaterialAddRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        wxHashMap.put("filePath", this.filePath);
        wxHashMap.put("fileName", this.fileName);
        if(this.type.equals("video")){
            wxHashMap.put("description", JSON.toJSONString(this.description));
        }
        return wxHashMap;
    }
    
    /**
     * 请求类型：1-普通Get 2-下载GET 3-普通POST 4-下载POST 5-无参上传   6-有参上传
     */
    public int getReqType(){
        if(this.type.equals("video")){
            return 6;
        }else{
            return 5;
        }
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
    
    /**
     * 上传视频素材附加表单
     * @author Rocye
     * @version 2016-04-12
     */
    public class VideoInfo{
        private String title;           //视频标题
        private String introduction;    //视频描述
        
        public VideoInfo(String title, String introduction) {
            this.title = title;
            this.introduction = introduction;
        }

        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }

        public String getIntroduction() {
            return introduction;
        }
        public void setIntroduction(String introduction) {
            this.introduction = introduction;
        }
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

    public VideoInfo getDescription() {
        return description;
    }
    public void setDescription(VideoInfo description) {
        this.description = description;
    }
    
}
