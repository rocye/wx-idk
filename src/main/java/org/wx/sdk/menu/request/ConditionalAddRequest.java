package org.wx.sdk.menu.request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.wx.sdk.base.Request;
import org.wx.sdk.menu.object.WXButton;
import org.wx.sdk.menu.object.WXMatchrule;
import org.wx.sdk.menu.response.ConditionalAddRespone;

/**
 * 个性化菜单创建请求对象
 * @author Rocye
 * @version 2016-08-31
 */
public class ConditionalAddRequest implements Request<ConditionalAddRespone> {
    
	/** 微信公众平台唯一接口凭证 */
    private String accessToken;
    /** 请求参数的Map */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
    /** 一级菜单数组，个数应为1~3个 */
    private List<WXButton> button;
    /** 菜单匹配规则 */
    private WXMatchrule matchrule;
    
    /**
     * 构造器
     * @param button        一级菜单数组，个数应为1~3个
     * @param matchrule     菜单匹配规则
     */
    public ConditionalAddRequest(List<WXButton> button, WXMatchrule matchrule) {
        this.button = button;
        this.matchrule = matchrule;
    }

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/cgi-bin/menu/addconditional?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<ConditionalAddRespone> getResponseClass(){
        return ConditionalAddRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        wxHashMap.put("button", this.button);
        wxHashMap.put("matchrule", this.matchrule);
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

    public List<WXButton> getButton() {
        return button;
    }
    public void setButton(List<WXButton> button) {
        this.button = button;
    }

    public WXMatchrule getMatchrule() {
        return matchrule;
    }
    public void setMatchrule(WXMatchrule matchrule) {
        this.matchrule = matchrule;
    }
    
}
