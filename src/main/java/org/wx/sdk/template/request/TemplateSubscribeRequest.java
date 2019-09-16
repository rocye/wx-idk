package org.wx.sdk.template.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.template.object.DataObj;
import org.wx.sdk.template.response.TemplateSubscribeRespone;
import java.util.HashMap;
import java.util.Map;

/**
 * 通过API推送订阅模板消息给到授权微信用户 请求对象
 * @author Rocye
 * @version 2017-10-23
 */
public class TemplateSubscribeRequest implements Request<TemplateSubscribeRespone>{
	/** 调用接口凭证 */
    private String accessToken;
    /** 请求参数 */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();

    /** 接收消息的用户openid */
    private String touser;
	/** 订阅消息模板ID */
	private String template_id;
	/** 点击消息跳转的链接，需要有ICP备案(否) */
	private String url;
	/** 订阅场景值 */
	private String scene;
	/** 消息标题，15字以内 */
    private String title;
    /** 消息正文，value为消息内容文本（200字以内），没有固定格式，可用\n换行，color为整段消息内容的字体颜色（目前仅支持整段消息为一种颜色） */
    private Map<String, DataObj> data;

    /**
     * 构造器
     * @param touser		接收者openid
     * @param templateId	模板ID
     * @param url			模板跳转链接
     * @param scene			订阅场景值
     * @param title			消息标题，15字以内
     * @param content		消息内容
     */
    public TemplateSubscribeRequest(String touser, String templateId, String url, String scene, String title, DataObj content) {
		this.touser = touser;
		this.template_id = templateId;
		this.url = url;
		this.scene = scene;
		this.title = title;
		this.data = new HashMap<String, DataObj>();
		this.data.put("content", content);
	}

	/**
	 * 构造器
	 * @param touser		接收者openid
	 * @param templateId	模板ID
	 * @param scene			订阅场景值
	 * @param title			消息标题，15字以内
	 * @param content		消息内容
	 */
	public TemplateSubscribeRequest(String touser, String templateId, String scene, String title, DataObj content) {
		this.touser = touser;
		this.template_id = templateId;
		this.scene = scene;
		this.title = title;
		this.data = new HashMap<String, DataObj>();
		this.data.put("content", content);
	}

	/**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/cgi-bin/message/template/subscribe?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<TemplateSubscribeRespone> getResponseClass(){
        return TemplateSubscribeRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        wxHashMap.put("touser", this.touser);
        wxHashMap.put("template_id", this.template_id);
        wxHashMap.put("url", this.url);
        wxHashMap.put("scene", this.scene);
        wxHashMap.put("title", this.title);
        wxHashMap.put("data", data);
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
    
    public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getTemplate_id() {
		return template_id;
	}
	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public String getScene() {
		return scene;
	}
	public void setScene(String scene) {
		this.scene = scene;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public Map<String, DataObj> getData() {
		return data;
	}
	public void setData(Map<String, DataObj> data) {
		this.data = data;
	}

}
