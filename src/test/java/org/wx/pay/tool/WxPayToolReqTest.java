package org.wx.pay.tool;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.wx.pay.WxPayClient;
import org.wx.pay.mode.request.CloseOrderRequest;
import org.wx.pay.mode.request.OrderQueryRequest;
import org.wx.pay.mode.request.UnifiedOrderRequest;
import org.wx.pay.mode.response.CloseOrderRespone;
import org.wx.pay.mode.response.OrderQueryRespone;
import org.wx.pay.mode.response.UnifiedOrderRespone;
import org.wx.pay.tool.request.*;
import org.wx.pay.tool.response.GetQyTransferinfoRespone;
import org.wx.pay.tool.response.GetRedpackInfoRespone;
import org.wx.pay.tool.response.QyTransfersRespone;
import org.wx.pay.tool.response.SendRedpackRespone;
import org.wx.sdk.base.Const;
import org.wx.sdk.common.DateUtil;
import org.wx.sdk.common.Dom4jUtil;
import java.util.Date;
import java.util.Map;
import java.util.Random;

/**
 * 支付工具单元测试
 */
public class WxPayToolReqTest {

	private static String OPENID = "or2iijlXsx-5NOMr6PyXz9BYPhV8";

    /**
     * 测试发送现金红包
     */
    @Test
    public void testSendRedpackReq() {
		WxPayClient wxPayClient  = new WxPayClient(Const.PaternerKey, Const.CertPath, Const.CertPass);
		SendRedpackRequest sendredpackReq = new SendRedpackRequest("国信服务号", OPENID, 100, 1, "感谢参加双11抽奖活动", "随机抢红包活动", "快叫上朋友一起来玩");
		sendredpackReq.setNonce_str(String.valueOf(System.currentTimeMillis()));
		Random random = new Random();
		String orderNo = "OD" + DateUtil.format(new Date(), "yyyyMMddHHmmss") + (1000 + random.nextInt(9000));
		sendredpackReq.setMch_billno(orderNo);
		sendredpackReq.setMch_id(Const.MchId);
		sendredpackReq.setWxappid(Const.WxAppId);
		sendredpackReq.setClient_ip("127.0.0.1");

		//<xml><total_amount>100</total_amount><wxappid>wx2eea98b5e0276a5d</wxappid><remark>快叫上朋友一起来玩</remark><wishing>感谢参加双11抽奖活动</wishing><act_name>随机抢红包活动</act_name><nonce_str>1510644923990</nonce_str><send_name>国信安达服务号</send_name><client_ip>127.0.0.1</client_ip><sign>12F646EF462DF26471A31FF5A8246A43</sign><mch_id>1226672102</mch_id><mch_billno>OD201711141535238930</mch_billno><total_num>1</total_num><re_openid>or2iijlXsx-5NOMr6PyXz9BYPhV8</re_openid></xml>
		SendRedpackRespone sendredpackRes = wxPayClient.excute(sendredpackReq);
		//<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[发放成功]]></return_msg><result_code><![CDATA[SUCCESS]]></result_code><err_code><![CDATA[SUCCESS]]></err_code><err_code_des><![CDATA[发放成功]]></err_code_des><mch_billno><![CDATA[OD201711141535238930]]></mch_billno><mch_id><![CDATA[1226672102]]></mch_id><wxappid><![CDATA[wx2eea98b5e0276a5d]]></wxappid><re_openid><![CDATA[or2iijlXsx-5NOMr6PyXz9BYPhV8]]></re_openid><total_amount>100</total_amount><send_listid><![CDATA[1000041701201711143000109811129]]></send_listid></xml>
		System.out.println(sendredpackRes.getBody());
    }

	/**
	 * 测试发放裂变红包
	 */
	@Test
	public void testSendGroupRedpackReq() {
		WxPayClient wxPayClient  = new WxPayClient(Const.PaternerKey, Const.CertPath, Const.CertPass);
		SendGroupRedpackRequest sendGroupRedpackReq = new SendGroupRedpackRequest("国信服务号", OPENID, 100, 10, "感谢参加双11抽奖活动", "随机抢红包活动", "快叫上朋友一起来玩");
		sendGroupRedpackReq.setNonce_str(String.valueOf(System.currentTimeMillis()));
		Random random = new Random();
		String orderNo = "OD" + DateUtil.format(new Date(), "yyyyMMddHHmmss") + (1000 + random.nextInt(9000));
		sendGroupRedpackReq.setMch_billno(orderNo);
		sendGroupRedpackReq.setMch_id(Const.MchId);
		sendGroupRedpackReq.setWxappid(Const.WxAppId);
		sendGroupRedpackReq.setClient_ip("127.0.0.1");

		SendRedpackRespone sendredpackRes = wxPayClient.excute(sendGroupRedpackReq);
		System.out.println(sendredpackRes.getBody());
	}

