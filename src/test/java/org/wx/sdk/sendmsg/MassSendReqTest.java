package org.wx.sdk.sendmsg;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.wx.sdk.WxClient;
import org.wx.sdk.base.Const;
import org.wx.sdk.sendmsg.request.*;
import org.wx.sdk.sendmsg.response.*;
import org.wx.sdk.token.RedisAccessToken;
import org.wx.sdk.material.request.TempMaterialAddRequest;
import org.wx.sdk.material.request.TempVideoAddRequest;
import org.wx.sdk.material.response.TempMaterialAddRespone;
import org.wx.sdk.material.response.TempVideoAddRespone;

public class MassSendReqTest {

    /**
     * 测试按组群发图文消息(公众号测试号不能按组群发)
     */
    @Test
    public void testSendMpnewsGroupReq() {
        String mediaId = "HRWLgHPlUO9YReBbhWMfOLyRpGPGBOxfaRmUYGb3l7rDNlw6J6x2GAs_OxM8kRsH";
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        MassSendTagMpnewsRequest massSendTagMpnewsReq = new MassSendTagMpnewsRequest(true, mediaId);
        MassSendRespone massSendRes = wxClient.excute(massSendTagMpnewsReq);
        System.out.println(massSendRes.getBody());
        //{"errcode":48003,"errmsg":"user not agree mass-send protocol hint: [VeWTtb0059ge14]"}
    }
    
    /**
     * 测试群发视频消息(公众号测试号不能按组群发)
     */
    @Test
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
        MassSendTagMpvideoRequest massSendTagVideoReq = new MassSendTagMpvideoRequest(true, tempVideoAddRes.getMedia_id());
        MassSendRespone massSendRes = wxClient.excute(massSendTagVideoReq);
        System.out.println(massSendRes.getBody());
        //{"errcode":48003,"errmsg":"user not agree mass-send protocol hint: [d7HmwA0202age6]"}
    }
    
    /**
     * 测试按Openid群发图文消息
     */
    @Test
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
    }
    
    /**
     * 测试按Openid群发文本消息
     */
    @Test
    public void testSendTextOpenidReq() {
        List<String> openidList = new ArrayList<String>(0);
        openidList.add("oFYHLviCatnBPDs1XxcXoOePNows");
        openidList.add("oFYHLvkzNC8P_uZKPS7ppSuHiYwk");
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        MassSendOpenidTextRequest massSendOpenidTextReq = new MassSendOpenidTextRequest(openidList, "针对Openid的测试文本群发");
        MassSendRespone massSendRes = wxClient.excute(massSendOpenidTextReq);
        System.out.println(massSendRes.getBody());
        //{"errcode":0,"errmsg":"send job submission success","msg_id":3147483650}
    }
    
    /**
     * 测试按Openid群发图片消息
     */
    @Test
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
    }
    
    /**
     * 测试按Openid群发音频消息
     */
    @Test
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
    }
    
    /**
     * 测试按Openid群发视频消息(发送成功，但是点击卡片报“参数错误”)
     */
    @Test
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
    }
    
    /**
     * 测试群发视频消息的删除接口
     */
    @Test
    public void testSendDeleteReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        MassSendDeleteRequest massSendDeleteReq = new MassSendDeleteRequest(3147483655L);
        MassSendDeleteRespone massSendDeleteRes = wxClient.excute(massSendDeleteReq);
        System.out.println(massSendDeleteRes.getBody());
    }
    
    /**
     * 测试获取群发视频消息的发送状态接口
     */
    @Test
    public void testSendGetReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        MassSendGetRequest massSendGetReq = new MassSendGetRequest(3147483655L);
        MassSendGetRespone massSendGetRes = wxClient.excute(massSendGetReq);
        System.out.println(massSendGetRes.getBody());
        //{"msg_id":3147483655,"msg_status":"SEND_SUCCESS"}
    }

	/**
	 * 测试获取群发速度接口
	 */
	@Test
	public void testSpeedGetReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		MassSpeedGetRequest massSpeedGetReq = new MassSpeedGetRequest();
		MassSpeedGetRespone massSpeedRes = wxClient.excute(massSpeedGetReq);
		System.out.println(massSpeedRes.getBody());
	}

	/**
	 * 测试设置群发速度接口
	 */
	@Test
	public void testSpeedetReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		MassSpeedSetRequest massSpeedSetReq = new MassSpeedSetRequest(2);
		MassSpeedSetRespone massSpeedSetRes = wxClient.excute(massSpeedSetReq);
		System.out.println(massSpeedSetRes.getBody());
	}

	/**
	 * 测试按Openid群发卡券消息
	 */
	@Test
	public void testSendOpenidReq() {
		List<String> openidList = new ArrayList<String>(0);
		openidList.add("oFYHLviCatnBPDs1XxcXoOePNows");
		openidList.add("oFYHLvkzNC8P_uZKPS7ppSuHiYwk");
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		MassSendOpenidWxcardRequest massSendOpenidWxcardReq = new MassSendOpenidWxcardRequest(openidList, "pFYHLvlpbLoaHpnguo6_COiV8Wy0");
		MassSendRespone massSendRes = wxClient.excute(massSendOpenidWxcardReq);
		System.out.println(massSendRes.getBody());
	}
    
}
