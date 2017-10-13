package org.wx.sdk.base;

import org.junit.Test;
import org.wx.sdk.WxClient;
import org.wx.sdk.base.request.IpListGetRequest;
import org.wx.sdk.base.response.IpListGetRespone;
import org.wx.sdk.token.RedisAccessToken;

public class IpListGetReqTest {
    
    /**
     * 测试IpListGet和AccessTokenGet
     */
    @Test
    public void testIpListGetReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        IpListGetRequest ipListGetReq = new IpListGetRequest();
        IpListGetRespone ipListGetRes = wxClient.excute(ipListGetReq);
        System.out.println(ipListGetRes.getBody());
    }
}
