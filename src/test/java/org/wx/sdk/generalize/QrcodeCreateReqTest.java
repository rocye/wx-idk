package org.wx.sdk.generalize;

import org.junit.Test;
import org.wx.sdk.WxClient;
import org.wx.sdk.base.Const;
import org.wx.sdk.generalize.request.QrcodeCreateRequest;
import org.wx.sdk.generalize.request.ShowQrcodeRequest;
import org.wx.sdk.generalize.response.QrcodeCreateRespone;
import org.wx.sdk.generalize.response.ShowQrcodeRespone;
import org.wx.sdk.token.RedisAccessToken;

public class QrcodeCreateReqTest {
    
    /**
     * 测试生成字符串临时二维码
     */
    @Test
    public void testTempQrStrCreateReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        QrcodeCreateRequest tempQrCreateReq = QrcodeCreateRequest.getTempQrStrScene("abc", 10000L);
        QrcodeCreateRespone tempQrCreateRes = wxClient.excute(tempQrCreateReq);
        System.out.println(tempQrCreateRes.getBody());
        
        String ticket = tempQrCreateRes.getTicket();
        ShowQrcodeRequest showQrcodeReq = new ShowQrcodeRequest(ticket, "D:/Rocye/Pictures/x.jpg");
        ShowQrcodeRespone showQrcodeRes = wxClient.excute(showQrcodeReq);
        System.out.println(showQrcodeRes.getBody());
    }
    
    /**
     * 测试生成数字临时二维码
     */
    @Test
    public void testTempQrCreateReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        QrcodeCreateRequest tempQrCreateReq = QrcodeCreateRequest.getTempQrScene(123, 10000L);
        QrcodeCreateRespone tempQrCreateRes = wxClient.excute(tempQrCreateReq);
        System.out.println(tempQrCreateRes.getBody());
        
        String ticket = tempQrCreateRes.getTicket();
        ShowQrcodeRequest showQrcodeReq = new ShowQrcodeRequest(ticket, "D:/Rocye/Pictures/y.jpg");
        ShowQrcodeRespone showQrcodeRes = wxClient.excute(showQrcodeReq);
        System.out.println(showQrcodeRes.getBody());
    }
    
    /**
     * 测试生成字符串永久二维码
     */
    @Test
    public void testLimitQrStrCreateReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        QrcodeCreateRequest tempQrCreateReq = QrcodeCreateRequest.getLimitQrStrScene("def");
        QrcodeCreateRespone tempQrCreateRes = wxClient.excute(tempQrCreateReq);
        System.out.println(tempQrCreateRes.getBody());
        
        String ticket = tempQrCreateRes.getTicket();
        ShowQrcodeRequest showQrcodeReq = new ShowQrcodeRequest(ticket, "D:/Rocye/Pictures/xx.jpg");
        ShowQrcodeRespone showQrcodeRes = wxClient.excute(showQrcodeReq);
        System.out.println(showQrcodeRes.getBody());
    }
    
    /**
     * 测试生成数字永久二维码
     */
    @Test
    public void testLimitQrCreateReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        QrcodeCreateRequest tempQrCreateReq = QrcodeCreateRequest.getLimitQrScene(456);
        QrcodeCreateRespone tempQrCreateRes = wxClient.excute(tempQrCreateReq);
        System.out.println(tempQrCreateRes.getBody());
        
        String ticket = tempQrCreateRes.getTicket();
        ShowQrcodeRequest showQrcodeReq = new ShowQrcodeRequest(ticket, "D:/Rocye/Pictures/yy.jpg");
        ShowQrcodeRespone showQrcodeRes = wxClient.excute(showQrcodeReq);
        System.out.println(showQrcodeRes.getBody());
    }
    
}
