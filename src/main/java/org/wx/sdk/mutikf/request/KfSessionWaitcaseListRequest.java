package org.wx.sdk.mutikf.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.mutikf.response.KfSessionWaitcaseListRespone;

import java.util.HashMap;
import java.util.Map;

/**
 * 获取未接入会话列表请求对象
 * @author Rocye
 * @version 2017.10.27
 */
public class KfSessionWaitcaseListRequest implements Request<KfSessionWaitcaseListRespone> {

	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数 */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();

	/**
	 * 构造器
	 */
	public KfSessionWaitcaseListRequest() {

	}

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/customservice/kfsession/getwaitcase?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<KfSessionWaitcaseListRespone> getResponseClass(){
        return KfSessionWaitcaseListRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
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
        return 1;
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

}
