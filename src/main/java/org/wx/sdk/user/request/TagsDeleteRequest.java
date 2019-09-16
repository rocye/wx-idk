package org.wx.sdk.user.request;

import java.util.HashMap;
import java.util.Map;
import org.wx.sdk.base.Request;
import org.wx.sdk.user.object.Tag;
import org.wx.sdk.user.response.TagsDeleteRespone;

/**
 * <p>删除标签请求对象</p>
 * <p>请注意，当某个标签下的粉丝超过10w时，后台不可直接删除标签。</p>
 * <p>此时，开发者可以对该标签下的openid列表，先进行取消标签的操作，直到粉丝数不超过10w后，才可直接删除该标签。</p>
 * @author Rocye
 * @version 2017-02-14
 */
public class TagsDeleteRequest implements Request<TagsDeleteRespone> {
	/** 微信公众平台唯一凭证 */
    private String accessToken;
    /** 请求参数 */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
    /** 标签ID */
    private Tag tag;
    
    /**
     * 构造器
     * @param id  标签ID
     */
    public TagsDeleteRequest(Integer id) {
        this.tag = new Tag(id);
    }

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/cgi-bin/tags/delete?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<TagsDeleteRespone> getResponseClass(){
        return TagsDeleteRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        wxHashMap.put("tag", tag);
        return wxHashMap;
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

	public Tag getTag() {
		return tag;
	}
	public void setTag(Tag tag) {
		this.tag = tag;
	}
    
}
