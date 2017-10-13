package org.wx.sdk.sendmsg;

import org.junit.Test;
import org.wx.sdk.WxClient;
import org.wx.sdk.base.Const;
import org.wx.sdk.token.RedisAccessToken;
import org.wx.sdk.material.request.TempMaterialAddRequest;
import org.wx.sdk.material.request.TempVideoAddRequest;
import org.wx.sdk.material.response.TempMaterialAddRespone;
import org.wx.sdk.material.response.TempVideoAddRespone;
import org.wx.sdk.sendmsg.object.CardExt;
import org.wx.sdk.sendmsg.request.MassPreviewImageRequest;
import org.wx.sdk.sendmsg.request.MassPreviewMpnewsRequest;
import org.wx.sdk.sendmsg.request.MassPreviewMpvideoRequest;
import org.wx.sdk.sendmsg.request.MassPreviewTextRequest;
import org.wx.sdk.sendmsg.request.MassPreviewVoiceRequest;
import org.wx.sdk.sendmsg.request.MassPreviewWxcardRequest;
import org.wx.sdk.sendmsg.response.MassPreviewRespone;

public class MassPreviewReqTest {

    /**
     * 预览群发图文消息
     */
    @Test
    public void testPreviewMpnewsReq() {
        String mediaId = "2p3c00r856veThe7hDsedO46AwAZdoxkAitlGYnnb7g4JQFN4Gikc7UlJgn6-iBz";
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        //MassPreviewMpnewsRequest massPreviewMpnewsReq = new MassPreviewMpnewsRequest.Builder(mediaId).touser("oFYHLviCatnBPDs1XxcXoOePNows").build();
        MassPreviewMpnewsRequest massPreviewMpnewsReq = new MassPreviewMpnewsRequest.Builder(mediaId).towxname("hirocye").build();
        MassPreviewRespone massPreviewRes = wxClient.excute(massPreviewMpnewsReq);
        System.out.println(massPreviewRes.getBody());
        //{"errcode":0,"errmsg":"preview success"}
    }
    
