package org.wx.sdk.user.request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.wx.sdk.base.Request;
import org.wx.sdk.user.response.BatchblackListRespone;

/**
 * 公众号可通过该接口来拉黑一批用户，黑名单列表由一串 OpenID组成。
 * @author Rocye
 * @version 2017-08-22
 */
public class BatchblackListRequest implements Request<BatchblackListRespone> {
    
	/** 调用接口凭证 */
    private String accessToken;
    /** 请求参数 */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
    
    /** 需要拉入黑名单的用户的openid，一次拉黑最多允许20个 */
    private List<String> openid_list;
    
    /**
     * 构造函数
     */
    public BatchblackListRequest() {
    	
    }
    
    /**
     * 构造函数
     * @param openidList 拉入黑名单的openid
     */
    public BatchblackListRequest(List<String> openidList) {
        this.openid_list = openidList;
    }

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/cgi-bin/tags/members/batchblacklist?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<BatchblackListRespone> getResponseClass(){
        return BatchblackListRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
		wxHashMap.put("opened_list", openid_list);
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
        return 3;
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

	public List<String> getOpenid_list() {
		return openid_list;
	}
	public void setOpenid_list(List<String> openid_list) {
		this.openid_list = openid_list;
	}

}
