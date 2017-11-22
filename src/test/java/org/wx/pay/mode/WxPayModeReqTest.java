package org.wx.pay.mode;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.wx.pay.WxPayClient;
import org.wx.pay.common.WxPayUtil;
import org.wx.pay.mode.request.*;
import org.wx.pay.mode.response.*;
import org.wx.pay.tool.request.*;
import org.wx.pay.tool.response.GetQyTransferinfoRespone;
import org.wx.pay.tool.response.GetRedpackInfoRespone;
import org.wx.pay.tool.response.QyTransfersRespone;
import org.wx.pay.tool.response.SendRedpackRespone;
import org.wx.sdk.base.Const;
import org.wx.sdk.common.DateUtil;
import org.wx.sdk.common.Dom4jUtil;

import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 支付方式单元测试
 */
public class WxPayModeReqTest {

	private static String OPENID = "or2iijlXsx-5NOMr6PyXz9BYPhV8";

	/**
	 * 测试扫码支付（模式二）统一下单
	 */
	@Test
	public void testUnifiedorderReq() {
		WxPayClient wxPayClient  = new WxPayClient(Const.PaternerKey);
		String nonceStr = String.valueOf(System.currentTimeMillis());
		Random random = new Random();
		String orderNo = "SCAN_" + DateUtil.format(new Date(), "yyyyMMddHHmmss") + (1000 + random.nextInt(9000));
		UnifiedOrderRequest unifiedorderReq = new UnifiedOrderRequest(Const.WxAppId, Const.MchId, nonceStr, "电子书免费读",orderNo, 1, "127.0.0.1", "http://www.rocye.com", "NATIVE", "1111");
		UnifiedOrderRespone unifiedorderRes = wxPayClient.excute(unifiedorderReq);
		//<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg><appid><![CDATA[wx2eea98b5e0276a5d]]></appid><mch_id><![CDATA[1226672102]]></mch_id><nonce_str><![CDATA[UqfayICU423is2nn]]></nonce_str><sign><![CDATA[776ED2C49CD8D6FE3C599F9785845570]]></sign><result_code><![CDATA[SUCCESS]]></result_code><prepay_id><![CDATA[wx2017111617321056967d2fb40372553454]]></prepay_id><trade_type><![CDATA[NATIVE]]></trade_type><code_url><![CDATA[weixin://wxpay/bizpayurl?pr=oNHq98K]]></code_url></xml>
		System.out.println(unifiedorderRes.getBody());
	}

	/**
	 * 测试查询订单
	 * 交易单号:4200000039201711165057123152
	 * 商户单号:SCAN_201711161732178748
	 */
	@Test
	public void testOrderQueryReq() {
		WxPayClient wxPayClient  = new WxPayClient(Const.PaternerKey);
		String nonceStr = String.valueOf(System.currentTimeMillis());
		OrderQueryRequest orderQueryReq = new OrderQueryRequest(Const.APPID, Const.MchId, "4200000039201711165057123152", nonceStr);
		OrderQueryRespone orderQueryRes = wxPayClient.excute(orderQueryReq);
		//<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg><appid><![CDATA[xxxxxx]]></appid><mch_id><![CDATA[yyyyyyy]]></mch_id><nonce_str><![CDATA[IdtVqevG7e9Fh06e]]></nonce_str><sign><![CDATA[5BD32C7A2B0F9227B8DA9C9AD66571E9]]></sign><result_code><![CDATA[SUCCESS]]></result_code><openid><![CDATA[oFYHLvkzNC8P_uZKPS7ppSuHiYwk]]></openid><is_subscribe><![CDATA[Y]]></is_subscribe><trade_type><![CDATA[NATIVE]]></trade_type><bank_type><![CDATA[CFT]]></bank_type><total_fee>1</total_fee><fee_type><![CDATA[CNY]]></fee_type><transaction_id><![CDATA[4200000039201711165057123152]]></transaction_id><out_trade_no><![CDATA[SCAN_201711161732178748]]></out_trade_no><attach><![CDATA[]]></attach><time_end><![CDATA[20171116173340]]></time_end><trade_state><![CDATA[SUCCESS]]></trade_state><cash_fee>1</cash_fee></xml>
		System.out.println(orderQueryRes.getBody());

		OrderQueryRequest orderQueryReq2 = new OrderQueryRequest(Const.APPID, Const.MchId, "SCAN_201711161732178748", nonceStr, null);
		OrderQueryRespone orderQueryRes2 = wxPayClient.excute(orderQueryReq2);
		System.out.println(orderQueryRes2.getBody());
	}

