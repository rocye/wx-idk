package org.wx.sdk.material.request;

import java.util.HashMap;
import java.util.Map;
import org.wx.sdk.base.Request;
import org.wx.sdk.material.response.CommentRespone;

/**
 * 打开已群发文章评论请求对象
 * @author Rocye
 * @version 2017.10.10
 */
public class CommentOpenRequest implements Request<CommentRespone> {
    
	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
    /** 群发返回的id */
    private Long msg_data_id;
    /** 多图文时，用来指定第几篇图文，从0开始，不带默认操作该msg_data_id的第一篇图文 */
    private Integer index;
    
    /**
     * 构造器
     * @param msgDataId  群发返回的id
     * @param index  多图文时，用来指定第几篇图文
     */
    public CommentOpenRequest(Long msgDataId, Integer index) {
        this.msg_data_id = msgDataId;
        this.index = index;
    }

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/cgi-bin/comment/open?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<CommentRespone> getResponseClass(){
        return CommentRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        wxHashMap.put("msg_data_id", this.msg_data_id);
        wxHashMap.put("index", this.index);
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

    public Long getMsg_data_id() {
		return msg_data_id;
	}
	public void setMsg_data_id(Long msg_data_id) {
		this.msg_data_id = msg_data_id;
	}

	public Integer getIndex() {
        return index;
    }
    public void setIndex(Integer index) {
        this.index = index;
    }

}
