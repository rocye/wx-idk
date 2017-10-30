package org.wx.sdk.mutikf;

import org.junit.Test;
import org.wx.sdk.WxClient;
import org.wx.sdk.base.Const;
import org.wx.sdk.mutikf.request.*;
import org.wx.sdk.mutikf.response.*;
import org.wx.sdk.token.RedisAccessToken;

public class KfSessionReqTest {

    /**
     * 测试创建会话
     */
    @Test
    public void testKfSessionCreateReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		KfSessionCreateRequest kfsessionCreateReq = new KfSessionCreateRequest("rocye@gh_64b14fd9510d", Const.OPENID);
        KfSessionCreateRespone kfsessionCreateRes  = wxClient.excute(kfsessionCreateReq);
        System.out.println(kfsessionCreateRes.getBody());
    }

	/**
	 * 测试关闭会话
	 */
	@Test
	public void testKfSessionCloseReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		KfSessionCloseRequest kfsessionCloseReq = new KfSessionCloseRequest("rocye@gh_64b14fd9510d", Const.OPENID);
		KfSessionCloseRespone kfsessionCloseRes  = wxClient.excute(kfsessionCloseReq);
		System.out.println(kfsessionCloseRes.getBody());
	}

	/**
	 * 测试获取客户会话状态
	 */
	@Test
	public void testKfSessionGetReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		KfSessionGetRequest kfSessionGetReq = new KfSessionGetRequest(Const.OPENID);
		KfSessionGetRespone kfsessionGetRes  = wxClient.excute(kfSessionGetReq);
		System.out.println(kfsessionGetRes.getBody());
	}

	/**
	 * 测试获取客服会话列表
	 */
	@Test
	public void testKfSessionListReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		KfSessionListRequest kfSessionListReq = new KfSessionListRequest("rocye@gh_64b14fd9510d");
		KfSessionListRespone kfsessionListRes  = wxClient.excute(kfSessionListReq);
		System.out.println(kfsessionListRes.getBody());
	}

	/**
	 * 测试获取未接入会话列表
	 */
	@Test
	public void testKfSessionWaitcaselistReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		KfSessionWaitcaseListRequest kfSessionWaitcaseListReq = new KfSessionWaitcaseListRequest();
		KfSessionWaitcaseListRespone kfSessionWaitcaseListRes  = wxClient.excute(kfSessionWaitcaseListReq);
		System.out.println(kfSessionWaitcaseListRes.getBody());
	}

	/**
	 * 测试获取聊天记录
	 */
	@Test
	public void testKfMsgrecordListReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		KfMsgrecordListRequest kfMsgrecordListReq = new KfMsgrecordListRequest(987654321L, 987654321L, 1, 10000);
		KfMsgrecordListRespone kfMsgrecordListRes  = wxClient.excute(kfMsgrecordListReq);
		System.out.println(kfMsgrecordListRes.getBody());
	}

}