	/**
	 * 测试关闭订单
	 * 商户单号:SCAN_201711161732178748
	 */
	@Test
	public void testCloseOrderReq() {
		WxPayClient wxPayClient  = new WxPayClient(Const.PaternerKey);
		String nonceStr = String.valueOf(System.currentTimeMillis());
		CloseOrderRequest closeOrderReq = new CloseOrderRequest(Const.APPID, Const.MchId, "SCAN_201711161732178748", nonceStr);
		CloseOrderRespone closeOrderRes = wxPayClient.excute(closeOrderReq);
		//<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg><appid><![CDATA[xxxxxx]]></appid><mch_id><![CDATA[yyyyyyy]]></mch_id><sub_mch_id><![CDATA[]]></sub_mch_id><nonce_str><![CDATA[TvSALXgRmIbKCfZj]]></nonce_str><sign><![CDATA[BCA59C29FB17920EF8805606A7239F01]]></sign><result_code><![CDATA[FAIL]]></result_code><err_code><![CDATA[ORDERPAID]]></err_code><err_code_des><![CDATA[order paid]]></err_code_des></xml>
		System.out.println(closeOrderRes.getBody());
	}

	/**
	 * 测试申请退款
	 * 交易单号:4200000039201711165057123152
	 * 商户单号:SCAN_201711161732178748
	 */
	@Test
	public void testOrderRefundReq() {
		WxPayClient wxPayClient  = new WxPayClient(Const.PaternerKey, Const.CertPath, Const.CertPass);
		String nonceStr = String.valueOf(System.currentTimeMillis());
		Random random = new Random();
		String refundNo = "REFUND_" + DateUtil.format(new Date(), "yyyyMMddHHmmss") + (1000 + random.nextInt(9000));
		OrderRefundRequest orderRefundReq = new OrderRefundRequest(Const.APPID, Const.MchId, "4200000039201711165057123152", nonceStr, refundNo, 1, 1);
		OrderRefundRespone orderRefundRes = wxPayClient.excute(orderRefundReq);
		//<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg><appid><![CDATA[xxxxxx]]></appid><mch_id><![CDATA[yyyyyyy]]></mch_id><nonce_str><![CDATA[51pCx6C23WRY97Ml]]></nonce_str><sign><![CDATA[7D90E60A504228CC18F18CB7E93E0C5A]]></sign><result_code><![CDATA[SUCCESS]]></result_code><transaction_id><![CDATA[4200000039201711165057123152]]></transaction_id><out_trade_no><![CDATA[SCAN_201711161732178748]]></out_trade_no><out_refund_no><![CDATA[REFUND_201711201439036830]]></out_refund_no><refund_id><![CDATA[50000005072017112002415603888]]></refund_id><refund_channel><![CDATA[]]></refund_channel><refund_fee>1</refund_fee><coupon_refund_fee>0</coupon_refund_fee><total_fee>1</total_fee><cash_fee>1</cash_fee><coupon_refund_count>0</coupon_refund_count><cash_refund_fee>1</cash_refund_fee></xml>
		System.out.println(orderRefundRes.getBody());
	}

	/**
	 * 测试查询退款
	 * 微信退款单号：50000005072017112002415603888
	 * 商户退款单号：REFUND_201711201439036830
	 * 微信订单号：4200000039201711165057123152
	 * 商户订单号：SCAN_201711161732178748
	 * 返回乱码
	 */
	@Test
	public void testRefundQueryReq() {
		WxPayClient wxPayClient  = new WxPayClient(Const.PaternerKey);
		String nonceStr = String.valueOf(System.currentTimeMillis());
		//RefundQueryRequest refundQueryReq = RefundQueryRequest.getRequestByRefundId(Const.APPID, Const.MchId, nonceStr, "50000005072017112002415603888");
		//refundQueryReq.setSign_type("");
		//refundQueryReq.setOffset(0);
		RefundQueryRequest refundQueryReq = RefundQueryRequest.getRequestByRefundNo(Const.APPID, Const.MchId, nonceStr, "REFUND_201711201439036830");
		RefundQueryRespone refundQueryRes = wxPayClient.excute(refundQueryReq);
		System.out.println(refundQueryRes.getBody());
	}