    /**
     * 预览群发文本消息
     */
    @Test
    public void testPreviewTextReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        //MassPreviewTextRequest massPreviewTextReq = new MassPreviewTextRequest("预览群发文本....").touser("oFYHLviCatnBPDs1XxcXoOePNows").build();
        MassPreviewTextRequest massPreviewTextReq = new MassPreviewTextRequest.Builder("预览群发文本....").towxname("hirocye").build();
        MassPreviewRespone massPreviewRes = wxClient.excute(massPreviewTextReq);
        System.out.println(massPreviewRes.getBody());
        //{"errcode":0,"errmsg":"preview success"}
    }
    
    /**
     * 预览群发图片消息
     */
    @Test
    public void testPreviewImageReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        TempMaterialAddRequest tempMaterialAddReq = new TempMaterialAddRequest("image", "D:\\Rocye\\Pictures\\325ac5f7da3c46652e5398f4cb223292.jpg");
        TempMaterialAddRespone tempMaterialAddRes = wxClient.excute(tempMaterialAddReq);
        System.out.println(tempMaterialAddRes.getBody());
        
        //MassPreviewImageRequest massPreviewImageReq = new MassPreviewImageRequest.Builder(tempMaterialAddRes.getMedia_id()).touser("oFYHLviCatnBPDs1XxcXoOePNows").build();
        MassPreviewImageRequest massPreviewImageReq = new MassPreviewImageRequest.Builder(tempMaterialAddRes.getMedia_id()).towxname("hirocye").build();
        MassPreviewRespone massPreviewRes = wxClient.excute(massPreviewImageReq);
        System.out.println(massPreviewRes.getBody());
        //{"errcode":0,"errmsg":"preview success"}
    }
    
    /**
     * 预览群发音频消息
     */
    @Test
    public void testPreviewVoiceReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        TempMaterialAddRequest tempMaterialAddReq = new TempMaterialAddRequest("voice", "D:\\Rocye\\Pictures\\1444288195077.mp3");
        TempMaterialAddRespone tempMaterialAddRes = wxClient.excute(tempMaterialAddReq);
        System.out.println(tempMaterialAddRes.getBody());
        
        //MassPreviewVoiceRequest massPreviewVoiceReq = new MassPreviewVoiceRequest.Builder(tempMaterialAddRes.getMedia_id()).touser("oFYHLviCatnBPDs1XxcXoOePNows").build();
        MassPreviewVoiceRequest massPreviewVoiceReq = new MassPreviewVoiceRequest.Builder(tempMaterialAddRes.getMedia_id()).towxname("hirocye").build();
        MassPreviewRespone massPreviewRes = wxClient.excute(massPreviewVoiceReq);
        System.out.println(massPreviewRes.getBody());
        //{"errcode":0,"errmsg":"preview success"}
    }
    
    /**
     * 预览群发视频消息(发送成功，但是点击卡片报“参数错误”)
     */
    @Test
    public void testPreviewMpvideoReq() {
        //临时视频第一次上传
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        String type = "video";
        String filePath = "D:\\Rocye\\Pictures\\20140423162603.mp4";
        TempMaterialAddRequest tempMaterialAddReq = new TempMaterialAddRequest(type, filePath);
        TempMaterialAddRespone tempMaterialAddRes = wxClient.excute(tempMaterialAddReq);
        System.out.println(tempMaterialAddRes.getBody());
        //{"type":"video","media_id":"Gey_3Gs8Aqv_dpcEyfGLrAcMlfOvHpyIgr5eDjsi-qMbUGH_x51crazzNEkCLPtP","created_at":1475226540}
        
        //临时视频第二次上传
        TempVideoAddRequest tempVideoAddReq = new TempVideoAddRequest(tempMaterialAddRes.getMedia_id(), "测试视频头", "这是一个测试视频！！！");
        TempVideoAddRespone tempVideoAddRes = wxClient.excute(tempVideoAddReq);
        System.out.println(tempVideoAddRes.getBody());
        //{"type":"video","media_id":"bVCkA7zXD8Spe5QfIrjQ_YZ8CCbBB3bIXehffYV6UwZBysr4tmMJeevDz_MhrSnt","created_at":1475226540}
        
        //MassPreviewMpvideoRequest massPreviewVideoReq = new MassPreviewMpvideoRequest.Builder(tempVideoAddRes.getMedia_id()).touser("oFYHLviCatnBPDs1XxcXoOePNows").build();
        MassPreviewMpvideoRequest massPreviewVideoReq = new MassPreviewMpvideoRequest.Builder(tempVideoAddRes.getMedia_id()).towxname("hirocye").build();
        MassPreviewRespone massPreviewRes = wxClient.excute(massPreviewVideoReq);
        System.out.println(massPreviewRes.getBody());
        //{"errcode":0,"errmsg":"preview success"}
    }
    
    /**
     * 预览群发卡券消息(无法测试)
     */
    @Test
    public void testPreviewWxcardReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        //MassPreviewWxcardRequest massPreviewWxcardReq = new MassPreviewWxcardRequest.Builder("123dsdajkasd231jhksad", new CardExt("", "oFYHLviCatnBPDs1XxcXoOePNows", 1402057159L, "017bb17407c8e0058a66d72dcc61632b70f511ad")).touser("oFYHLviCatnBPDs1XxcXoOePNows").build();
        MassPreviewWxcardRequest massPreviewWxcardReq = new MassPreviewWxcardRequest.Builder("123dsdajkasd231jhksad", new CardExt("", "oFYHLviCatnBPDs1XxcXoOePNows", 1402057159L, "017bb17407c8e0058a66d72dcc61632b70f511ad")).towxname("hirocye").build();
        MassPreviewRespone massPreviewRes = wxClient.excute(massPreviewWxcardReq);
        System.out.println(massPreviewRes.getBody());
    }
    
    
}
