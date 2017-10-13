package org.wx.sdk.mutikf.request;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.wx.sdk.base.Request;
import org.wx.sdk.mutikf.response.KfAccountRespone;

/**
 * <p>上传客服头像
 * <p>开发者可调用本接口来上传图片作为客服人员的头像，
 * <p>头像图片文件必须是jpg格式，
 * <p>推荐使用640*640大小的图片以达到最佳效果。
 * @author Rocye
 * @version 2016-08-09
 */
public class KfUploadHeadimgRequest implements Request<KfAccountRespone> {
    
	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数 */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
    /** 完整客服账号，格式为：账号前缀@公众号微信号 */
    private String kf_account;
    /** 图像文件路径 */
    private String filePath;
    /** 图像文件名 */
    private String fileName;
    
    /**
     * 构造函数
     * @param fullFilePath  图像文件路径+文件名
     * @param kfAccount     客户帐号
     */
    public KfUploadHeadimgRequest(String kfAccount, String fullFilePath) {
        this.kf_account = kfAccount;
        this.fileName = StringUtils.substringAfterLast(fullFilePath, File.separator);
        this.filePath = StringUtils.substringBeforeLast(fullFilePath, File.separator) + File.separator;
    }

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "http://api.weixin.qq.com/customservice/kfaccount/uploadheadimg?access_token="+ this.accessToken +"&kf_account=" + this.kf_account;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<KfAccountRespone> getResponseClass(){
        return KfAccountRespone.class;
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

    public String getKf_account() {
        return kf_account;
    }
    public void setKf_account(String kfAccount) {
        kf_account = kfAccount;
    }
    
}
