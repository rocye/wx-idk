package org.wx.sdk.user.request;

import java.util.HashMap;
import java.util.Map;
import org.wx.sdk.base.Request;
import org.wx.sdk.user.object.Tag;
import org.wx.sdk.user.response.TagsCreateRespone;

/**
 * <p>创建标签请求对象</p>
 * <p>一个公众号，最多可以创建100个标签</p>
 * @author Rocye
 * @version 2017-02-14
 */
public class TagsCreateRequest implements Request<TagsCreateRespone> {
    /** 微信公众平台唯一凭证 */
    private String accessToken;
    /** 请求参数 */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
    /** 分组名称 */
    private Tag tag;
    
    /**
     * 构造器
     * @param name  标签名（30个字符以内）
     */
    public TagsCreateRequest(String name) {
        this.tag = new Tag(name);
    }

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/cgi-bin/tags/create?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<TagsCreateRespone> getResponseClass(){
        return TagsCreateRespone.class;
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
