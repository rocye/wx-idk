package org.wx.sdk.mutikf;

import org.junit.Test;
import org.wx.sdk.WxClient;
import org.wx.sdk.base.Const;
import org.wx.sdk.mutikf.request.*;
import org.wx.sdk.token.RedisAccessToken;
import org.wx.sdk.common.MD5;
import org.wx.sdk.mutikf.response.KfAccountListRespone;
import org.wx.sdk.mutikf.response.KfAccountOnlineListRespone;
import org.wx.sdk.mutikf.response.KfAccountRespone;

public class KfAccountReqTest {

    /**
     * 测试添加客服帐号
     */
    @Test
    public void testKfAddReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        String pwd = MD5.encode("123");
        System.out.println(pwd);
        KfAccountAddRequest kfAccountAddReq = new KfAccountAddRequest("rocye@gh_64b14fd9510d", "Rocye", pwd);
        KfAccountRespone kfAccountRes  = wxClient.excute(kfAccountAddReq);
        System.out.println(kfAccountRes.getBody());
    }
    
    /**
     * 测试修改客服帐号
     */
    @Test
    public void testKfUpdateReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        String pwd = MD5.encode("123");
        System.out.println(pwd);
        KfAccountUpdateRequest kfAccountUpdateReq = new KfAccountUpdateRequest("rocye@gh_64b14fd9510d", "Rocye", pwd);
        KfAccountRespone kfAccountRes  = wxClient.excute(kfAccountUpdateReq);
        System.out.println(kfAccountRes.getBody());
    }
    
    /**
     * 测试删除客服帐号
     */
    @Test
    public void testKfDelReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        KfAccountDelRequest kfAccountDelReq = new KfAccountDelRequest("rocye@gh_64b14fd9510d");
        KfAccountRespone kfAccountRes  = wxClient.excute(kfAccountDelReq);
        System.out.println(kfAccountRes.getBody());
    }
    
    /**
     * 测试查看客服帐号列表信息
     */
    @Test
    public void testKfListReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        KfAccountListRequest kfAccountListReq = new KfAccountListRequest();
        KfAccountListRespone kfAccountListRes  = wxClient.excute(kfAccountListReq);
        System.out.println(kfAccountListRes.getBody());
    }
    
    /**
     * 测试获取在线客服接待信息
     */
    @Test
    public void testKfOnlineListReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        KfAccountOnlineListRequest kfAccountOnlineListReq = new KfAccountOnlineListRequest();
        KfAccountOnlineListRespone kfAccountOnlineListRes  = wxClient.excute(kfAccountOnlineListReq);
        System.out.println(kfAccountOnlineListRes.getBody());
    }

	/**
	 * 测试邀请绑定客服帐号
	 */
	@Test
	public void testKfInviteworkerReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		KfAccountInviteworkerRequest kfAccountInviteworkerReq = new KfAccountInviteworkerRequest("111", "222");
		KfAccountRespone kfAccountRes  = wxClient.excute(kfAccountInviteworkerReq);
		System.out.println(kfAccountRes.getBody());
	}
    
}
