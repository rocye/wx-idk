package org.wx.sdk.base;

import org.junit.Test;
import org.wx.sdk.ticket.RedisJsApiTicket;

public class WxTicketGetReqTest {
    
    /**
     * 测试获取WxConfig
     */
    @Test
    public void testWxConfigGetReq() {
    	String url = "http://w.weiyihui.com.cn/wxproj/wx/userTag/ooYY4wZhV4WAz7Ut61QXtNsts5sw";
        WxConfig config = RedisJsApiTicket.getInstance().getWxConfig(Const.APPID, Const.APPSERCT, url);
        System.out.println(config);
    }
}
