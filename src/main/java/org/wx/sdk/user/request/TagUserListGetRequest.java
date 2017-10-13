package org.wx.sdk.user.request;

import java.util.HashMap;
import java.util.Map;
import org.wx.sdk.base.Request;
import org.wx.sdk.user.response.TagUserListGetRespone;

/**
 * 获取标签下粉丝列表请求对象
 * @author Rocye
 * @version 2017-02-14
 */
public class TagUserListGetRequest implements Request<TagUserListGetRespone> {
	/** 微信公众平台唯一凭证 */
    private String accessToken;
    /** 请求参数 */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
    /** 标签ID */
    private Integer tagid;
    /** 第一个拉取的OPENID，不填默认从头开始拉取 */
    private String next_openid;
    
    /**
     * 构造器
     */
    public TagUserListGetRequest() {
    }
    
    /**
     * 构造器
     * @param tagId 标签ID
     */
    public TagUserListGetRequest(Integer tagId) {
    	this.tagid = tagId.intValue();
    }
    
    /**
     * 构造器
     * @param tagId			标签ID
     * @param nextOpenid    第一个拉取的OPENID，不填默认从头开始拉取
     */
    public TagUserListGetRequest(Integer tagId, String nextOpenid) {
    	this.tagid = tagId.intValue();
    	if(this.next_openid != null){
    		this.next_openid = nextOpenid;
    	}
    }

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/cgi-bin/user/tag/get?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<TagUserListGetRespone> getResponseClass(){
        return TagUserListGetRespone.class;
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

	public Integer getTagid() {
		return tagid;
	}
	public void setTagid(Integer tagid) {
		this.tagid = tagid;
	}

	public String getNext_openid() {
		return next_openid;
	}
	public void setNext_openid(String next_openid) {
		this.next_openid = next_openid;
	}

}
