package org.wx.sdk.template.request;

import java.util.HashMap;
import java.util.Map;
import org.wx.sdk.base.Request;
import org.wx.sdk.template.response.TemplateSendRespone;

/**
 * 发送模板消息
 * @author Rocye
 * @version 2017-08-22
 */
public class TemplateSendRequest implements Request<TemplateSendRespone>{
	/** 调用接口凭证 */
    private String accessToken;
    /** 请求参数 */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
    
    private String touser;
    private String template_id;
    private String url;
    private MiniProram miniprogram;
    private Map<String, DataObj> data;
    
    /**
     * 构造器
     * @param touser		接收者openid
     * @param templateId	模板ID
     * @param url			模板跳转链接
     * @param miniprogram	跳小程序所需数据，不需跳小程序可不用传该数据（否）
     * @param data			模板数据
     */
    public TemplateSendRequest(String touser, String templateId, String url, MiniProram miniprogram, Map<String, DataObj> data) {
		this.touser = touser;
		this.template_id = templateId;
		this.url = url;
		this.miniprogram = miniprogram;
		this.data = data;
	}
    
    /**
     * 构造器
     * @param touser		接收者openid
     * @param templateId	模板ID
     * @param url			模板跳转链接
     * @param data			模板数据
     */
    public TemplateSendRequest(String touser, String templateId, String url, Map<String, DataObj> data) {
		this.touser = touser;
		this.template_id = templateId;
		this.url = url;
		this.data = data;
	}

	/**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<TemplateSendRespone> getResponseClass(){
        return TemplateSendRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        wxHashMap.put("touser", touser);
        wxHashMap.put("template_id", template_id);
        wxHashMap.put("url", template_id);
        wxHashMap.put("miniprogram", miniprogram);
        wxHashMap.put("data", data);
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

	public MiniProram getMiniprogram() {
		return miniprogram;
	}
	public void setMiniprogram(MiniProram miniprogram) {
		this.miniprogram = miniprogram;
	}

	public Map<String, DataObj> getData() {
		return data;
	}
	public void setData(Map<String, DataObj> data) {
		this.data = data;
	}


	/**
     * 小程序跳转对象
     * @author Rocye
     * @version 2017.08.22
     */
	public class MiniProram {
		/** 所需跳转到的小程序appid（该小程序appid必须与发模板消息的公众号是绑定关联关系） */
		private String appid;
		/** 所需跳转到小程序的具体页面路径，支持带参数,（示例index?foo=bar） */
		private String pagepath;
		
		/**
		 * 构造器
		 * @param appid		所需跳转到的小程序appid
		 * @param pagepath	所需跳转到小程序的具体页面路径，支持带参数
		 */
		public MiniProram(String appid, String pagepath) {
			this.appid = appid;
			this.pagepath = pagepath;
		}
		
		public String getAppid() {
			return appid;
		}
		public void setAppid(String appid) {
			this.appid = appid;
		}
		
		public String getPagepath() {
			return pagepath;
		}
		public void setPagepath(String pagepath) {
			this.pagepath = pagepath;
		}
		
	}
	
	
	/**
     * 模板数据对象
     * @author Rocye
     * @version 2017.08.22
     */
	public static class DataObj {
		/** 模板内容  */
		private String value;
		/** 模板内容字体颜色，不填默认为黑色(否) */
		private String color;
		
		/**
		 * 构造器
		 * @param value	  模板内容
		 */
		public DataObj(String value) {
			this.value = value;
		}
		
		/**
		 * 构造器
		 * @param value	  模板内容
		 * @param color	  模板内容字体颜色
		 */
		public DataObj(String value, String color) {
			this.value = value;
			this.color = color;
		}
		
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		
	}

}
