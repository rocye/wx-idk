package org.wx.sdk.wifi.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.wifi.response.WifiHomepageSetRespone;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>设置商家主页请求对象
 * <p>设置商户主页后，点击微信聊首页欢迎语，即可进入设置的商户主页。可以设置默认模板和自定义url模板。
 * <p>注：第三方平台和认证公众号才能调用该接口设置商家主页。
 * @author Rocye
 * @version 2017.11.01
 */
public class WifiHomepageSetRequest implements Request<WifiHomepageSetRespone> {

	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();

    /** 门店ID */
    private Integer shop_id;
	/** 模板ID，0-默认模板，1-自定义url */
    private Short template_id;
	/** 自定义链接，当template_id为1时必填 */
    private String url;

	/**
	 * 构造器
	 * @param shopId		门店ID
	 * @param templateId	模板ID，0-默认模板，1-自定义url
	 */
	public WifiHomepageSetRequest(Integer shopId, Short templateId) {
		this.shop_id = shopId;
		this.template_id = templateId;
	}

	/**
	 * 构造器
	 * @param shopId		门店ID
	 * @param templateId	模板ID，0-默认模板，1-自定义url
	 * @param url			自定义链接，当template_id为1时必填
	 */
	public WifiHomepageSetRequest(Integer shopId, Short templateId, String url) {
		this.shop_id = shopId;
		this.template_id = templateId;
		this.url = url;
	}

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/bizwifi/homepage/set?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<WifiHomepageSetRespone> getResponseClass(){
        return WifiHomepageSetRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
		wxHashMap.put("shop_id", this.shop_id);
		wxHashMap.put("template_id", this.template_id);
        if(this.template_id == 1 && this.url != null){
        	Map<String, Object> structMap = new HashMap<String, Object>();
			structMap.put("url", this.url);
			wxHashMap.put("struct", structMap);
		}
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

	public Integer getShop_id() {
		return shop_id;
	}
	public void setShop_id(Integer shop_id) {
		this.shop_id = shop_id;
	}

	public Short getTemplate_id() {
		return template_id;
	}
	public void setTemplate_id(Short template_id) {
		this.template_id = template_id;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
