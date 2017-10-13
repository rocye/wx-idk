package org.wx.sdk.sendmsg;

import org.junit.Test;
import org.wx.sdk.WxClient;
import org.wx.sdk.base.Const;
import org.wx.sdk.token.RedisAccessToken;
import org.wx.sdk.sendmsg.request.KfSendImageRequest;
import org.wx.sdk.sendmsg.request.KfSendMpnewsRequest;
import org.wx.sdk.sendmsg.request.KfSendTextRequest;
import org.wx.sdk.sendmsg.request.KfSendVideoRequest;
import org.wx.sdk.sendmsg.request.KfSendVoiceRequest;
import org.wx.sdk.sendmsg.response.KfSendRespone;

public class KfSendReqTest {

    /**
     * 测试发送文本消息
     */
    @Test
    public void testSendTextReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        KfSendTextRequest kfSendTextReq = new KfSendTextRequest(Const.OPENID, "你好吗？");
        KfSendRespone kfSendRes  = wxClient.excute(kfSendTextReq);
        System.out.println(kfSendRes.getBody());
    }
    
    /**
     * 测试发送图片消息
     */
    @Test
    public void testSendImageReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        //https://mmbiz.qlogo.cn/mmbiz/TPynjoavL0NNWBsqCiaOygXIAibTcHHahuoZj1ibWyicywSzTaVAr2IwPolS6acgZZ1BoGbEeVxF5haTkamaex1Emg/0?wx_fmt=png
        String media_id = "p0WtXLvOv6LRLNPMYZD7DHGgqvIkVktRJrwg2ewlPm0";  //永久
        //String media_id = "K8bs_rgIYeCmxv1RK8BZB9ZY_WphXAf7L24rYiQFYesX37PboUarJIDSC_1w4CMM";   //临时
        KfSendImageRequest kfSendImageReq = new KfSendImageRequest(Const.OPENID, media_id);
        KfSendRespone kfSendRes = wxClient.excute(kfSendImageReq);
        System.out.println(kfSendRes.getBody());
    }
    
    /**
     * 测试发送音频消息
     */
    @Test
    public void testSendVoiceReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        //String media_id = "ExBhEVpr7GnE8qi5O6jG9mFMbatTM5M8N1jSlGLD8hFLXD-D_DnRndNT310dsTiw";   //临时
        String media_id = "p0WtXLvOv6LRLNPMYZD7DHioV-fQZ-WGXMm7WUeiJSA";  //永久
        KfSendVoiceRequest kfSendVoiceReq = new KfSendVoiceRequest(Const.OPENID, media_id);
        KfSendRespone kfSendRes = wxClient.excute(kfSendVoiceReq);
        System.out.println(kfSendRes.getBody());
    }
    
    /**
     * 测试发送视频消息
     */
    @Test
    public void testSendVideoReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        //String media_id = "OSyj7a8_Q7L2-51G0oOBP49CAmcqvxxK1vMQZ8r8lWz3J2A35BzyHxwptjgkzEF4";  //临时
        String media_id = "p0WtXLvOv6LRLNPMYZD7DCgY0TeodDAXyQiJS22kOw0";  //永久
        String thumb_media_id = "p0WtXLvOv6LRLNPMYZD7DG02HGlHyAaJBpRbN41gZWw";
        KfSendVideoRequest kfSendVideoReq = new KfSendVideoRequest(Const.OPENID, media_id, thumb_media_id, "you懂的", "fact i 不懂");
        KfSendRespone kfSendRes = wxClient.excute(kfSendVideoReq);
        System.out.println(kfSendRes.getBody());
    }
    
    /**
     * 测试发送永久图文（点击跳转到图文消息页面）消息
     */
    @Test
    public void testSendMpnewsReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        String media_id = "p0WtXLvOv6LRLNPMYZD7DOrpzHgIEbaDkATUW9pWeuQ";
        KfSendMpnewsRequest kfSendMpnewsReq = new KfSendMpnewsRequest(Const.OPENID, media_id);
        KfSendRespone kfSendRes = wxClient.excute(kfSendMpnewsReq);
        System.out.println(kfSendRes.getBody());
    }
}
