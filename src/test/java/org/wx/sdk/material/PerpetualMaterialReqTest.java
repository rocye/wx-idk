package org.wx.sdk.material;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.wx.sdk.WxClient;
import org.wx.sdk.base.Const;
import org.wx.sdk.token.RedisAccessToken;
import org.wx.sdk.material.object.News;
import org.wx.sdk.material.request.NewsAddRequest;
import org.wx.sdk.material.request.NewsBatGetRequest;
import org.wx.sdk.material.request.NewsGetRequest;
import org.wx.sdk.material.request.NewsInnerImgAddRequest;
import org.wx.sdk.material.request.NewsUpdateRequest;
import org.wx.sdk.material.request.PerpetualMaterialAddRequest;
import org.wx.sdk.material.request.PerpetualMaterialBatGetRequest;
import org.wx.sdk.material.request.PerpetualMaterialCountRequest;
import org.wx.sdk.material.request.PerpetualMaterialDelRequest;
import org.wx.sdk.material.request.PerpetualMediaGetRequest;
import org.wx.sdk.material.request.PerpetualVideoGetRequest;
import org.wx.sdk.material.response.NewsAddRespone;
import org.wx.sdk.material.response.NewsBatGetRespone;
import org.wx.sdk.material.response.NewsGetRespone;
import org.wx.sdk.material.response.NewsInnerImgAddRespone;
import org.wx.sdk.material.response.NewsUpdateRespone;
import org.wx.sdk.material.response.PerpetualMaterialAddRespone;
import org.wx.sdk.material.response.PerpetualMaterialBatGetRespone;
import org.wx.sdk.material.response.PerpetualMaterialCountRespone;
import org.wx.sdk.material.response.PerpetualMaterialDelRespone;
import org.wx.sdk.material.response.PerpetualMediaGetRespone;
import org.wx.sdk.material.response.PerpetualVideoGetRespone;

public class PerpetualMaterialReqTest {
    
    /**
     * 测试添加永久图文素材
     */
    @Test
    public void testNewsAddReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        
        PerpetualMaterialAddRequest materialAddReq = new PerpetualMaterialAddRequest("thumb", "D:/Rocye/Pictures/460.jpg");
        PerpetualMaterialAddRespone materialAddRes = wxClient.excute(materialAddReq);
        System.out.println(materialAddRes.getBody());
        String thumbMediaId = materialAddRes.getMedia_id();
        
        NewsInnerImgAddRequest innerImgAddReq = new NewsInnerImgAddRequest("D:/Rocye/Pictures/11.png");
        NewsInnerImgAddRespone innerImgAddRes = wxClient.excute(innerImgAddReq);
        System.out.println(innerImgAddRes.getBody());
        String img = innerImgAddRes.getUrl();
        
