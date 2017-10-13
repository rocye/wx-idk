package org.wx.sdk.generalize.request;

import java.util.HashMap;
import java.util.Map;
import org.wx.sdk.base.Request;
import org.wx.sdk.generalize.response.Long2ShortUrlRespone;

/**
 * <p>将一条长链接转成短链接请求对象
 * <p>主要使用场景： 开发者用于生成二维码的原链接（商品、支付二维码等）太长导致扫码速度和成功率下降，将原长链接通过此接口转成短链接再生成二维码将大大提升扫码速度和成功率。
 * @author Rocye
 * @version 2016-10-27
 */
public class Long2ShortUrlRequest implements Request<Long2ShortUrlRespone> {
	/** 微信公众平台唯一凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
    /** 此处填long2short，代表长链接转短链接 */
    private String action;
    /** 需要转换的长链接，支持http://、https://、weixin://wxpay 格式的url */
    private String long_url;
    
    /**
     * 构造函数
     * @author Rocye
     * @param longUrl 需要转换的长链接，支持http://、https://、weixin://wxpay 格式的url
     * @version 2016-10-27
     */
    public Long2ShortUrlRequest(String longUrl) {
        this("long2short", longUrl);
    }
    
    /**
     * 构造函数
     * @param action        此处填long2short，代表长链接转短链接
     * @param longUrl       需要转换的长链接，支持http://、https://、weixin://wxpay 格式的url
     */
    public Long2ShortUrlRequest(String action, String longUrl) {
        this.action = action;
        this.long_url = longUrl;
    }

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/cgi-bin/shorturl?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<Long2ShortUrlRespone> getResponseClass(){
        return Long2ShortUrlRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        wxHashMap.put("action", this.action);
        wxHashMap.put("long_url", this.long_url);
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

    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }

    public String getLong_url() {
        return long_url;
    }
    public void setLong_url(String longUrl) {
        long_url = longUrl;
    }

}
