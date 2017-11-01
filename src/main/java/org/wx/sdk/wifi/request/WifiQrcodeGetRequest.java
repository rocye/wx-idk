package org.wx.sdk.wifi.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.wifi.response.WifiQrcodeGetRespone;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>获取物料二维码请求对象
 * <p>添加设备后，通过此接口可以获取物料，包括二维码和桌贴两种样式。将物料铺设在线下门店里，可供用户扫码上网。
 * <p>注：只有门店下已添加Wi-Fi网络信息，才能调用此接口获取二维码，添加方式请参考“添加密码型设备”和“添加portal型设备”接口文档。
 * @author Rocye
 * @version 2017.11.01
 */
public class WifiQrcodeGetRequest implements Request<WifiQrcodeGetRespone> {

	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();

    /** 门店ID */
    private Integer shop_id;
    /** 已添加到门店下的无线网络名称 */
    private String ssid;
    /** 物料样式编号：
	 * 0-纯二维码，可用于自由设计宣传材料；
	 * 1-二维码物料，155mm×215mm(宽×高)，可直接张贴 */
    private Integer img_id;

	/**
	 * 构造器
	 * @param shopId	门店ID
	 * @param ssid		已添加到门店下的无线网络名称
	 * @param imgId		物料样式编号：0-纯二维码；1-二维码物料
	 */
	public WifiQrcodeGetRequest(Integer shopId, String ssid, Integer imgId) {
		this.shop_id = shopId;
		this.ssid = ssid;
		this.img_id = imgId;
	}

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/bizwifi/qrcode/get?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<WifiQrcodeGetRespone> getResponseClass(){
        return WifiQrcodeGetRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("shop_id", this.shop_id);
        paraMap.put("ssid", this.ssid);
		paraMap.put("img_id", this.img_id);
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

	public Integer getImg_id() {
		return img_id;
	}
	public void setImg_id(Integer img_id) {
		this.img_id = img_id;
	}

}
