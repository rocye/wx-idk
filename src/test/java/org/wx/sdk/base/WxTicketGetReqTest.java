package org.wx.sdk.base;

import org.junit.Test;
import org.wx.sdk.ticket.RedisJsApiTicket;

public class WxTicketGetReqTest {
    
    /**
     * 测试获取WxConfig
     */
    @Test
    public void testWxConfigGetReq() {
    	String url = "http://blog.rocye.cn";
        WxConfig config = RedisJsApiTicket.getInstance().getWxConfig(Const.APPID, Const.APPSERCT, url);
        System.out.println(config);
    }
}
