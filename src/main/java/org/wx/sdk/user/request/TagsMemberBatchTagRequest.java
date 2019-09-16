package org.wx.sdk.user.request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.wx.sdk.base.Request;
import org.wx.sdk.user.response.TagsMemberBatchTagRespone;

/**
 * <p>批量为用户打标签请求对象</p>
 * <p>标签功能目前支持公众号为用户打上最多三个标签</p>
 * @author Rocye
 * @version 2017-02-14
 */
public class TagsMemberBatchTagRequest implements Request<TagsMemberBatchTagRespone> {
    
	/** 微信公众平台唯一凭证 */
    private String accessToken;
    /** 请求参数 */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
    /** 用户唯一标识符openid的列表（size不能超过50）*/
    private List<String> openid_list;
    /** 标签id */
    private Integer tagid;
    
    /**
     * 构造器
     * @param openidList    用户openId列表
     * @param tagId     	标签ID
     */
    public TagsMemberBatchTagRequest(List<String> openidList, Integer tagId) {
        this.openid_list = openidList;
        this.tagid = tagId.intValue();
    }

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/cgi-bin/tags/members/batchtagging?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<TagsMemberBatchTagRespone> getResponseClass(){
        return TagsMemberBatchTagRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        wxHashMap.put("openid_list", openid_list);
        wxHashMap.put("tagid", tagid);
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

	public List<String> getOpenid_list() {
		return openid_list;
	}
	public void setOpenid_list(List<String> openid_list) {
		this.openid_list = openid_list;
	}

	public Integer getTagid() {
		return tagid;
	}
	public void setTagid(Integer tagid) {
		this.tagid = tagid;
	}
    
}