	/**
	 * 测试下载对账单
	 */
	@Test
	public void testDownloadBillReq() {
		WxPayClient wxPayClient  = new WxPayClient(Const.PaternerKey);
		String nonceStr = String.valueOf(System.currentTimeMillis());
		//直接输出对帐单
		DownloadBillRequest downloadBillReq = new DownloadBillRequest(Const.APPID, Const.MchId, nonceStr, "20171120", "ALL");
		DownloadBillRespone downloadBillRes = wxPayClient.excute(downloadBillReq);
		System.out.println(downloadBillRes.getBody());

		//TXT输出对帐单
		downloadBillReq.setFileName("bill.txt");
		downloadBillReq.setFilePath("C:\\");
		DownloadBillRespone downloadBillRes2 = wxPayClient.excute(downloadBillReq);
		System.out.println(downloadBillRes2.getBody());

//		//GZIP输出对帐单(解压CSV文件汉字乱码)
//		downloadBillReq.setFileName("bill.gzip");
//		downloadBillReq.setFilePath("C:\\");
//		downloadBillReq.setTar_type("GZIP");
//		DownloadBillRespone downloadBillRes3 = wxPayClient.excute(downloadBillReq);
//		System.out.println(downloadBillRes3.getBody());
	}

	/**
	 * 测试转换短链接
	 */
	@Test
	public void testShortUrlReq() throws Exception{
		WxPayClient wxPayClient  = new WxPayClient(Const.PaternerKey);
		String nonceStr = String.valueOf(System.currentTimeMillis());
		String timeStamp = String.valueOf(System.currentTimeMillis() / 1000);
		Map<String, Object> payUrlMap = new HashMap<String, Object>();
		payUrlMap.put("appid", Const.APPID);
		payUrlMap.put("mch_id", Const.MchId);
		payUrlMap.put("time_stamp", timeStamp);
		payUrlMap.put("product_id", "111");
		payUrlMap.put("nonce_str", nonceStr);
		String sign = WxPayUtil.CreateSign(payUrlMap, Const.PaternerKey);

		String longUrl = "weixin://wxpay/bizpayurl?sign="+ sign +"&appid="+ Const.APPID +"&mch_id="+ Const.MchId +"&product_id=111&time_stamp="+ timeStamp +"&nonce_str=" + nonceStr;
		System.out.println(longUrl);
		ShortUrlRequest shortUrlReq = new ShortUrlRequest(Const.APPID, Const.MchId, nonceStr, longUrl);
		ShortUrlRespone shortUrlRes = wxPayClient.excute(shortUrlReq);

		//<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[invalid native url]]></return_msg></xml>
		System.out.println(shortUrlRes.getBody());
	}

	/**
	 * 测试拉取订单评价数据(商户签名错误)
	 */
	@Test
	public void testBatchQueryCommentReq() {
		WxPayClient wxPayClient  = new WxPayClient(Const.PaternerKey, Const.CertPath, Const.CertPass);
		String nonceStr = String.valueOf(System.currentTimeMillis());
		//直接输出评价数据
		BatchQueryCommentRequest batchQueryCommentReq = new BatchQueryCommentRequest(Const.APPID, Const.MchId, nonceStr, "20171120000000", "20171121000000", 0L);
		BatchQueryCommentRespone batchQueryCommentRes = wxPayClient.excute(batchQueryCommentReq);
		////<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[商户签名错误]]></return_msg></xml>
		System.out.println(batchQueryCommentRes.getBody());

		//TXT输出评价数据
		batchQueryCommentReq.setFileName("comment.txt");
		batchQueryCommentReq.setFilePath("C:\\");
		BatchQueryCommentRespone batchQueryCommentRes2 = wxPayClient.excute(batchQueryCommentReq);
		//<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[商户签名错误]]></return_msg></xml>
		System.out.println(batchQueryCommentRes2.getBody());
	}

	/**
	 * 测试XML转对象
	 */
	@Test
	public void testXml2MapReq() {
		String xml = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg><result_code><![CDATA[SUCCESS]]></result_code><err_code><![CDATA[SUCCESS]]></err_code><err_code_des><![CDATA[OK]]></err_code_des><mch_billno><![CDATA[OD201711141535238930]]></mch_billno><mch_id><![CDATA[yyyyyyy]]></mch_id><detail_id><![CDATA[1000041701201711143000109811129]]></detail_id><status><![CDATA[RECEIVED]]></status><send_type><![CDATA[API]]></send_type><hb_type><![CDATA[NORMAL]]></hb_type><total_num>1</total_num><total_amount>100</total_amount><send_time><![CDATA[2017-11-14 15:35:25]]></send_time><hblist><hbinfo><openid><![CDATA[or2iijlXsx-5NOMr6PyXz9BYPhV7]]></openid><amount>101</amount><rcv_time><![CDATA[2017-11-14 15:38:28]]></rcv_time></hbinfo></hblist></xml>";
		Map<String,Object> map = Dom4jUtil.getMapByXmlStr(xml);
		System.out.println(map);
		String jsonRes = JSON.toJSONString(map);
		System.out.println(jsonRes);

		GetRedpackInfoRespone getRedpackInfoRes = JSON.parseObject(jsonRes, GetRedpackInfoRespone.class);
	}


}
