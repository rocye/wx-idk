package org.wx.sdk.webdev;

import org.junit.Test;
import org.wx.sdk.WxClient;
import org.wx.sdk.base.Const;
import org.wx.sdk.webdev.request.AuthTokenRequest;
import org.wx.sdk.webdev.request.UserInfoRequest;
import org.wx.sdk.webdev.response.AuthTokenRespone;
import org.wx.sdk.webdev.response.OAuth2TokenGetRespone;
import org.wx.sdk.webdev.response.UserInfoRespone;

public class WebDevReqTest {

    /**
     * 测试获取网页授权用户信息
     */
    @Test
    public void testOAuth2UserInfoReq() {
        OAuth2TokenGetRespone respone = OAuth2AccessToken.getInstance().getWxToken(Const.APPID, Const.APPSERCT, "CODE");
        if(respone != null && respone.getAccess_token() != null){
			WxClient wxClient = new WxClient(respone.getAccess_token());
			UserInfoRequest userInfoReq = new UserInfoRequest(Const.OPENID);
			UserInfoRespone userInfoRes = wxClient.excute(userInfoReq);
			System.out.println(userInfoRes.getBody());
		}else{
			System.out.println("获取OAuth2Token失败...");
		}
    }

	/**
	 * 测试检验授权凭证
	 */
	@Test
	public void testAuthTokenReq() {
		OAuth2TokenGetRespone respone = OAuth2AccessToken.getInstance().getWxToken(Const.APPID, Const.APPSERCT, "CODE");
		if(respone != null && respone.getAccess_token() != null){
			WxClient wxClient = new WxClient(respone.getAccess_token());
			AuthTokenRequest authTokenReq = new AuthTokenRequest(Const.OPENID);
			AuthTokenRespone authTokenRes = wxClient.excute(authTokenReq);
			System.out.println(authTokenRes.getBody());
		}else{
			System.out.println("获取OAuth2Token失败...");
		}
	}
    
}