        List<News> newsList = new ArrayList<News>(0);
        newsList.add(new News("测试单图文", thumbMediaId, "Rocye", "测试而已", (short)1, "这只是一个测试<img src=\""+ img +"\"/>", "http://www.baidu.com"));
        NewsAddRequest newsAddReq = new NewsAddRequest(newsList);
        NewsAddRespone newsAddRes = wxClient.excute(newsAddReq);
        System.out.println(newsAddRes.getBody());
    }
    
    /**
     * 测试获取永久图文素材
     */
    @Test
    public void testNewsGetReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        String mediaId = "p0WtXLvOv6LRLNPMYZD7DKJNYe2FHa20A-ifkPMSekw";
        NewsGetRequest newsGetReq = new NewsGetRequest(mediaId); 
        NewsGetRespone newsGetRes = wxClient.excute(newsGetReq);
        //{"news_item":[{"title":"测试单图文","author":"Rocye","digest":"测试而已","content":"这只是一个测试<img src=\"http:\/\/mmbiz.qpic.cn\/mmbiz\/TPynjoavL0NibKmF3eaIMeFhUu0zicAQaTAVB3t5y9INNz14KIcRIufcibx95x9V8tX5iawpMrsaFnJIoZaXaWibVaA\/0\"  \/>","content_source_url":"http:\/\/www.baidu.com","thumb_media_id":"p0WtXLvOv6LRLNPMYZD7DImcPfqg5vS186BVbZWvi6E","show_cover_pic":1,"url":"http:\/\/mp.weixin.qq.com\/s?__biz=MzIwMTAwNzg5Mw==&mid=320261643&idx=1&sn=540b71872b209cbeeb68a82271a2d5f2#rd","thumb_url":"http:\/\/mmbiz.qpic.cn\/mmbiz\/TPynjoavL0NibKmF3eaIMeFhUu0zicAQaTEcTXtv1VKzQeHES1sYia8t2jHgXGJJEfp7pe3Jgl294eYicYpA28bCpg\/0?wx_fmt=jpeg"}],"create_time":1460961939,"update_time":1460961939}
        System.out.println(newsGetRes.getBody());
        System.out.println(newsGetRes.getNews_item().get(0).getUrl());
    }

    /**
     * 测试添加永久媒体素材
     */
    @Test
    public void testPerpetualMediaAddReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        
        int typ = 1;
        String type = "image";
        String filePath = "D:/Rocye/Pictures/11.png";    //p0WtXLvOv6LRLNPMYZD7DAKNt6S98GgG1W30iHvejhM   ,  http://mmbiz.qpic.cn/mmbiz_png/TPynjoavL0NgcKc2OtZM8lGawuYO7JlHsuZ5kjbMfkJeW1Iych7Hria4O2sO70ibY8dKVPxn0HcI7pN01FgrleRA/0?wx_fmt=png
        if(typ == 2){
            type = "voice";
            filePath = "D:/Rocye/Pictures/1444288195077.mp3";
        }else if(typ == 3){
            type = "video";
            filePath = "D:/Rocye/Pictures/20140423162603.mp4";
        }else if(typ == 4){
            type = "thumb";
            filePath = "D:/Rocye/Pictures/desk3.jpg";      //p0WtXLvOv6LRLNPMYZD7DAOWHfVy5LmkVFsLV1Cm8FE
        }
        PerpetualMaterialAddRequest perpetualMaterialAddReq = null;
        if(type.equals("video")){
            perpetualMaterialAddReq = new PerpetualMaterialAddRequest(type, filePath, "你懂的", "其实我不懂");
        }else{
            perpetualMaterialAddReq = new PerpetualMaterialAddRequest(type, filePath);
        }
        PerpetualMaterialAddRespone perpetualMaterialAddRes = wxClient.excute(perpetualMaterialAddReq);
        System.out.println(perpetualMaterialAddRes.getBody());
        System.out.println(perpetualMaterialAddRes.getUrl());
    }
    
    /**
     * 测试获取永久图片、缩略图、音频素材
     */
    @Test
    public void testPerpetualMediaGetReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        String mediaId = "p0WtXLvOv6LRLNPMYZD7DAKNt6S98GgG1W30iHvejhM";   //png
        //String mediaId = "p0WtXLvOv6LRLNPMYZD7DHioV-fQZ-WGXMm7WUeiJSA";     //mp3
        //String mediaId = "p0WtXLvOv6LRLNPMYZD7DLv7M1fjtuJpGFE_GEvq3co";     //png deleted
        String filePath = "D:/Rocye/Pictures/"+ System.currentTimeMillis() +".png";
        PerpetualMediaGetRequest mediaGetReq = new PerpetualMediaGetRequest(mediaId, filePath);
        PerpetualMediaGetRespone mediaGetRes = wxClient.excute(mediaGetReq);
        System.out.println(mediaGetRes.getBody());
    }
    
    /**
     * 测试获取永久视频素材
     */
    @Test
    public void testPerpetualVideoGetReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        String mediaId = "p0WtXLvOv6LRLNPMYZD7DCgY0TeodDAXyQiJS22kOw0";
        PerpetualVideoGetRequest videoGetReq = new PerpetualVideoGetRequest(mediaId);
        PerpetualVideoGetRespone videoGetRes = wxClient.excute(videoGetReq);
        //{"title":"你懂的","description":"其实我不懂","down_url":"http:\/\/103.7.28.67\/vweixinp.tc.qq.com\/1007_9760ea22cd784dcca8271a2844fac313.f10.mp4?vkey=4C028CE3E3583FD96E609EE350B12916728DE7FE7E11402780F110AC09F51C38E191C1158F8B8024&sha=0&save=1"}
        System.out.println(videoGetRes.getBody());
        System.out.println(videoGetRes.getDown_url());
    }
    
    /**
     * 测试删除永久图片素材
     */
    @Test
    public void testPerpetualMaterialDelReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        String mediaId = "p0WtXLvOv6LRLNPMYZD7DLv7M1fjtuJpGFE_GEvq3co";
        PerpetualMaterialDelRequest mediaDelReq = new PerpetualMaterialDelRequest(mediaId);
        PerpetualMaterialDelRespone mediaDelRes = wxClient.excute(mediaDelReq);
        System.out.println(mediaDelRes.getBody());
    }
    
    /**
     * 测试修改永久图文素材
     */
    @Test
    public void testNewsUpdateReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        String mediaId = "p0WtXLvOv6LRLNPMYZD7DOrpzHgIEbaDkATUW9pWeuQ";
        String thumbMediaId = "p0WtXLvOv6LRLNPMYZD7DAOWHfVy5LmkVFsLV1Cm8FE";
        String img = "http://mmbiz.qpic.cn/mmbiz/TPynjoavL0NibKmF3eaIMeFhUu0zicAQaTAVB3t5y9INNz14KIcRIufcibx95x9V8tX5iawpMrsaFnJIoZaXaWibVaA/0";
        News article = new News("测试单图文改", thumbMediaId, "Rocye头", "测试而已改", (short)1, "这只是一个测试<img src=\""+ img +"\"/>", "http://www.baidu.com");
        NewsUpdateRequest newsUpdateReq = new NewsUpdateRequest(mediaId, 0, article);
        NewsUpdateRespone newsUpdateRes = wxClient.excute(newsUpdateReq);
        System.out.println(newsUpdateRes.getBody());
    }
    
    /**
     * 测试获取永久素材数量
     */
    @Test
    public void testPerpetualMaterialCountReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        PerpetualMaterialCountRequest mediaDelReq = new PerpetualMaterialCountRequest();
        PerpetualMaterialCountRespone mediaDelRes = wxClient.excute(mediaDelReq);
        System.out.println(mediaDelRes.getBody());
    }
    
    /**
     * 测试批量获取永久图文素材列表
     */
    @Test
    public void testNewsBatGetReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        NewsBatGetRequest newsBatGetReq = new NewsBatGetRequest(0, 10);
        NewsBatGetRespone newsBatGetRes = wxClient.excute(newsBatGetReq);
        System.out.println(newsBatGetRes.getBody());
    }
    
    /**
     * 测试批量获取永久其它类型（图片、语音、视频）素材列表
     */
    @Test
    public void testPerpetualMaterialBatGetReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        PerpetualMaterialBatGetRequest materialBatGetReq = new PerpetualMaterialBatGetRequest("image", 0, 10);
        PerpetualMaterialBatGetRespone materialBatGetRes = wxClient.excute(materialBatGetReq);
        System.out.println(materialBatGetRes.getBody());
    }
    
}
