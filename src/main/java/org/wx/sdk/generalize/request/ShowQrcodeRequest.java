package org.wx.sdk.generalize.request;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.wx.sdk.base.Request;
import org.wx.sdk.generalize.response.ShowQrcodeRespone;

/**
 * <p>通过ticket换取二维码
 * <p>获取二维码ticket后，开发者可用ticket换取二维码图片
 * @author Rocye
 * @version 2017-08-23
 */
public class ShowQrcodeRequest implements Request<ShowQrcodeRespone> {
	
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
    
	/** 获取的二维码ticket，凭借此ticket可以在有效时间内换取二维码。 */
    private String ticket;
    
    /** 下载路径 */
    private String filePath;
    /** 下载文件名 */
    private String fileName;
    
    /**
     * 构造函数
     * @param ticket 获取的二维码ticket，凭借此ticket可以在有效时间内换取二维码
     * @param fullDownPath  下载文件路径+文件名
     */
    public ShowQrcodeRequest(String ticket, String fullDownPath) {
		this.ticket = ticket;
		this.fileName = Paths.get(fullDownPath).getFileName().toString();
        this.filePath = StringUtils.remove(fullDownPath, this.fileName);
	}

	/**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=" + this.ticket;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<ShowQrcodeRespone> getResponseClass(){
        return ShowQrcodeRespone.class;
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
     * 请求类型：1-普通Get 2-下载GET 3-普通POST 4-下载POST 5-无参上传   6-有参上传
     */
    public int getReqType(){
        return 2;
    }
    
    /**
     * 设置AccessToken
     */
    public void setAccessToken(String accessToken){
    }
    
    /**
     * 请求参数格式(kv,json,xml)
     */
    public String getParamFormat(){
        return "json";
    }

	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
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
