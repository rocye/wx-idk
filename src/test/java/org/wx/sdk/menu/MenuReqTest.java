package org.wx.sdk.menu;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.wx.sdk.WxClient;
import org.wx.sdk.base.Const;
import org.wx.sdk.material.request.PerpetualMaterialBatGetRequest;
import org.wx.sdk.material.response.PerpetualMaterialBatGetRespone;
import org.wx.sdk.menu.object.WXButton;
import org.wx.sdk.menu.object.WXMatchrule;
import org.wx.sdk.menu.request.ConditionalAddRequest;
import org.wx.sdk.menu.request.ConditionalDeleteRequest;
import org.wx.sdk.menu.request.ConditionalTrymatchRequest;
import org.wx.sdk.menu.request.MenuCreateRequest;
import org.wx.sdk.menu.request.MenuDeleteRequest;
import org.wx.sdk.menu.request.MenuGetRequest;
import org.wx.sdk.menu.request.SelfmenuInfoGetRequest;
import org.wx.sdk.menu.response.ConditionalAddRespone;
import org.wx.sdk.menu.response.ConditionalDeleteRespone;
import org.wx.sdk.menu.response.ConditionalTrymatchRespone;
import org.wx.sdk.menu.response.MenuCreateRespone;
import org.wx.sdk.menu.response.MenuDeleteRespone;
import org.wx.sdk.menu.response.MenuGetRespone;
import org.wx.sdk.menu.response.SelfmenuInfoGetRespone;
import org.wx.sdk.token.RedisAccessToken;

public class MenuReqTest {
    /**
     * 测试菜单创建
     */
    @Test
    public void testMenuCreateReq(){
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        List<WXButton> button = new ArrayList<WXButton>(0);
        button.add(new WXButton("click", "今日歌曲", "V1001_TODAY_MUSIC"));
        
        List<WXButton> subBtn1 = new ArrayList<WXButton>(0);
        subBtn1.add(new WXButton("view", "搜索", "http://www.soso.com/", null));
        subBtn1.add(new WXButton("view", "视频", "http://v.qq.com/", null));
        subBtn1.add(new WXButton("click", "赞一下我们", "V1001_GOOD"));
        button.add(new WXButton("菜单", subBtn1));
        
        MenuCreateRequest menuCreateReq = new MenuCreateRequest(button);
        MenuCreateRespone menuCreateRes  = wxClient.excute(menuCreateReq);
        System.out.println(menuCreateRes.getBody());
    }
    
    /**
     * 测试所有菜单的删除
     */
    @Test
    public void testMenuDeleteReq(){
    	String accessToken = "AnQVscs1vyzDDX9By8DrbxYEAdu9OlpGMzcNZFmTUmrb_Rh8n962A81I4DuL5F1dPhs3S1F58ppL3EPKGi8i1blL_oDrcxoTcfnmNrISzEohzRE5yC8SuMLSoAgEGlfsITUkCFAOZA";
        WxClient wxClient = new WxClient(accessToken);
        //WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        MenuDeleteRequest menuDeleteReq = new MenuDeleteRequest();
        MenuDeleteRespone menuDeleteRes = wxClient.excute(menuDeleteReq);
        System.out.println(menuDeleteRes.getBody());
    }
    
    /**
     * 测试自定义菜单查询接口
     */
    @Test
    public void testMenuGetReq(){
    	String accessToken = "AnQVscs1vyzDDX9By8DrbxYEAdu9OlpGMzcNZFmTUmrb_Rh8n962A81I4DuL5F1dPhs3S1F58ppL3EPKGi8i1blL_oDrcxoTcfnmNrISzEohzRE5yC8SuMLSoAgEGlfsITUkCFAOZA";
        WxClient wxClient = new WxClient(accessToken);
        //WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        MenuGetRequest menuGetReq = new MenuGetRequest();
        MenuGetRespone menuGetRes = wxClient.excute(menuGetReq);
        System.out.println(menuGetRes.getBody());
    }
    
    /**
     * 测试个性化菜单创建
     */
    @Test
    public void testConditionalAddReq(){
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        List<WXButton> button = new ArrayList<WXButton>(0);
        button.add(new WXButton("click", "明日歌曲X", "V1001_TODAY_MUSIC"));
        
        List<WXButton> subBtn1 = new ArrayList<WXButton>(0);
        subBtn1.add(new WXButton("view", "搜索X", "http://www.soso.com/", null));
        subBtn1.add(new WXButton("view", "视频X", "http://v.qq.com/", null));
        subBtn1.add(new WXButton("click", "赞一下我们X", "V1001_GOOD"));
        button.add(new WXButton("菜单X", subBtn1));
        
        WXMatchrule matchrule = new WXMatchrule();
        matchrule.setSex(2);
        
        ConditionalAddRequest conditionalAddReq = new ConditionalAddRequest(button, matchrule);
        ConditionalAddRespone conditionalAddRes = wxClient.excute(conditionalAddReq);
        //{"menuid":416427467}
        System.out.println(conditionalAddRes.getBody());
    }
    
    /**
     * 测试个性化菜单删除
     */
    @Test
    public void testConditionalDelReq(){
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        ConditionalDeleteRequest conditionalDeleteReq = new ConditionalDeleteRequest(416427467L);
        ConditionalDeleteRespone conditionalDeleteRes = wxClient.excute(conditionalDeleteReq);
        System.out.println(conditionalDeleteRes.getBody());
    }
    
    /**
     * 测试个性化菜单匹配结果
     */
    @Test
    public void testConditionalTrymatchReq(){
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        ConditionalTrymatchRequest conditionalTrymatchReq = new ConditionalTrymatchRequest("oFYHLviCatnBPDs1XxcXoOePNows");
        ConditionalTrymatchRespone conditionalTrymatchRes = wxClient.excute(conditionalTrymatchReq);
        System.out.println(conditionalTrymatchRes.getBody());
    }
    
    /**
     * 测试获取自定义菜单配置接口（编辑模式或开发模式）
     */
    @Test
    public void testSelfMenuInfoGetReq(){
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        SelfmenuInfoGetRequest selfmenuInfoGetReq = new SelfmenuInfoGetRequest();
        SelfmenuInfoGetRespone selfmenuInfoGetRes = wxClient.excute(selfmenuInfoGetReq);
        System.out.println(selfmenuInfoGetRes.getBody());
    }

    
}