	/**
	 * 测试查询红包记录
	 */
	@Test
	public void testGetRedpackInfoReq() {
		WxPayClient wxPayClient  = new WxPayClient(Const.PaternerKey, Const.CertPath, Const.CertPass);
		String nonceStr = String.valueOf(System.currentTimeMillis());
		String orderNo = "OD201711141535238930";
		GetRedpackInfoRequest getRedpackInfoReq = new GetRedpackInfoRequest(nonceStr, orderNo, "1226672102", "wx2eea98b5e0276a5d", "MCHT");
		GetRedpackInfoRespone getRedpackInfoRes = wxPayClient.excute(getRedpackInfoReq);
		//<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg><result_code><![CDATA[SUCCESS]]></result_code><err_code><![CDATA[SUCCESS]]></err_code><err_code_des><![CDATA[OK]]></err_code_des><mch_billno><![CDATA[OD201711141535238930]]></mch_billno><mch_id><![CDATA[1226672102]]></mch_id><detail_id><![CDATA[1000041701201711143000109811129]]></detail_id><status><![CDATA[RECEIVED]]></status><send_type><![CDATA[API]]></send_type><hb_type><![CDATA[NORMAL]]></hb_type><total_num>1</total_num><total_amount>100</total_amount><send_time><![CDATA[2017-11-14 15:35:25]]></send_time><hblist><hbinfo><openid><![CDATA[or2iijlXsx-5NOMr6PyXz9BYPhV8]]></openid><amount>100</amount><rcv_time><![CDATA[2017-11-14 15:38:28]]></rcv_time></hbinfo></hblist></xml>
		System.out.println(getRedpackInfoRes.getBody());
	}

	/**
	 * 测试企业付款
	 */
	@Test
	public void testQyTransfersReq() {
		WxPayClient wxPayClient  = new WxPayClient(Const.PaternerKey, Const.CertPath, Const.CertPass);
		String nonceStr = String.valueOf(System.currentTimeMillis());
		Random random = new Random();
		String orderNo = "TR" + DateUtil.format(new Date(), "yyyyMMddHHmmss") + (1000 + random.nextInt(9000));
		QyTransfersRequest qyTransfersReq = new QyTransfersRequest(nonceStr, Const.WxAppId, Const.MchId, orderNo, OPENID, 100, "测试企业付款接口", "127.0.0.1");
		QyTransfersRespone qyTransfersRes = wxPayClient.excute(qyTransfersReq);
		//<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[]]></return_msg><mchid><![CDATA[1226672102]]></mchid><nonce_str><![CDATA[1510740053218]]></nonce_str><result_code><![CDATA[SUCCESS]]></result_code><partner_trade_no><![CDATA[TR201711151800538424]]></partner_trade_no><payment_no><![CDATA[1000018301201711151373310958]]></payment_no><payment_time><![CDATA[2017-11-15 18:00:51]]></payment_time></xml>
		System.out.println(qyTransfersRes.getBody());
	}

	/**
	 * 测试查询企业付款
	 */
	@Test
	public void testGetQyTransfersReq() {
		WxPayClient wxPayClient  = new WxPayClient(Const.PaternerKey, Const.CertPath, Const.CertPass);
		String nonceStr = String.valueOf(System.currentTimeMillis());
		String partnerTradeNo = "TR201711151800538424";
		GetQyTransferinfoRequest getQyTransferinfoReq = new GetQyTransferinfoRequest(nonceStr, Const.WxAppId, Const.MchId, partnerTradeNo);
		GetQyTransferinfoRespone getQyTransferinfoRes = wxPayClient.excute(getQyTransferinfoReq);
		//<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[]]></return_msg><result_code><![CDATA[SUCCESS]]></result_code><partner_trade_no><![CDATA[TR201711151800538424]]></partner_trade_no><mch_id><![CDATA[1226672102]]></mch_id><detail_id><![CDATA[1000018301201711151373310958]]></detail_id><status><![CDATA[SUCCESS]]></status><reason><![CDATA[]]></reason><openid><![CDATA[or2iijlXsx-5NOMr6PyXz9BYPhV8]]></openid><transfer_name><![CDATA[]]></transfer_name><payment_amount><![CDATA[100]]></payment_amount><transfer_time><![CDATA[2017-11-15 18:00:51]]></transfer_time><payment_time><![CDATA[2017-11-15 18:00:51]]></payment_time><desc><![CDATA[测试企业付款接口]]></desc></xml>
		System.out.println(getQyTransferinfoRes.getBody());
	}

}
