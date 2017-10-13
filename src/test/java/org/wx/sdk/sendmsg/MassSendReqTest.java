package org.wx.sdk.sendmsg;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import org.wx.sdk.WxClient;
import org.wx.sdk.base.Const;
import org.wx.sdk.token.RedisAccessToken;
import org.wx.sdk.material.request.TempMaterialAddRequest;
import org.wx.sdk.material.request.TempVideoAddRequest;
import org.wx.sdk.material.response.TempMaterialAddRespone;
import org.wx.sdk.material.response.TempVideoAddRespone;
import org.wx.sdk.sendmsg.request.MassSendDeleteRequest;
import org.wx.sdk.sendmsg.request.MassSendGetRequest;
import org.wx.sdk.sendmsg.request.MassSendGroupMpnewsRequest;
import org.wx.sdk.sendmsg.request.MassSendGroupMpvideoRequest;
import org.wx.sdk.sendmsg.request.MassSendOpenidImageRequest;
import org.wx.sdk.sendmsg.request.MassSendOpenidMpnewsRequest;
import org.wx.sdk.sendmsg.request.MassSendOpenidMpvideoRequest;
import org.wx.sdk.sendmsg.request.MassSendOpenidTextRequest;
import org.wx.sdk.sendmsg.request.MassSendOpenidVoiceRequest;
import org.wx.sdk.sendmsg.response.MassSendDeleteRespone;
import org.wx.sdk.sendmsg.response.MassSendGetRespone;
import org.wx.sdk.sendmsg.response.MassSendRespone;

public class MassSendReqTest extends TestCase {

    /**
     * 测试按组群发图文消息(公众号测试号不能按组群发)
     */
    public void testSendMpnewsGroupReq() {
        String mediaId = "HRWLgHPlUO9YReBbhWMfOLyRpGPGBOxfaRmUYGb3l7rDNlw6J6x2GAs_OxM8kRsH";
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        MassSendGroupMpnewsRequest massSendGroupMpnewsReq = new MassSendGroupMpnewsRequest(true, mediaId);
        MassSendRespone massSendRes = wxClient.excute(massSendGroupMpnewsReq);
        System.out.println(massSendRes.getBody());
        //{"errcode":48003,"errmsg":"user not agree mass-send protocol hint: [VeWTtb0059ge14]"}
        assertTrue(massSendRes.getErrcode() == 0);
    }
    
    /**
     * 测试群发视频消息(公众号测试号不能按组群发)
     */
    public void testSendMpvideoGroupReq() {
        //临时视频第一次上传
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        String type = "video";
        String filePath = "D:\\Rocye\\Pictures\\20140423162603.mp4";
        TempMaterialAddRequest tempMaterialAddReq = new TempMaterialAddRequest(type, filePath);
        TempMaterialAddRespone tempMaterialAddRes = wxClient.excute(tempMaterialAddReq);
        System.out.println(tempMaterialAddRes.getBody());
        //{"type":"video","media_id":"rRSbBkcAEsy26ssoyPqV6LWj6lXdxyBbVBhgkLNtTbajbirUuRws7vLn_fg4iyL9","created_at":1474623201}
        
        //临时视频第二次上传
        TempVideoAddRequest tempVideoAddReq = new TempVideoAddRequest(tempMaterialAddRes.getMedia_id(), "测试视频头", "这是一个测试视频！！！");
        TempVideoAddRespone tempVideoAddRes = wxClient.excute(tempVideoAddReq);
        System.out.println(tempVideoAddRes.getBody());
        //{"type":"video","media_id":"LkACLiX0B54bHgEBuOLoDFcD_SVeGbcZyGiGOgOblERyE7AYEz19wSsKtySG9S0-","created_at":1474623202}
        
        //群发视频
        MassSendGroupMpvideoRequest massSendGroupVideoReq = new MassSendGroupMpvideoRequest(true, tempVideoAddRes.getMedia_id());
        MassSendRespone massSendRes = wxClient.excute(massSendGroupVideoReq);
        System.out.println(massSendRes.getBody());
        //{"errcode":48003,"errmsg":"user not agree mass-send protocol hint: [d7HmwA0202age6]"}
        assertTrue(massSendRes.getErrcode() == 0);
    }
    
    /**
     * 测试按Openid群发图文消息
     */
    public void testSendMpnewsOpenidReq() {
        String mediaId = "p0WtXLvOv6LRLNPMYZD7DKJNYe2FHa20A-ifkPMSekw";
        List<String> openidList = new ArrayList<String>(0);
        openidList.add("oFYHLviCatnBPDs1XxcXoOePNows");
        openidList.add("oFYHLvkzNC8P_uZKPS7ppSuHiYwk");
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        MassSendOpenidMpnewsRequest massSendOpenidMpnewsReq = new MassSendOpenidMpnewsRequest(openidList, mediaId);
        MassSendRespone massSendRes = wxClient.excute(massSendOpenidMpnewsReq);
        System.out.println(massSendRes.getBody());
        //{"errcode":0,"errmsg":"send job submission success","msg_id":3147483649,"msg_data_id":2467745313}
        assertTrue(massSendRes.getErrcode() == 0);
    }
    
    /**
     * 测试按Openid群发文本消息
     */
    public void testSendTextOpenidReq() {
        List<String> openidList = new ArrayList<String>(0);
        openidList.add("oFYHLviCatnBPDs1XxcXoOePNows");
        openidList.add("oFYHLvkzNC8P_uZKPS7ppSuHiYwk");
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        MassSendOpenidTextRequest massSendOpenidTextReq = new MassSendOpenidTextRequest(openidList, "针对Openid的测试文本群发");
        MassSendRespone massSendRes = wxClient.excute(massSendOpenidTextReq);
        System.out.println(massSendRes.getBody());
        //{"errcode":0,"errmsg":"send job submission success","msg_id":3147483650}
        assertTrue(massSendRes.getErrcode() == 0);
    }
    
