package org.wx.sdk.template.request;

import java.util.HashMap;
import java.util.Map;
import org.wx.sdk.base.Request;
import org.wx.sdk.template.response.TemplateGetIdRespone;

/**
 * <p>从行业模板库选择模板到帐号后台，获得模板ID的过程可在微信公众平台后台完成。
 * <p>为方便第三方开发者，提供通过接口调用的方式来获取模板ID。
 * @author Rocye
 * @version 2017-08-22
 */
public class TemplateGetIdRequest implements Request<TemplateGetIdRespone>{
	/** 调用接口凭证 */
    private String accessToken;
    /** 请求参数 */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
    
    /** 模板库中模板的编号，有“TM**”和“OPENTMTM**”等形式 */
    private String template_id_short;
    
    /**
     * 构造器
     * @param templateIdShort 模板库中模板的编号
     */
    public TemplateGetIdRequest(String templateIdShort) {
    	this.template_id_short = templateIdShort;
    }

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<TemplateGetIdRespone> getResponseClass(){
        return TemplateGetIdRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
    	wxHashMap.put("template_id_short", template_id_short);
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

	public String getTemplate_id_short() {
		return template_id_short;
	}
	public void setTemplate_id_short(String template_id_short) {
		this.template_id_short = template_id_short;
	}

}
