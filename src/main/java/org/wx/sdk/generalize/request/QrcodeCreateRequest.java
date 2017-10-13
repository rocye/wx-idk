package org.wx.sdk.generalize.request;

import java.util.HashMap;
import java.util.Map;
import org.wx.sdk.base.Request;
import org.wx.sdk.generalize.object.ActionInfo;
import org.wx.sdk.generalize.response.QrcodeCreateRespone;

/**
 * <p>生成带参数的二维码
 * <p>目前有2种类型的二维码：
 * <p>1、临时二维码，是有过期时间的，最长可以设置为在二维码生成后的30天（即2592000秒）后过期，但能够生成较多数量。临时二维码主要用于帐号绑定等不要求二维码永久保存的业务场景;
 * <p>2、永久二维码，是无过期时间的，但数量较少（目前为最多10万个）。永久二维码主要用于适用于帐号绑定、用户来源统计等场景。
 * <p>用户扫描带场景值二维码时，可能推送以下两种事件：
 * <p>如果用户还未关注公众号，则用户可以关注公众号，关注后微信会将带场景值关注事件推送给开发者。
 * <p>如果用户已经关注公众号，在用户扫描后会自动进入会话，微信也会将带场景值扫描事件推送给开发者。
 * <p>获取带参数的二维码的过程包括两步，首先创建二维码ticket，然后凭借ticket到指定URL换取二维码。
 * @author Rocye
 * @version 2017-08-23
 */
public class QrcodeCreateRequest implements Request<QrcodeCreateRespone> {
	/** 微信公众平台唯一凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
    
    /** 二维码类型，QR_SCENE为临时的整型参数值，QR_STR_SCENE为临时的字符串参数值，QR_LIMIT_SCENE为永久的整型参数值，QR_LIMIT_STR_SCENE为永久的字符串参数值 */
    private String action_name;
    /** 二维码详细信息 */
    private ActionInfo action_info;
    /** 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为30秒。 */
    private Long expire_seconds;
    
    /**
     * 临时二维码(字符串参数)构造函数
     * @param sceneStr		场景值ID（字符串形式的ID），字符串类型，长度限制为1到64  	
     * @param expireSeconds	该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为30秒。
     * @author Rocye
     * @version 2017-08-23
     * @return QrcodeCreateRequest
     */
    public static QrcodeCreateRequest getTempQrStrScene(String sceneStr, Long expireSeconds){
    	return new QrcodeCreateRequest("QR_STR_SCENE", new ActionInfo(sceneStr), expireSeconds);
    }
    
    /**
     * 临时二维码(数字参数)构造函数
     * @param sceneId		场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
     * @param expireSeconds	该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为30秒。
     * @author Rocye
     * @version 2017-08-23
     * @return QrcodeCreateRequest
     */
    public static QrcodeCreateRequest getTempQrScene(Integer sceneId, Long expireSeconds) {
    	return new QrcodeCreateRequest("QR_SCENE", new ActionInfo(sceneId), expireSeconds);
    }
    
    /**
     * 永久二维码(字符串参数)构造函数
     * @param sceneStr	场景值ID（字符串形式的ID），字符串类型，长度限制为1到64  	
     * @author Rocye
     * @version 2017-08-23
     * @return QrcodeCreateRequest
     */
    public static QrcodeCreateRequest getLimitQrStrScene(String sceneStr) {
    	return new QrcodeCreateRequest("QR_LIMIT_STR_SCENE", new ActionInfo(sceneStr), null);
    }
    
    /**
     * 永久二维码(数字参数)构造函数
     * @param sceneId	场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
     * @author Rocye
     * @version 2017-08-23
     * @return QrcodeCreateRequest
     */
    public static QrcodeCreateRequest getLimitQrScene(Integer sceneId) {
    	return new QrcodeCreateRequest("QR_LIMIT_SCENE", new ActionInfo(sceneId), null);
    }
    
    /**
     * 构造函数
     * @param actionName	二维码类型，QR_SCENE为临时的整型参数值，QR_STR_SCENE为临时的字符串参数值，QR_LIMIT_SCENE为永久的整型参数值，QR_LIMIT_STR_SCENE为永久的字符串参数值
     * @param actionInfo	二维码详细信息
     * @param expireSeconds	该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为30秒。
     */
    public QrcodeCreateRequest(String actionName, ActionInfo actionInfo, Long expireSeconds) {
		this.action_name = actionName;
		this.action_info = actionInfo;
		this.expire_seconds = expireSeconds;
	}

	/**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<QrcodeCreateRespone> getResponseClass(){
        return QrcodeCreateRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        wxHashMap.put("action_name", this.action_name);
        wxHashMap.put("action_info", this.action_info);
        if(this.expire_seconds != null){
        	wxHashMap.put("expire_seconds", this.expire_seconds);
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

	public String getAction_name() {
		return action_name;
	}
	public void setAction_name(String action_name) {
		this.action_name = action_name;
	}

	public ActionInfo getAction_info() {
		return action_info;
	}
	public void setAction_info(ActionInfo action_info) {
		this.action_info = action_info;
	}

	public Long getExpire_seconds() {
		return expire_seconds;
	}
	public void setExpire_seconds(Long expire_seconds) {
		this.expire_seconds = expire_seconds;
	}

}
