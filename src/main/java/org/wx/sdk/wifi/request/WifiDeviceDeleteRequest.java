package org.wx.sdk.wifi.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.wifi.response.WifiDeviceDeleteRespone;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>删除设备请求对象
 * <p>根据bssid删除门店下的单个设备。删除后请尽快修改设备的网络名称和密码，或停止使用设备，否则设备会自动重新添加进来。
 * 如需清空门店网络及所有设备，请调用“清空门店网络及设备”接口。
 * @author Rocye
 * @version 2017.11.01
 */
public class WifiDeviceDeleteRequest implements Request<WifiDeviceDeleteRespone> {

	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();

    /** 需要删除的无线网络设备无线mac地址，格式冒号分隔，字符长度17个，并且字母小写，例如：00:1f:7a:ad:5c:a8 */
    private String bssid;

    /**
     * 构造器
     */
    public WifiDeviceDeleteRequest() {
    }

	/**
	 * 构造器
	 * @param bssid		需要删除的无线网络设备无线mac地址，格式冒号分隔，字符长度17个，并且字母小写
	 */
	public WifiDeviceDeleteRequest(String bssid) {
		this.bssid = bssid;
	}

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/bizwifi/device/delete?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<WifiDeviceDeleteRespone> getResponseClass(){
        return WifiDeviceDeleteRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("bssid", this.bssid);
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

	public String getBssid() {
		return bssid;
	}
	public void setBssid(String bssid) {
		this.bssid = bssid;
	}

}
