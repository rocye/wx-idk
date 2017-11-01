package org.wx.sdk.wifi.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.wifi.response.WifiApportalRegisterRespone;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>添加portal型设备请求对象
 * <p>调用下述接口可以添加portal型设备的网络信息，并获得secretkey。secretkey为加密字符串参数，是portal设备改造流程中的重要参数。
 * <p>为防止secretkey泄露，可通过此接口重置刷新，重置后之前生成的secretkey将会失效。需注意：
 * <p>1. 同一个门店可以添加多个ssid，最大添加100个ssid；
 * <p>2. 一个门店只能拥有一种设备类型，只要调用此接口添加一个ssid后，该门店即为portal型改造设备。
 * 如果门店下已有非portal型设备时，无法调用此接口。
 * @author Rocye
 * @version 2017.10.31
 */
public class WifiApportalRegisterRequest implements Request<WifiApportalRegisterRespone> {

	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();

    /** 门店ID */
    private Integer shop_id;
    /** <p>无线网络设备的ssid，限30个字符以内。
	 *  <p>ssid支持中文，但可能因设备兼容性问题导致显示乱码，或无法连接等问题，相关风险自行承担！*/
    private String ssid;
    /** 重置secretkey，false-不重置，true-重置，默认为false*/
    private Boolean reset;

    /**
     * 构造器
     */
    public WifiApportalRegisterRequest() {
    }

	/**
	 * 构造器
	 * @param shopId	门店ID
	 * @param ssid		无线网络设备的ssid
	 */
	public WifiApportalRegisterRequest(Integer shopId, String ssid) {
		this.shop_id = shopId;
		this.ssid = ssid;
	}

	/**
	 * 构造器
	 * @param shopId	门店ID
	 * @param ssid		无线网络设备的ssid
	 * @param reset		重置secretkey，false-不重置，true-重置
	 */
	public WifiApportalRegisterRequest(Integer shopId, String ssid, Boolean reset) {
		this.shop_id = shopId;
		this.ssid = ssid;
		this.reset = reset;
	}

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/bizwifi/apportal/register?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<WifiApportalRegisterRespone> getResponseClass(){
        return WifiApportalRegisterRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("shop_id", this.shop_id);
        paraMap.put("ssid", this.ssid);
        if(this.reset != null){
			paraMap.put("reset", this.reset);
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

	public String getSsid() {
		return ssid;
	}
	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	public Boolean getReset() {
		return reset;
	}
	public void setReset(Boolean reset) {
		this.reset = reset;
	}

}
