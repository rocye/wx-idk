package org.wx.sdk.card;

import org.junit.Test;
import org.wx.sdk.WxClient;
import org.wx.sdk.base.Const;
import org.wx.sdk.card.object.*;
import org.wx.sdk.card.request.*;
import org.wx.sdk.card.respone.*;
import org.wx.sdk.token.RedisAccessToken;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CardReqTest {

    /**
     * 测试上传卡券图片素材
     */
    @Test
    public void testUploadCardImgReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        String filePath = "D:/Rocye/Pictures/65191710.jpg";
		CardImgUploadRequest cardUploadimgReq = new CardImgUploadRequest(filePath);
		CardImgUploadRespone cardUploadimgRes = wxClient.excute(cardUploadimgReq);
		//{"url":"http:\/\/mmbiz.qpic.cn\/mmbiz_jpg\/TPynjoavL0PicXuac9XZic3T3qEGe1TcygO0htLekcNPCE9iboichqbiaGrdHpeZlJAgL3hpFQzPgATJTYYOVicbzkjQ\/0"}
        System.out.println(cardUploadimgRes.getBody());
    }

	/**
	 * 测试创建卡券
	 */
	@Test
	public void testCreateCardReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		Map<String, Object> cardMap = new HashMap<>();
		cardMap.put("card_type", "GROUPON");
		String logoUrl = "http://mmbiz.qpic.cn/mmbiz_jpg/TPynjoavL0PicXuac9XZic3T3qEGe1TcygO0htLekcNPCE9iboichqbiaGrdHpeZlJAgL3hpFQzPgATJTYYOVicbzkjQ/0";
		Sku sku = new Sku(1000);
		DateInfo dateInfo = new DateInfo("DATE_TYPE_FIX_TIME_RANGE", System.currentTimeMillis()/1000-86400, System.currentTimeMillis()/1000+8640000);
		BaseInfo baseInfo = new BaseInfo(logoUrl,"CODE_TYPE_TEXT","微信餐厅Y","Y132元双人火锅套餐","Color010","使用时向服务员出示此券","不可与其他优惠同享\\n如需团购券发票，请在消费时向商户提出\\n店内均可使用，仅限堂食",sku, dateInfo);
		//baseInfo.setUse_custom_code(true);
		//baseInfo.setGet_custom_code_mode("GET_CUSTOM_CODE_MODE_DEPOSIT");
		baseInfo.setLocation_id_list(new String[]{"33788392"});
		Groupon groupon = new Groupon(baseInfo, "Y双人套餐\\n -进口红酒一支。\\n孜然牛肉一份");
		cardMap.put("groupon", groupon);
		CardCreateRequest createCardReq = new CardCreateRequest(cardMap);
		CardCreateRespone createCardRes = wxClient.excute(createCardReq);
		//{"errcode":0,"errmsg":"ok","card_id":"pFYHLvnyR6BTa5UuGeBhVADMdftA"}
		System.out.println(createCardRes.getBody());
	}

	/**
	 * 测试设置买单接口
	 */
	@Test
	public void testPaycellSetReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		CardPayCellSetRequest paycellSetReq = new CardPayCellSetRequest("pFYHLvn6sM3GFOTYf0yvIOfNwymA", true);
		CardPayCellSetRespone paycellSetRes = wxClient.excute(paycellSetReq);
		//{"errcode":43017,"errmsg":"require location id!  hint: [R_hs8a06151100]"}
		System.out.println(paycellSetRes.getBody());
	}

	/**
	 * 测试设置自助核销接口
	 */
	@Test
	public void testSelfconsumeCellSetReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		CardSelfconsumeCellSetRequest selfconsumeCellSetReq = new CardSelfconsumeCellSetRequest("pFYHLvn6sM3GFOTYf0yvIOfNwymA", true);
		CardSelfconsumeCellSetRespone selfconsumeCellSetRes = wxClient.excute(selfconsumeCellSetReq);
		//{"errcode":0,"errmsg":"ok"}
		System.out.println(selfconsumeCellSetRes.getBody());
	}

	/**
	 * 测试创建单卡券二维码
	 */
	@Test
	public void testCreateQrcodeReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		Card card = new Card("pFYHLvnyR6BTa5UuGeBhVADMdftA", null, "111");
		CardQrcodeCreateRequest createQrcodeReq = new CardQrcodeCreateRequest(card);
		CardQrcodeCreateRespone createQrcodeRes = wxClient.excute(createQrcodeReq);
		//{"errcode":0,"errmsg":"ok","ticket":"gQE17zwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyQnVKbHdSbDFiYi0xblAtd052NHYAAgRzS39dAwSAM_EB","expire_seconds":31536000,"url":"http:\/\/weixin.qq.com\/q\/02BuJlwRl1bb-1nP-wNv4v","show_qrcode_url":"https:\/\/mp.weixin.qq.com\/cgi-bin\/showqrcode?ticket=gQE17zwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyQnVKbHdSbDFiYi0xblAtd052NHYAAgRzS39dAwSAM_EB"}
		//{"errcode":40078,"errmsg":"invalid card status hint: [hnSlIa0822ard2]"} 卡券已删除
		System.out.println(createQrcodeRes.getBody());
	}

	/**
	 * 测试创建多卡券二维码
	 */
	@Test
	public void testCreateMultiQrcodeReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		List<Card> cardList = new ArrayList<>();
		cardList.add(new Card("pFYHLvmkWy9im2fOd60AJRJfw68E", null, "110"));
		cardList.add(new Card("pFYHLvhOx_HptVD0PUpbrNixlu0c", null, "111"));
		CardMultiQrcodeCreateRequest createQrcodeReq = new CardMultiQrcodeCreateRequest(cardList);
		CardQrcodeCreateRespone createQrcodeRes = wxClient.excute(createQrcodeReq);
		//{"errcode":0,"errmsg":"ok","ticket":"gQFi8DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyb2RXQXdlbDFiYi0xQ3R4VU5xODcAAgSdukFaAwQAp3YA","expire_seconds":7776000,"url":"http:\/\/weixin.qq.com\/q\/02odWAwel1bb-1CtxUNq87","show_qrcode_url":"https:\/\/mp.weixin.qq.com\/cgi-bin\/showqrcode?ticket=gQFi8DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyb2RXQXdlbDFiYi0xQ3R4VU5xODcAAgSdukFaAwQAp3YA"}
		System.out.println(createQrcodeRes.getBody());
	}

	/**
	 * 测试创建货架
	 */
	@Test
	public void testCreateLandingPageReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		List<MinCard> cardList = new ArrayList<>();
		cardList.add(new MinCard("pFYHLvmkWy9im2fOd60AJRJfw68E", "https://mp.weixin.qq.com/misc/getheadimg?fakeid=ofxuouIh3Q9sBzqi0MFUhoEiMaiY&token=771616196&lang=zh_CN"));
		cardList.add(new MinCard("pFYHLvhOx_HptVD0PUpbrNixlu0c", "https://mp.weixin.qq.com/misc/getheadimg?fakeid=ofxuouHYJ5EDxD561SHtIqvT-VlI&token=771616196&lang=zh_CN"));
		String banner = "https://mp.weixin.qq.com/misc/getheadimg?fakeid=ofxuouCCMA2QOIoL-uuhGq1wgCBA&token=771616196&lang=zh_CN";
		CardLandingPageCreateRequest createLandingPageReq = new CardLandingPageCreateRequest(banner, "惠城优惠大派送", true, "SCENE_NEAR_BY", cardList);
		CardLandingPageCreateRespone createLandingPageRes = wxClient.excute(createLandingPageReq);
		//{"errcode":40071,"errmsg":"invalid card type hint: [Ews0iA0301ard2]"}
		System.out.println(createLandingPageRes.getBody());
	}

	/**
	 * 测试导入code
	 */
	@Test
	public void testDepositCodeReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		List<String> codeList = Stream.of("1111","2222","3333","4444","5555","6666").collect(Collectors.toList());
		CardCodeDepositRequest depositCodeReq = new CardCodeDepositRequest("pFYHLvn6sM3GFOTYf0yvIOfNwymA", codeList);
		CardCodeDepositRespone depositCodeRes = wxClient.excute(depositCodeReq);
		//{"errcode":40078,"errmsg":"invalid card status hint: [Jer9UA03621482]"}
		System.out.println(depositCodeRes.getBody());
	}

	/**
	 * 测试查询导入code数目
	 */
	@Test
	public void testGetDepositCountReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		CardCodeGetDepositCountRequest getDepositCountReq = new CardCodeGetDepositCountRequest("pFYHLvlpbLoaHpnguo6_COiV8Wy0");
		CardCodeGetDepositCountRespone getDepositCountRes = wxClient.excute(getDepositCountReq);
		//{"errcode":0,"errmsg":"ok","count":0}
		System.out.println(getDepositCountRes.getBody());
	}

	/**
	 * 测试核查code
	 */
	@Test
	public void testCheckCardCodeReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		List<String> codeList = Stream.of("1111","2222","3333","4444","5555","6666").collect(Collectors.toList());
		CardCodeCheckRequest checkCardCodeReq = new CardCodeCheckRequest("pFYHLvlpbLoaHpnguo6_COiV8Wy0", codeList);
		CardCodeCheckRespone checkCardCodeRes = wxClient.excute(checkCardCodeReq);
		//{"errcode":0,"errmsg":"ok","exist_code":[],"not_exist_code":["1111","2222","3333","4444","5555","6666"]}
		System.out.println(checkCardCodeRes.getBody());
	}

	/**
	 * 测试图文消息群发卡券代码
	 */
	@Test
	public void testGetCardHtmlReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		CardMpnewsGetHtmlRequest getCardHtmlReq = new CardMpnewsGetHtmlRequest("pFYHLvlpbLoaHpnguo6_COiV8Wy0");
		CardMpnewsGetHtmlRespone getCardHtmlRes = wxClient.excute(getCardHtmlReq);
		//{"errcode":0,"errmsg":"ok","content":"<iframe class=\"res_iframe card_iframe js_editor_card\" data-src=\"http:\/\/mp.weixin.qq.com\/bizmall\/appmsgcard?action=show&amp;biz=MzIwMTAwNzg5Mw%3D%3D&amp;cardid=pFYHLvlpbLoaHpnguo6_COiV8Wy0&amp;wechat_card_js=1#wechat_redirect\"><\/iframe>"}
		System.out.println(getCardHtmlRes.getBody());
	}

	/**
	 * 测试设置测试白名单
	 */
	@Test
	public void testSetTestwhitelistReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		List<String> openIdList = Stream.of(Const.OPENID, "oFYHLviCatnBPDs1XxcXoOePNows").collect(Collectors.toList());
		CardTestwhitelistSetRequest setTestwhitelistReq = new CardTestwhitelistSetRequest(openIdList);
		CardTestwhitelistSetRespone setTestwhitelistRes = wxClient.excute(setTestwhitelistReq);
		//{"errcode":0,"errmsg":"ok","white_list_size":2,"success_openid":["oFYHLvkzNC8P_uZKPS7ppSuHiYwk","oFYHLviCatnBPDs1XxcXoOePNows"],"success_username":[]}
		System.out.println(setTestwhitelistRes.getBody());
	}

	/**
	 * 测试查询Code接口
	 */
	@Test
	public void testGetCardCodeReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		CardCodeGetRequest cardCodeGetReq = new CardCodeGetRequest("819679186876");
		CardCodeGetRespone cardCodeGetRes = wxClient.excute(cardCodeGetReq);
		//{"errcode":0,"errmsg":"ok","card":{"card_id":"pFYHLvuDbMbr241m00CAhtypawpw","begin_time":1514364455,"end_time":1523090855,"code":"819679186876"},"openid":"oFYHLviCatnBPDs1XxcXoOePNows","can_consume":true,"user_card_status":"NORMAL","outer_str":"111"}
		System.out.println(cardCodeGetRes.getBody());
	}

	/**
	 * 测试核销Code接口
	 */
	@Test
	public void testConsumeCardCodeReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		CardCodeConsumeRequest cardCodeConsumeReq = new CardCodeConsumeRequest("819679186876", "pFYHLvuDbMbr241m00CAhtypawpw");
		CardCodeConsumeRespone cardCodeConsumeRes = wxClient.excute(cardCodeConsumeReq);
		//{"errcode":0,"errmsg":"ok","card":{"card_id":"pFYHLvuDbMbr241m00CAhtypawpw"},"openid":"oFYHLviCatnBPDs1XxcXoOePNows"}
		System.out.println(cardCodeConsumeRes.getBody());
	}

	/**
	 * 测试Code解码接口
	 */
	@Test
	public void testDecryptCardCodeReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		CardCodeDecryptRequest cardCodeDecryptReq = new CardCodeDecryptRequest("pFYHLvuDbMbr241m00CAhtypawpwxxxxxxxxx");
		CardCodeDecryptRespone cardCodeDecryptRes = wxClient.excute(cardCodeDecryptReq);
		//{"errcode":40075,"errmsg":"invalid encrypt code hint: [7arjXa0681ard2]"}
		System.out.println(cardCodeDecryptRes.getBody());
	}

	/**
	 * 测试获取用户已领取卡券
	 */
	@Test
	public void testUserGetCardListReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		CardUserGetCardListRequest cardUserGetCardListReq = new CardUserGetCardListRequest("oFYHLviCatnBPDs1XxcXoOePNows");
		CardUserGetCardListRespone cardUserGetCardListRes = wxClient.excute(cardUserGetCardListReq);
		//{"errcode":0,"errmsg":"ok","card_list":[{"card_id":"pFYHLvuDbMbr241m00CAhtypawpw","code":"351433422041"}],"has_share_card":false}
		System.out.println(cardUserGetCardListRes.getBody());
	}

	/**
	 * 测试查看卡券详情
	 */
	@Test
	public void testGetCardReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		CardGetRequest cardGetReq = new CardGetRequest("pFYHLvuDbMbr241m00CAhtypawpw");
		CardGetRespone cardGetRes = wxClient.excute(cardGetReq);
		//{"errcode":0,"errmsg":"ok","card":{"card_type":"GROUPON","groupon":{"base_info":{"id":"pFYHLvuDbMbr241m00CAhtypawpw","logo_url":"http:\/\/mmbiz.qpic.cn\/mmbiz_jpg\/TPynjoavL0PicXuac9XZic3T3qEGe1TcygO0htLekcNPCE9iboichqbiaGrdHpeZlJAgL3hpFQzPgATJTYYOVicbzkjQ\/0","code_type":"CODE_TYPE_TEXT","brand_name":"微信餐厅Y","title":"Y132元双人火锅套餐","date_info":{"type":"DATE_TYPE_FIX_TIME_RANGE","begin_timestamp":1514364455,"end_timestamp":1523090855},"color":"#63b359","notice":"使用时向服务员出示此券","description":"不可与其他优惠同享\\n如需团购券发票，请在消费时向商户提出\\n店内均可使用，仅限堂食","location_id_list":[],"status":"CARD_STATUS_NOT_VERIFY","sku":{"quantity":997,"total_quantity":1000},"create_time":1514450844,"update_time":1514450854,"area_code_list":[]},"deal_detail":"Y双人套餐\\n -进口红酒一支。\\n孜然牛肉一份","advanced_info":{"time_limit":[],"text_image_list":[],"business_service":[],"consume_share_card_list":[],"share_friends":false}}}}
		System.out.println(cardGetRes.getBody());
		//{card_type=GROUPON, groupon={"advanced_info":{"business_service":[],"consume_share_card_list":[],"time_limit":[],"text_image_list":[],"share_friends":false},"deal_detail":"Y双人套餐\\n -进口红酒一支。\\n孜然牛肉一份","base_info":{"id":"pFYHLvuDbMbr241m00CAhtypawpw","title":"Y132元双人火锅套餐","date_info":{"end_timestamp":1523090855,"type":"DATE_TYPE_FIX_TIME_RANGE","begin_timestamp":1514364455},"update_time":1514450854,"status":"CARD_STATUS_NOT_VERIFY","color":"#63b359","description":"不可与其他优惠同享\\n如需团购券发票，请在消费时向商户提出\\n店内均可使用，仅限堂食","create_time":1514450844,"location_id_list":[],"sku":{"quantity":997,"total_quantity":1000},"notice":"使用时向服务员出示此券","area_code_list":[],"brand_name":"微信餐厅Y","logo_url":"http://mmbiz.qpic.cn/mmbiz_jpg/TPynjoavL0PicXuac9XZic3T3qEGe1TcygO0htLekcNPCE9iboichqbiaGrdHpeZlJAgL3hpFQzPgATJTYYOVicbzkjQ/0","code_type":"CODE_TYPE_TEXT"}}}
		System.out.println(cardGetRes.getCard());
	}

	/**
	 * 测试批量查询卡券列表
	 */
	@Test
	public void testBatchGetCardReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		CardBatchGetRequest cardBatchGetReq = new CardBatchGetRequest(0, 10);
		CardBatchGetRespone cardBatchGetRes = wxClient.excute(cardBatchGetReq);
		//{"errcode":0,"errmsg":"ok","card_id_list":["pFYHLvtul7AXfGBqK4XLH3PmNuxQ","pFYHLvhpDUxA6Fna5Qzb1y0jGlG0","pFYHLvmkWy9im2fOd60AJRJfw68E","pFYHLvhOx_HptVD0PUpbrNixlu0c","pFYHLvlpbLoaHpnguo6_COiV8Wy0","pFYHLvn6sM3GFOTYf0yvIOfNwymA","pFYHLvuDbMbr241m00CAhtypawpw"],"total_num":7,"card_list":[]}
		System.out.println(cardBatchGetRes.getBody());
	}

	/**
	 * 测试更改卡券信息
	 */
	@Test
	public void testUpdateCardReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		BaseInfo baseInfo = new BaseInfo();
		baseInfo.setNotice("使用提醒！！");
		baseInfo.setDescription("使用说明！！");
		CardUpdateRequest cardUpdateReq = new CardUpdateRequest("pFYHLvuDbMbr241m00CAhtypawpw", baseInfo, "groupon");
		CardUpdateRespone cardUpdateRes = wxClient.excute(cardUpdateReq);
		//{"errcode":0,"errmsg":"ok","send_check":true}
		System.out.println(cardUpdateRes.getBody());
	}

	/**
	 * 测试修改库存
	 */
	@Test
	public void testCardModifyStockReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		CardModifyStockRequest cardModifyStockReq = new CardModifyStockRequest("pFYHLvuDbMbr241m00CAhtypawpw", 10);
		CardModifyStockRespone cardModifyStockRes = wxClient.excute(cardModifyStockReq);
		//{"errcode":0,"errmsg":"ok"}
		System.out.println(cardModifyStockRes.getBody());
	}

	/**
	 * 测试更改Code
	 */
	@Test
	public void testCardCodeUpdateReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		CardCodeUpdateRequest cardCodeUpdateReq = new CardCodeUpdateRequest("351433422041", "35143342204190", "pFYHLvnyR6BTa5UuGeBhVADMdftA");
		CardCodeUpdateRespone cardCodeUpdateRes = wxClient.excute(cardCodeUpdateReq);
		//{"errcode":40056,"errmsg":"invalid serial code hint: [a.Jfca00401562]"}
		System.out.println(cardCodeUpdateRes.getBody());
	}

	/**
	 * 测试删除卡券
	 */
	@Test
	public void testCardDeleteReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		CardDeleteRequest cardDeleteReq = new CardDeleteRequest("pFYHLvuDbMbr241m00CAhtypawpw");
		CardDeleteRespone cardDeleteRes = wxClient.excute(cardDeleteReq);
		//{"errcode":0,"errmsg":"ok"}
		System.out.println(cardDeleteRes.getBody());
	}

	/**
	 * 测试设置卡券失效接口
	 */
	@Test
	public void testCardCodeUnavailableReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		CardCodeUnavailableRequest cardCodeUnavailableReq = new CardCodeUnavailableRequest("351433522041");
		cardCodeUnavailableReq.setReason("测试退款");
		cardCodeUnavailableReq.setCard_id("pFYHLvuDbMbr241m00CAhtypawpw");
		CardCodeUnavailableRespone cardCodeUnavailableRes = wxClient.excute(cardCodeUnavailableReq);
		//{"errcode":40056,"errmsg":"invalid serial code hint: [z.Vqga0426ard1]"}
		System.out.println(cardCodeUnavailableRes.getBody());
	}

	/**
	 * 测试拉取卡券概况数据接口
	 */
	@Test
	public void testGetCardBizuininfoReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		GetCardBizuininfoRequest getCardBizuininfoReq = new GetCardBizuininfoRequest("2017-12-01", "2017-12-31", 1);
		GetCardBizuininfoRespone getCardBizuininfoRes = wxClient.excute(getCardBizuininfoReq);
		//{"list":[{"ref_date":"2017-12-26","view_cnt":4,"view_user":1,"receive_cnt":0,"receive_user":0,"verify_cnt":0,"verify_user":0,"given_cnt":0,"given_user":0,"expire_cnt":0,"expire_user":0,"view_friends_cnt":0,"view_friends_user":0,"receive_friends_cnt":0,"receive_friends_user":0,"verify_friends_cnt":0,"verify_friends_user":0},{"ref_date":"2017-12-28","view_cnt":6,"view_user":2,"receive_cnt":2,"receive_user":1,"verify_cnt":0,"verify_user":0,"given_cnt":1,"given_user":1,"expire_cnt":0,"expire_user":0,"view_friends_cnt":0,"view_friends_user":0,"receive_friends_cnt":0,"receive_friends_user":0,"verify_friends_cnt":0,"verify_friends_user":0},{"ref_date":"2017-12-29","view_cnt":1,"view_user":1,"receive_cnt":1,"receive_user":1,"verify_cnt":1,"verify_user":1,"given_cnt":0,"given_user":0,"expire_cnt":0,"expire_user":0,"view_friends_cnt":0,"view_friends_user":0,"receive_friends_cnt":0,"receive_friends_user":0,"verify_friends_cnt":0,"verify_friends_user":0}]}
		System.out.println(getCardBizuininfoRes.getBody());
	}

	/**
	 * 测试获取免费券数据接口
	 */
	@Test
	public void testGetCardCardinfoReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		GetCardCardinfoRequest getCardCardinfoReq = new GetCardCardinfoRequest("2017-12-01", "2017-12-31", 1);
		GetCardCardinfoRespone getCardCardinfoRes = wxClient.excute(getCardCardinfoReq);
		//{"list":[{"ref_date":"2017-12-26","card_id":"pFYHLvhOx_HptVD0PUpbrNixlu0c","card_type":1,"is_pay":0,"view_cnt":1,"view_user":1,"receive_cnt":0,"receive_user":0,"verify_cnt":0,"verify_user":0,"given_cnt":0,"given_user":0,"expire_cnt":0,"expire_user":0,"verify_noself_cnt":0,"verify_noself_user":0,"isfriendscard":0},{"ref_date":"2017-12-26","card_id":"pFYHLvmkWy9im2fOd60AJRJfw68E","card_type":1,"is_pay":0,"view_cnt":3,"view_user":1,"receive_cnt":0,"receive_user":0,"verify_cnt":0,"verify_user":0,"given_cnt":0,"given_user":0,"expire_cnt":0,"expire_user":0,"verify_noself_cnt":0,"verify_noself_user":0,"isfriendscard":0},{"ref_date":"2017-12-28","card_id":"pFYHLvlpbLoaHpnguo6_COiV8Wy0","card_type":1,"is_pay":0,"view_cnt":4,"view_user":1,"receive_cnt":0,"receive_user":0,"verify_cnt":0,"verify_user":0,"given_cnt":0,"given_user":0,"expire_cnt":0,"expire_user":0,"verify_noself_cnt":0,"verify_noself_user":0,"isfriendscard":0},{"ref_date":"2017-12-28","card_id":"pFYHLvuDbMbr241m00CAhtypawpw","card_type":1,"is_pay":0,"view_cnt":2,"view_user":1,"receive_cnt":2,"receive_user":1,"verify_cnt":0,"verify_user":0,"given_cnt":1,"given_user":1,"expire_cnt":0,"expire_user":0,"verify_noself_cnt":0,"verify_noself_user":0,"isfriendscard":0},{"ref_date":"2017-12-29","card_id":"pFYHLvuDbMbr241m00CAhtypawpw","card_type":1,"is_pay":0,"view_cnt":1,"view_user":1,"receive_cnt":1,"receive_user":1,"verify_cnt":1,"verify_user":1,"given_cnt":0,"given_user":0,"expire_cnt":0,"expire_user":0,"verify_noself_cnt":0,"verify_noself_user":0,"isfriendscard":0}]}
		System.out.println(getCardCardinfoRes.getBody());
	}

	/**
	 * 测试拉取会员卡概况数据接口
	 */
	@Test
	public void testGetCardMemberCardinfoReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		GetCardMemberCardinfoRequest getCardMemberCardinfoReq = new GetCardMemberCardinfoRequest("2017-12-01", "2017-12-31", 1);
		GetCardMemberCardinfoRespone getCardMemberCardinfoRes = wxClient.excute(getCardMemberCardinfoReq);
		//{"list":[]}
		System.out.println(getCardMemberCardinfoRes.getBody());
	}

	/**
	 * 测试拉取单张会员卡数据接口
	 */
	@Test
	public void testGetCardMemberCarddetailReq() {
		WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
		GetCardMemberCarddetailRequest getCardMemberCarddetailReq = new GetCardMemberCarddetailRequest("2017-12-01", "2017-12-31", "pFYHLvuDbMbr241m00CAhtypawpw");
		GetCardMemberCarddetailRespone getCardMemberCarddetailRes = wxClient.excute(getCardMemberCarddetailReq);
		//{"errcode":61501,"errmsg":"date range error hint: [KbMaXa08491504]"}
		System.out.println(getCardMemberCarddetailRes.getBody());
	}

}
