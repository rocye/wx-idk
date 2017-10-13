package org.wx.sdk.menu.request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.wx.sdk.base.Request;
import org.wx.sdk.menu.object.WXButton;
import org.wx.sdk.menu.response.MenuCreateRespone;

/**
 * 自定义菜单创建请求对象
 * @author Rocye
 * @version 2016-08-16
 */
public class MenuCreateRequest implements Request<MenuCreateRespone> {
    
	/** 微信公众平台唯一凭证 */
    private String accessToken;
    /** 请求参数 */
    private Map<String, Object> wxHashMap = new HashMap<String, Object>();
    /** 一级菜单数组，个数应为1~3个 */
    private List<WXButton> button;
    
    /**
     * 构造器
     * @param button    一级菜单数组，个数应为1~3个
     */
    public MenuCreateRequest(List<WXButton> button) {
        this.button = button;
    }

    /**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+ this.accessToken;
        return url;
    }

    /**
     * 获取返回对象类
     */
    public Class<MenuCreateRespone> getResponseClass(){
        return MenuCreateRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
        wxHashMap.put("button", this.button);
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

    public List<WXButton> getButton() {
        return button;
    }
    public void setButton(List<WXButton> button) {
        this.button = button;
    }
    
}
