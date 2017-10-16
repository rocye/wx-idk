package org.wx.sdk.poi;

import org.junit.Test;
import org.wx.sdk.WxClient;
import org.wx.sdk.base.Const;
import org.wx.sdk.poi.object.Poi;
import org.wx.sdk.poi.object.PoiPara;
import org.wx.sdk.poi.request.*;
import org.wx.sdk.poi.response.*;
import org.wx.sdk.token.RedisAccessToken;

public class PoiReqTest {

    /**
     * 测试创建门店
     */
    @Test
    public void testAddPoiReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        Poi poi = new Poi("33788392","肯德基","光谷大道分店","湖北省","武汉市","洪山区","大学园路2号","13558855888",new String[]{"美食","川菜"},(short)3,114.422725,30.460145);
        AddPoiRequest addPoiReq = new AddPoiRequest(poi);
        AddPoiRespone addPoiRes  = wxClient.excute(addPoiReq);
        System.out.println(addPoiRes.getBody());
    }

    /**
     * 测试查询门店信息
     */
    @Test
    public void testGetPoiReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        GetPoiRequest getPoiReq = new GetPoiRequest("33788392");
        GetPoiRespone getPoiRes  = wxClient.excute(getPoiReq);
        System.out.println(getPoiRes.getBody());
    }

    /**
     * 测试查询门店列表
     */
    @Test
    public void testGetPoiListReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        GetPoiListRequest getPoiListReq = new GetPoiListRequest(0, 20);
        GetPoiListRespone getPoiListRes  = wxClient.excute(getPoiListReq);
        System.out.println(getPoiListRes.getBody());
    }

    /**
     * 测试修改门店服务信息
     */
    @Test
    public void testUpdatePoiReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        PoiPara poi = new PoiPara("271864249", "A00001", "020-12345678");
        UpdatePoiRequest updatePoiReq = new UpdatePoiRequest(poi);
        UpdatePoiRespone updatePoiRes  = wxClient.excute(updatePoiReq);
        System.out.println(updatePoiRes.getBody());
    }

    /**
     * 测试删除门店
     */
    @Test
    public void testDelPoiReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        DelPoiRequest delPoiReq = new DelPoiRequest("33788392");
        DelPoiRespone delPoiRes  = wxClient.excute(delPoiReq);
        System.out.println(delPoiRes.getBody());
    }

    /**
     * 测试查看门店类目表
     */
    @Test
    public void testGetPoiCategoryReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        GetPoiCategoryRequest getPoiCategoryReq = new GetPoiCategoryRequest();
        GetPoiCategoryRespone getPoiCategoryRes = wxClient.excute(getPoiCategoryReq);
        System.out.println(getPoiCategoryRes.getBody());
    }

}
