package org.wx.sdk.wifi;

import org.junit.Test;
import org.wx.sdk.WxClient;
import org.wx.sdk.base.Const;
import org.wx.sdk.token.RedisAccessToken;
import org.wx.sdk.wifi.request.*;
import org.wx.sdk.wifi.response.*;

public class WifiHomepageReqTest {

	/**
	 * 测试设置商家主页
	 */
	@Test
	public void testWifiHomepageSetReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		WifiHomepageSetRequest wifiHomepageSetReq = new WifiHomepageSetRequest(429620, (short)0);
		WifiHomepageSetRespone wifiHomepageSetRes  = wxClient.excute(wifiHomepageSetReq);
		System.out.println(wifiHomepageSetRes.getBody());
	}

	/**
	 * 测试查询商家主页
	 */
	@Test
	public void testWifiHomepageGetReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		WifiHomepageGetRequest wifiHomepageGetReq = new WifiHomepageGetRequest(429620);
		WifiHomepageGetRespone wifiHomepageGetRes  = wxClient.excute(wifiHomepageGetReq);
		System.out.println(wifiHomepageGetRes.getBody());
	}

	/**
	 * 测试设置微信首页欢迎语
	 */
	@Test
	public void testWifiBarSetReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		WifiBarSetRequest wifiBarSetReq = new WifiBarSetRequest(429620, (short)1);
		WifiBarSetRespone wifiBarSetRes  = wxClient.excute(wifiBarSetReq);
		System.out.println(wifiBarSetRes.getBody());
	}

	/**
	 * 测试设置连网完成页
	 */
	@Test
	public void testWifiFinishpageSetReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		WifiFinishpageSetRequest wifiFinishpageSetReq = new WifiFinishpageSetRequest(429620, "http://www.qq.com");
		WifiFinishpageSetRespone wifiFinishpageSetRes  = wxClient.excute(wifiFinishpageSetReq);
		System.out.println(wifiFinishpageSetRes.getBody());
	}

	/**
	 * 测试Wi-Fi数据统计
	 */
	@Test
	public void testWifiStatisticsListReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		WifiStatisticsListRequest wifiStatisticsListReq = new WifiStatisticsListRequest("2017-10-15", "2017-10-30");
		WifiStatisticsListRespone wifiStatisticsListRes  = wxClient.excute(wifiStatisticsListReq);
		System.out.println(wifiStatisticsListRes.getBody());
	}

}
