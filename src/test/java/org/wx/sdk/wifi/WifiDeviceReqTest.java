package org.wx.sdk.wifi;

import org.junit.Test;
import org.wx.sdk.WxClient;
import org.wx.sdk.base.Const;
import org.wx.sdk.token.RedisAccessToken;
import org.wx.sdk.wifi.request.*;
import org.wx.sdk.wifi.response.*;

public class WifiDeviceReqTest {

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

	/**
	 * 测试获取物料二维码
	 */
	@Test
	public void testQrcodeGetReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		WifiQrcodeGetRequest wifiQrcodeGetReq = new WifiQrcodeGetRequest(429620, "WX567", 1);
		WifiQrcodeGetRespone wifiQrcodeGetRes  = wxClient.excute(wifiQrcodeGetReq);
		System.out.println(wifiQrcodeGetRes.getBody());
	}

}
