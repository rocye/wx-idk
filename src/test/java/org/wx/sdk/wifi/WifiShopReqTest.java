package org.wx.sdk.wifi;

import org.junit.Test;
import org.wx.sdk.WxClient;
import org.wx.sdk.base.Const;
import org.wx.sdk.token.RedisAccessToken;
import org.wx.sdk.wifi.request.WifiShopCleanRequest;
import org.wx.sdk.wifi.request.WifiShopGetRequest;
import org.wx.sdk.wifi.request.WifiShopListRequest;
import org.wx.sdk.wifi.request.WifiShopUpdateRequest;
import org.wx.sdk.wifi.response.WifiShopCleanRespone;
import org.wx.sdk.wifi.response.WifiShopGetRespone;
import org.wx.sdk.wifi.response.WifiShopListRespone;
import org.wx.sdk.wifi.response.WifiShopUpdateRespone;

public class WifiShopReqTest {

    /**
     * 测试获取Wi-Fi门店列表
     */
    @Test
    public void testWifiShopListReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        WifiShopListRequest wifiShopListReq = new WifiShopListRequest(1, 20);
        WifiShopListRespone wifiShopListRes  = wxClient.excute(wifiShopListReq);
        System.out.println(wifiShopListRes.getBody());
    }

	/**
	 * 测试查询门店Wi-Fi信息
	 */
	@Test
	public void testWifiShopGetReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		WifiShopGetRequest wifiShopGetReq = new WifiShopGetRequest(1);
		WifiShopGetRespone wifiShopGetRes  = wxClient.excute(wifiShopGetReq);
		System.out.println(wifiShopGetRes.getBody());
	}

	/**
	 * 测试修改门店网络信息
	 */
	@Test
	public void testWifiShopUpdateReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		WifiShopUpdateRequest wifiShopUpdateReq = new WifiShopUpdateRequest(429620, "WX123", "WX567");
		WifiShopUpdateRespone wifiShopUpdateRes  = wxClient.excute(wifiShopUpdateReq);
		System.out.println(wifiShopUpdateRes.getBody());
	}

	/**
	 * 测试清空门店网络及设备
	 */
	@Test
	public void testWifiShopCleanReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		WifiShopCleanRequest wifiShopCleanReq = new WifiShopCleanRequest(429620);
		WifiShopCleanRespone wifiShopCleanRes  = wxClient.excute(wifiShopCleanReq);
		System.out.println(wifiShopCleanRes.getBody());
	}

}
