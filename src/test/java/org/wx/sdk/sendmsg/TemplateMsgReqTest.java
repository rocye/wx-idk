package org.wx.sdk.sendmsg;

import java.util.HashMap;
import java.util.Map;
import org.wx.sdk.WxClient;
import org.wx.sdk.base.Const;
import org.wx.sdk.template.request.TemplateDelPrivateRequest;
import org.wx.sdk.template.request.TemplateGetAllPrivateRequest;
import org.wx.sdk.template.request.TemplateGetIdRequest;
import org.wx.sdk.template.request.TemplateGetIndustryRequest;
import org.wx.sdk.template.request.TemplateSendRequest;
import org.wx.sdk.template.request.TemplateSetIndustryRequest;
import org.wx.sdk.template.request.TemplateSendRequest.DataObj;
import org.wx.sdk.template.response.TemplateDelPrivateRespone;
import org.wx.sdk.template.response.TemplateGetAllPrivateRespone;
import org.wx.sdk.template.response.TemplateGetIdRespone;
import org.wx.sdk.template.response.TemplateGetIndustryRespone;
import org.wx.sdk.template.response.TemplateSendRespone;
import org.wx.sdk.template.response.TemplateSetIndustryRespone;
import org.wx.sdk.token.RedisAccessToken;
import com.alibaba.fastjson.JSON;
import junit.framework.TestCase;

public class TemplateMsgReqTest extends TestCase {

    /**
     * 测试设置模板行业
     */
    public void testTemplateSetIndustryReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        TemplateSetIndustryRequest templateSetIndustryReq = new TemplateSetIndustryRequest("1", "2"); 
        TemplateSetIndustryRespone templateSetIndustryRes = wxClient.excute(templateSetIndustryReq);
        System.out.println(templateSetIndustryRes.getBody());
        //{"errcode":0,"errmsg":"ok"}
        assertTrue(templateSetIndustryRes.getErrcode() == 0);
    }
    
    /**
     * 测试获取设置的行业信息
     */
    public void testTemplateGetIndustryReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        TemplateGetIndustryRequest templateGetIndustryReq = new TemplateGetIndustryRequest(); 
        TemplateGetIndustryRespone templateGetIndustryRes = wxClient.excute(templateGetIndustryReq);
        System.out.println(templateGetIndustryRes.getBody());
        //{"primary_industry":{"first_class":"IT科技","second_class":"互联网|电子商务"},"secondary_industry":{"first_class":"IT科技","second_class":"IT软件与服务"}}
        assertTrue(templateGetIndustryRes.getErrcode() == 0);
    }
    
    /**
     * 测试获得模板ID
     */
    public void testTemplateGetIdReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        TemplateGetIdRequest templateGetIdReq = new TemplateGetIdRequest("TM00015"); 
        TemplateGetIdRespone templateGetIdRes = wxClient.excute(templateGetIdReq);
        System.out.println(templateGetIdRes.getBody());
        //{"errcode":0,"errmsg":"ok","template_id":"kSP_FC27oWheUJfnADyqFwAN8dRdr3tqT1TPNwMPgR8"}
        assertTrue(templateGetIdRes.getErrcode() == 0);
    }
    
    /**
     * 测试获取模板列表
     */
    public void testTemplateGetAllPrivateReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        TemplateGetAllPrivateRequest templateGetAllReq = new TemplateGetAllPrivateRequest(); 
        TemplateGetAllPrivateRespone templateGetAllRes = wxClient.excute(templateGetAllReq);
        System.out.println(templateGetAllRes.getBody());
        //{"template_list":[{"template_id":"kSP_FC27oWheUJfnADyqFwAN8dRdr3tqT1TPNwMPgR8","title":"订单支付成功","primary_industry":"IT科技","deputy_industry":"互联网|电子商务","content":"{{first.DATA}}\n\n支付金额：{{orderMoneySum.DATA}}\n商品信息：{{orderProductName.DATA}}\n{{Remark.DATA}}","example":"我们已收到您的货款，开始为您打包商品，请耐心等待: )\n支付金额：30.00元\n商品信息：我是商品名字\n\n如有问题请致电400-828-1878或直接在微信留言，小易将第一时间为您服务！"},{"template_id":"BCURGG_sueiOD_n-OYU83iBUzn6yVdEbZyNeQwMyTtE","title":"订单支付成功","primary_industry":"IT科技","deputy_industry":"互联网|电子商务","content":"{{first.DATA}}\n\n支付金额：{{orderMoneySum.DATA}}\n商品信息：{{orderProductName.DATA}}\n{{Remark.DATA}}","example":"我们已收到您的货款，开始为您打包商品，请耐心等待: )\n支付金额：30.00元\n商品信息：我是商品名字\n\n如有问题请致电400-828-1878或直接在微信留言，小易将第一时间为您服务！"}]}
        assertTrue(templateGetAllRes.getErrcode() == 0);
    }
    
    /**
     * 测试删除模板
     */
    public void testTemplateDelPrivateReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        TemplateDelPrivateRequest templateDelPrivateReq = new TemplateDelPrivateRequest("kSP_FC27oWheUJfnADyqFwAN8dRdr3tqT1TPNwMPgR8"); 
        TemplateDelPrivateRespone templateDelPrivateRes = wxClient.excute(templateDelPrivateReq);
        System.out.println(templateDelPrivateRes.getBody());
        //{"errcode":0,"errmsg":"ok"}
        assertTrue(templateDelPrivateRes.getErrcode() == 0);
    }
    
    /**
     * 测试发送模板消息(为什么只有first的内容？？)
     */
    public void testTemplateSendReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        Map<String, DataObj> dataMap = new HashMap<>();
        dataMap.put("first", new DataObj("恭喜你购买成功！", "#173177"));
        dataMap.put("keynote1", new DataObj("巧克力", "#173177"));
        dataMap.put("keynote2", new DataObj("39.8元", "#173177"));
        dataMap.put("keynote3", new DataObj("2017年9月22日", "#173177"));
        dataMap.put("remark", new DataObj("欢迎再次购买！", "#173177"));
        TemplateSendRequest templateSendReq = new TemplateSendRequest("oFYHLvkzNC8P_uZKPS7ppSuHiYwk", "BCURGG_sueiOD_n-OYU83iBUzn6yVdEbZyNeQwMyTtE", "http://www.baidu.com", dataMap);
        
        System.out.println(JSON.toJSONString(templateSendReq.getWxHashMap()));
        
        TemplateSendRespone templateSendRes = wxClient.excute(templateSendReq);
        System.out.println(templateSendRes.getBody());
        //{"errcode":0,"errmsg":"ok","msgid":434251333}
        assertTrue(templateSendRes.getErrcode() == 0);
    }
    
}
