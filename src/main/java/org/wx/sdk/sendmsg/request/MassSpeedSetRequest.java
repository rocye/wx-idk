package org.wx.sdk.sendmsg.request;

import org.wx.sdk.base.Request;
import org.wx.sdk.sendmsg.response.MassSpeedSetRespone;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>设置群发速度请求对象
 * <p>群发速度的级别，是一个0到4的整数，数字越大表示群发速度越慢。
 * @author Rocye
 * @version 2017.10.20
 */
public class MassSpeedSetRequest implements Request<MassSpeedSetRespone> {

	/** 调用接口凭证 */
    private String accessToken;
    /** 请求参数 */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();

    /** 群发速度的级别 */
    private Integer speed;

    /**
     * 构造器
	 * @param speed 群发速度的级别，是一个0到4的整数，数字越大表示群发速度越慢
     */
    public MassSpeedSetRequest(Integer speed) {
    	this.speed = speed;
    }

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/cgi-bin/message/mass/speed/set?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<MassSpeedSetRespone> getResponseClass(){
        return MassSpeedSetRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
		wxHashMap.put("speed", speed);
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

	public Integer getSpeed() {
		return speed;
	}
	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

}
