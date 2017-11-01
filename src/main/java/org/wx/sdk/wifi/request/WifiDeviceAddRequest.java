package org.wx.sdk.wifi.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.wifi.response.WifiDeviceAddRespone;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>添加密码型设备请求对象
 * <p>1. 同一个门店可以添加多个ssid，最大添加100个ssid；
 * <p>2. 已添加过的ssid不能再重复添加；
 * <p>3. 一个门店只能拥有一种设备类型，只要调用此接口添加一个ssid后，该门店即为密码型设备，不能再添加portal型设备。
 * 调用清空门店Wi-Fi信息接口清空网络信息后，可再设置为其它类型设备。
 * @author Rocye
 * @version 2017.10.31
 */
public class WifiDeviceAddRequest implements Request<WifiDeviceAddRespone> {

	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();

    /** 门店ID */
    private Integer shop_id;
    /** <p>无线网络设备的ssid。ssid和密码必须有一个以大写字母“WX”开头；32个字符以内；
	 *  <p>ssid支持中文，但可能因设备兼容性问题导致显示乱码，或无法连接等问题，相关风险自行承担！*/
    private String ssid;
    /** <p>无线网络设备的密码。8-24个字符；
	 *  <p>不能包含中文字符；ssid和密码必须有一个以大写字母“WX”开头。*/
    private String password;

    /**
     * 构造器
     */
    public WifiDeviceAddRequest() {
    }

	/**
	 * 构造器
	 * @param shopId	门店ID
	 * @param ssid		无线网络设备的ssid
	 * @param password	无线网络设备的密码
	 */
	public WifiDeviceAddRequest(Integer shopId, String ssid, String password) {
		this.shop_id = shopId;
		this.ssid = ssid;
		this.password = password;
	}

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/bizwifi/device/add?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<WifiDeviceAddRespone> getResponseClass(){
        return WifiDeviceAddRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("shop_id", this.shop_id);
        paraMap.put("ssid", this.ssid);
        paraMap.put("password", this.password);
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

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
