package org.wx.sdk.mutikf.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.mutikf.response.KfSessionGetRespone;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>获取客户会话状态请求对象
 * <p>此接口获取一个客户的会话，如果不存在，则kf_account为空。
 * @author Rocye
 * @version 2017.10.27
 */
public class KfSessionGetRequest implements Request<KfSessionGetRespone> {

	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数 */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
    /** 粉丝的openid */
    private String openid;

	/**
	 * 构造器
	 * @param openid	客服昵称，最长6个汉字或12个英文字符
	 */
	public KfSessionGetRequest(String openid) {
		this.openid = openid;
	}

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/customservice/kfsession/getsession?access_token="+ this.accessToken +"&openid="+ this.openid;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<KfSessionGetRespone> getResponseClass(){
        return KfSessionGetRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        return wxHashMap;
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

	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}

}
