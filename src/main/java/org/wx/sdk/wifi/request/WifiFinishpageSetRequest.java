package org.wx.sdk.wifi.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.wifi.response.WifiFinishpageSetRespone;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>设置连网完成页请求对象
 * <p>当顾客使用微信连Wi-Fi方式连网成功时，点击页面右上角“完成”按钮，即可进入已设置的连网完成页。
 * <p>注：此接口只对公众号第三方平台和认证公众号开放，非认证公众号无法调用接口设置连网成功页。
 * @author Rocye
 * @version 2017.11.01
 */
public class WifiFinishpageSetRequest implements Request<WifiFinishpageSetRespone> {

	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();

    /** 门店ID */
    private Integer shop_id;
	/** 连网完成页URL */
    private String finishpage_url;

	/**
	 * 构造器
	 * @param shopId		门店ID
	 * @param finishpageUrl	连网完成页URL
	 */
	public WifiFinishpageSetRequest(Integer shopId, String finishpageUrl) {
		this.shop_id = shopId;
		this.finishpage_url = finishpageUrl;
	}

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/bizwifi/finishpage/set?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<WifiFinishpageSetRespone> getResponseClass(){
        return WifiFinishpageSetRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
		wxHashMap.put("shop_id", this.shop_id);
		wxHashMap.put("finishpage_url", this.finishpage_url);
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

	public String getFinishpage_url() {
		return finishpage_url;
	}
	public void setFinishpage_url(String finishpage_url) {
		this.finishpage_url = finishpage_url;
	}

}
