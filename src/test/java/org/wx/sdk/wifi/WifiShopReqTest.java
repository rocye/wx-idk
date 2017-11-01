package org.wx.sdk.wifi;

import org.junit.Test;
import org.wx.sdk.WxClient;
import org.wx.sdk.base.Const;
import org.wx.sdk.token.RedisAccessToken;
import org.wx.sdk.wifi.request.*;
import org.wx.sdk.wifi.response.*;

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

	/**
	 * 测试添加密码型设备
	 */
	@Test
	public void testWifiDeviceAddReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		WifiDeviceAddRequest wifiDeviceAddReq = new WifiDeviceAddRequest(429620, "WX123", "12345689");
		WifiDeviceAddRespone wifiDeviceAddRes  = wxClient.excute(wifiDeviceAddReq);
		System.out.println(wifiDeviceAddRes.getBody());
	}

	/**
	 * 测试添加portal型设备
	 */
	@Test
	public void testWifiApportalRegisterReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		WifiApportalRegisterRequest wifiApportalRegisterReq = new WifiApportalRegisterRequest(429620, "WX123");
		WifiApportalRegisterRespone wifiApportalRegisterRes  = wxClient.excute(wifiApportalRegisterReq);
		System.out.println(wifiApportalRegisterRes.getBody());
	}

	/**
	 * 测试查询设备
	 */
	@Test
	public void testWifiDeviceListReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		WifiDeviceListRequest wifiDeviceListReq = new WifiDeviceListRequest();
		WifiDeviceListRespone wifiDeviceListRes  = wxClient.excute(wifiDeviceListReq);
		System.out.println(wifiDeviceListRes.getBody());
	}

	/**
	 * 测试删除设备
	 */
	@Test
	public void testWifiDeviceDeleteReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		WifiDeviceDeleteRequest wifiDeviceDeleteReq = new WifiDeviceDeleteRequest("00:1f:7a:ad:5c:a8");
		WifiDeviceDeleteRespone wifiDeviceDeleteRes  = wxClient.excute(wifiDeviceDeleteReq);
		System.out.println(wifiDeviceDeleteRes.getBody());
	}

}
