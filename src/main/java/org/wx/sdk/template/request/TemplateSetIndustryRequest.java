package org.wx.sdk.template.request;

import java.util.HashMap;
import java.util.Map;
import org.wx.sdk.base.Request;
import org.wx.sdk.template.response.TemplateSetIndustryRespone;

/**
 * <p>设置行业可在微信公众平台后台完成，每月可修改行业1次，帐号仅可使用所属行业中相关的模板【订阅号与服务号认证后均可用】
 * <p>为方便第三方开发者，提供通过接口调用的方式来修改账号所属行业。
 * @author Rocye
 * @version 2017-08-22
 */
public class TemplateSetIndustryRequest implements Request<TemplateSetIndustryRespone>{
	/** 调用接口凭证 */
    private String accessToken;
    /** 请求参数 */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
    
    private String industry_id1;
    private String industry_id2;
    

    /**
     * 构造器
     * @param industry1   行业编号1
     * @param industry2   行业编号2
     */
    public TemplateSetIndustryRequest(String industry1, String industry2) {
        this.industry_id1 = industry1;
        this.industry_id2 = industry2;
    }

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<TemplateSetIndustryRespone> getResponseClass(){
        return TemplateSetIndustryRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        wxHashMap.put("industry_id1", industry_id1);
        wxHashMap.put("industry_id2", industry_id2);
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

	public String getIndustry_id1() {
		return industry_id1;
	}
	public void setIndustry_id1(String industry_id1) {
		this.industry_id1 = industry_id1;
	}

	public String getIndustry_id2() {
		return industry_id2;
	}
	public void setIndustry_id2(String industry_id2) {
		this.industry_id2 = industry_id2;
	}

}