    /**
     * 测试按Openid群发图片消息
     */
    public void testSendImageOpenidReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        TempMaterialAddRequest tempMaterialAddReq = new TempMaterialAddRequest("image", "D:\\Rocye\\Pictures\\325ac5f7da3c46652e5398f4cb223292.jpg");
        TempMaterialAddRespone tempMaterialAddRes = wxClient.excute(tempMaterialAddReq);
        System.out.println(tempMaterialAddRes.getBody());
        
        List<String> openidList = new ArrayList<String>(0);
        openidList.add("oFYHLviCatnBPDs1XxcXoOePNows");
        openidList.add("oFYHLvkzNC8P_uZKPS7ppSuHiYwk");
        
        MassSendOpenidImageRequest massSendOpenidImageReq = new MassSendOpenidImageRequest(openidList, tempMaterialAddRes.getMedia_id());
        MassSendRespone massSendRes = wxClient.excute(massSendOpenidImageReq);
        System.out.println(massSendRes.getBody());
        //{"errcode":0,"errmsg":"send job submission success","msg_id":3147483652}
        assertTrue(massSendRes.getErrcode() == 0);
    }
    
    /**
     * 测试按Openid群发音频消息
     */
    public void testSendVoiceOpenidReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        TempMaterialAddRequest tempMaterialAddReq = new TempMaterialAddRequest("voice", "D:\\Rocye\\Pictures\\1444288195077.mp3");
        TempMaterialAddRespone tempMaterialAddRes = wxClient.excute(tempMaterialAddReq);
        System.out.println(tempMaterialAddRes.getBody());
        
        List<String> openidList = new ArrayList<String>(0);
        openidList.add("oFYHLviCatnBPDs1XxcXoOePNows");
        openidList.add("oFYHLvkzNC8P_uZKPS7ppSuHiYwk");
        
        MassSendOpenidVoiceRequest massSendOpenidVoiceReq = new MassSendOpenidVoiceRequest(openidList, tempMaterialAddRes.getMedia_id());
        MassSendRespone massSendRes = wxClient.excute(massSendOpenidVoiceReq);
        System.out.println(massSendRes.getBody());
        //{"errcode":0,"errmsg":"send job submission success","msg_id":3147483654}
        assertTrue(massSendRes.getErrcode() == 0);
    }
    
    /**
     * 测试按Openid群发视频消息(发送成功，但是点击卡片报“参数错误”)
     */
    public void testSendMpvideoOpenidReq() {
        //临时视频第一次上传
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        String type = "video";
        String filePath = "D:\\Rocye\\Pictures\\20140423162603.mp4";
        TempMaterialAddRequest tempMaterialAddReq = new TempMaterialAddRequest(type, filePath);
        TempMaterialAddRespone tempMaterialAddRes = wxClient.excute(tempMaterialAddReq);
        System.out.println(tempMaterialAddRes.getBody());
        //{"type":"video","media_id":"rRSbBkcAEsy26ssoyPqV6LWj6lXdxyBbVBhgkLNtTbajbirUuRws7vLn_fg4iyL9","created_at":1474623201}
        
        //临时视频第二次上传
        TempVideoAddRequest tempVideoAddReq = new TempVideoAddRequest(tempMaterialAddRes.getMedia_id(), "测试视频头", "这是一个测试视频！！！");
        TempVideoAddRespone tempVideoAddRes = wxClient.excute(tempVideoAddReq);
        System.out.println(tempVideoAddRes.getBody());
        //{"type":"video","media_id":"LkACLiX0B54bHgEBuOLoDFcD_SVeGbcZyGiGOgOblERyE7AYEz19wSsKtySG9S0-","created_at":1474623202}
        
        List<String> openidList = new ArrayList<String>(0);
        openidList.add("oFYHLviCatnBPDs1XxcXoOePNows");
        openidList.add("oFYHLvkzNC8P_uZKPS7ppSuHiYwk");
        
        //群发视频
        MassSendOpenidMpvideoRequest massSendOpenidMpvideoReq = new MassSendOpenidMpvideoRequest(openidList, tempVideoAddRes.getMedia_id());
        MassSendRespone massSendRes = wxClient.excute(massSendOpenidMpvideoReq);
        System.out.println(massSendRes.getBody());
        //{"errcode":0,"errmsg":"send job submission success","msg_id":3147483655}
        assertTrue(massSendRes.getErrcode() == 0);
    }
    
    /**
     * 测试群发视频消息的删除接口
     */
    public void testSendDeleteReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        MassSendDeleteRequest massSendDeleteReq = new MassSendDeleteRequest(3147483655L);
        MassSendDeleteRespone massSendDeleteRes = wxClient.excute(massSendDeleteReq);
        System.out.println(massSendDeleteRes.getBody());
        assertTrue(massSendDeleteRes.getErrcode() == 0);
    }
    
    /**
     * 测试获取群发视频消息的发送状态接口
     */
    public void testSendGetReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        MassSendGetRequest massSendGetReq = new MassSendGetRequest(3147483655L);
        MassSendGetRespone massSendGetRes = wxClient.excute(massSendGetReq);
        System.out.println(massSendGetRes.getBody());
        //{"msg_id":3147483655,"msg_status":"SEND_SUCCESS"}
        assertTrue(massSendGetRes.getErrcode() == 0);
    }
    
}
