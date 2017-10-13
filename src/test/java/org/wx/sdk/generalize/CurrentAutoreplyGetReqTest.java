package org.wx.sdk.generalize;

import org.junit.Test;
import org.wx.sdk.WxClient;
import org.wx.sdk.base.Const;
import org.wx.sdk.generalize.request.CurrentAutoreplyGetRequest;
import org.wx.sdk.generalize.response.CurrentAutoreplyGetRespone;
import org.wx.sdk.token.RedisAccessToken;

public class CurrentAutoreplyGetReqTest {

	/**
     * 测试获取公众号的自动回复规则
     */
	@Test
    public void testCurrentAutoreplyGetReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        CurrentAutoreplyGetRequest currentAutoreplyGetReq = new CurrentAutoreplyGetRequest();
        CurrentAutoreplyGetRespone currentAutoreplyGetRes = wxClient.excute(currentAutoreplyGetReq);
        System.out.println(currentAutoreplyGetRes.getBody());
    }

}
