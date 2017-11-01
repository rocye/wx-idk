package org.wx.sdk.wifi.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.wifi.response.WifiShopUpdateRespone;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>修改门店网络信息请求对象
 * <p>1. 只有门店下已添加Wi-Fi网络信息，才能调用此接口修改网络信息；
 * <p>2. 网络信息修改后，密码型设备需同步修改所有设备的ssid或密码；portal型设备需修改所有设备的ssid，
 * 并按照《硬件鉴权协议接口》修改“第二步：改造移动端portal页面”中的ssid参数，否则将无法正常连网。
 * @author Rocye
 * @version 2017.10.30
 */
public class WifiShopUpdateRequest implements Request<WifiShopUpdateRespone> {

	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();

    /** 门店ID */
    private Integer shop_id;
    /** 旧的无线网络设备的ssid */
    private String old_ssid;
    /** <p>无线网络设备的ssid。32个字符以内；
	 *  <p>ssid支持中文，但可能因设备兼容性问题导致显示乱码，或无法连接等问题，相关风险自行承担！
	 *  <p>当门店下是portal型设备时，ssid必填；当门店下是密码型设备时，ssid选填，且ssid和密码必须有一个以大写字母“WX”开头。*/
    private String ssid;
    /** <p>无线网络设备的密码。8-24个字符；
	 *  <p>不能包含中文字符；当门店下是密码型设备时，才可填写password，且ssid和密码必须有一个以大写字母“WX”开头。*/
    private String password;

	/**
	 * 构造器
	 * @param shopId	门店ID
	 * @param oldSsid	旧无线网络设备的ssid
	 * @param ssid		无线网络设备的ssid
	 */
	public WifiShopUpdateRequest(Integer shopId, String oldSsid, String ssid) {
		this.shop_id = shopId;
		this.old_ssid = oldSsid;
		this.ssid = ssid;
	}

	/**
	 * 构造器
	 * @param shopId	门店ID
	 * @param oldSsid	旧无线网络设备的ssid
	 * @param ssid		无线网络设备的ssid
	 * @param password	无线网络设备的密码
	 */
	public WifiShopUpdateRequest(Integer shopId, String oldSsid, String ssid, String password) {
		this.shop_id = shopId;
		this.old_ssid = oldSsid;
		this.ssid = ssid;
		this.password = password;
	}

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/bizwifi/shop/update?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<WifiShopUpdateRespone> getResponseClass(){
        return WifiShopUpdateRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
		wxHashMap.put("shop_id", this.shop_id);
		wxHashMap.put("old_ssid", this.old_ssid);
		wxHashMap.put("ssid", this.ssid);
        if(this.password != null){
			wxHashMap.put("password", this.password);
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

	public String getOld_ssid() {
		return old_ssid;
	}
	public void setOld_ssid(String old_ssid) {
		this.old_ssid = old_ssid;
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
