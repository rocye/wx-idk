package org.wx.sdk.generalize;

import org.junit.Test;
import org.wx.sdk.WxClient;
import org.wx.sdk.base.Const;
import org.wx.sdk.token.RedisAccessToken;
import org.wx.sdk.generalize.request.Long2ShortUrlRequest;
import org.wx.sdk.generalize.response.Long2ShortUrlRespone;

public class IpListGetReqTest {
    
    /**
     * 测试将一条长链接转成短链接
     */
    @Test
    public void testIpListGetReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        Long2ShortUrlRequest long2ShortUrlReq = new Long2ShortUrlRequest("http://mp.weixin.qq.com/s?__biz=MzA5ODAyNDgzMQ==&mid=503045723&idx=1&sn=84cb54a1d7035fe26319b9577ce96f5a&scene=0#wechat_redirect");
        Long2ShortUrlRespone long2ShortUrlRes = wxClient.excute(long2ShortUrlReq);
        System.out.println(long2ShortUrlRes.getBody());
        //{"errcode":0,"errmsg":"ok","short_url":"http:\/\/w.url.cn\/s\/AnKJjUL"}
        System.out.println(long2ShortUrlRes.getShort_url());
        //http://w.url.cn/s/A0mvbo1
    }
}
