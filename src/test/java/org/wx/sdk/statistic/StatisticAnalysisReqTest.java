package org.wx.sdk.statistic;

import org.wx.sdk.WxClient;
import org.wx.sdk.base.Const;
import org.wx.sdk.statistic.request.GetArticleSummaryRequest;
import org.wx.sdk.statistic.request.GetArticleTotalRequest;
import org.wx.sdk.statistic.request.GetInterfaceSummaryHourRequest;
import org.wx.sdk.statistic.request.GetInterfaceSummaryRequest;
import org.wx.sdk.statistic.request.GetUpstreamMsgDistMonthRequest;
import org.wx.sdk.statistic.request.GetUpstreamMsgDistRequest;
import org.wx.sdk.statistic.request.GetUpstreamMsgDistWeekRequest;
import org.wx.sdk.statistic.request.GetUpstreamMsgHourRequest;
import org.wx.sdk.statistic.request.GetUpstreamMsgMonthRequest;
import org.wx.sdk.statistic.request.GetUpstreamMsgRequest;
import org.wx.sdk.statistic.request.GetUpstreamMsgWeekRequest;
import org.wx.sdk.statistic.request.GetUserCumulateRequest;
import org.wx.sdk.statistic.request.GetUserReadHourRequest;
import org.wx.sdk.statistic.request.GetUserReadRequest;
import org.wx.sdk.statistic.request.GetUserShareHourRequest;
import org.wx.sdk.statistic.request.GetUserShareRequest;
import org.wx.sdk.statistic.request.GetUserSummaryRequest;
import org.wx.sdk.statistic.response.GetArticleSummaryRespone;
import org.wx.sdk.statistic.response.GetArticleTotalRespone;
import org.wx.sdk.statistic.response.GetInterfaceSummaryHourRespone;
import org.wx.sdk.statistic.response.GetInterfaceSummaryRespone;
import org.wx.sdk.statistic.response.GetUpstreamMsgDistMonthRespone;
import org.wx.sdk.statistic.response.GetUpstreamMsgDistRespone;
import org.wx.sdk.statistic.response.GetUpstreamMsgDistWeekRespone;
import org.wx.sdk.statistic.response.GetUpstreamMsgHourRespone;
import org.wx.sdk.statistic.response.GetUpstreamMsgMonthRespone;
import org.wx.sdk.statistic.response.GetUpstreamMsgRespone;
import org.wx.sdk.statistic.response.GetUpstreamMsgWeekRespone;
import org.wx.sdk.statistic.response.GetUserCumulateRespone;
import org.wx.sdk.statistic.response.GetUserReadHourRespone;
import org.wx.sdk.statistic.response.GetUserReadRespone;
import org.wx.sdk.statistic.response.GetUserShareHourRespone;
import org.wx.sdk.statistic.response.GetUserShareRespone;
import org.wx.sdk.statistic.response.GetUserSummaryRespone;
import org.wx.sdk.token.RedisAccessToken;
import junit.framework.TestCase;

/**
 * 数据统计接口测试
 * @author Rocye
 * @version 2017.09.30
 */
public class StatisticAnalysisReqTest extends TestCase {

    /**
     * 测试获取用户增减数据
     */
    public void testGetUserSummaryReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        GetUserSummaryRequest getUserSummaryReq = new GetUserSummaryRequest("2017-09-20", "2017-09-25");
        GetUserSummaryRespone getUserSummaryRes  = wxClient.excute(getUserSummaryReq);
        System.out.println(getUserSummaryRes.getBody());
        assertTrue(getUserSummaryRes.getErrcode() == 0);
    }
    
    /**
     * 测试获取累计用户数据
     */
    public void testGetUserCumulateReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        GetUserCumulateRequest getUserCumulateReq = new GetUserCumulateRequest("2017-09-20", "2017-09-25");
        GetUserCumulateRespone getUserCumulateRes  = wxClient.excute(getUserCumulateReq);
        System.out.println(getUserCumulateRes.getBody());
        assertTrue(getUserCumulateRes.getErrcode() == 0);
    }
    
    /**
     * 测试获取图文群发每日数据
     */
    public void testGetArticleSummaryReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        GetArticleSummaryRequest getArticleSummaryReq = new GetArticleSummaryRequest("2017-09-20", "2017-09-20");
        GetArticleSummaryRespone getArticleSummaryRes  = wxClient.excute(getArticleSummaryReq);
        System.out.println(getArticleSummaryRes.getBody());
        assertTrue(getArticleSummaryRes.getErrcode() == 0);
    }
    
    /**
     * 测试获取图文群发总数据
     */
    public void testGetArticleTotalReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        GetArticleTotalRequest getArticleTotalReq = new GetArticleTotalRequest("2017-09-20", "2017-09-20");
        GetArticleTotalRespone getArticleTotalRes  = wxClient.excute(getArticleTotalReq);
        System.out.println(getArticleTotalRes.getBody());
        assertTrue(getArticleTotalRes.getErrcode() == 0);
    }
    
    /**
     * 测试获取图文统计数据
     */
    public void testGetUserReadReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        GetUserReadRequest getUserReadReq = new GetUserReadRequest("2017-09-20", "2017-09-22");
        GetUserReadRespone getUserReadRes  = wxClient.excute(getUserReadReq);
        System.out.println(getUserReadRes.getBody());
        assertTrue(getUserReadRes.getErrcode() == 0);
    }
    
    /**
     * 测试获取图文统计分时数据
     */
    public void testGetUserReadHourReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        GetUserReadHourRequest getUserReadHourReq = new GetUserReadHourRequest("2017-09-20", "2017-09-20");
        GetUserReadHourRespone getUserReadHourRes  = wxClient.excute(getUserReadHourReq);
        System.out.println(getUserReadHourRes.getBody());
        assertTrue(getUserReadHourRes.getErrcode() == 0);
    }
    
    /**
     * 测试获取图文分享转发数据
     */
    public void testGetUserShareReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        GetUserShareRequest getUserShareReq = new GetUserShareRequest("2017-09-20", "2017-09-26");
        GetUserShareRespone getUserShareRes  = wxClient.excute(getUserShareReq);
        System.out.println(getUserShareRes.getBody());
        assertTrue(getUserShareRes.getErrcode() == 0);
    }
    
    /**
     * 测试获取图文分享转发分时数据
     */
    public void testGetUserShareHourReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        GetUserShareHourRequest getUserShareHourReq = new GetUserShareHourRequest("2017-09-20", "2017-09-20");
        GetUserShareHourRespone getUserShareHourRes  = wxClient.excute(getUserShareHourReq);
        System.out.println(getUserShareHourRes.getBody());
        assertTrue(getUserShareHourRes.getErrcode() == 0);
    }
    
    /**
     * 测试获取消息发送概况数据
     */
    public void testGetUpstreamMsgReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        GetUpstreamMsgRequest getUpstreamMsgReq = new GetUpstreamMsgRequest("2017-09-20", "2017-09-25");
        GetUpstreamMsgRespone getUpstreamMsgRes  = wxClient.excute(getUpstreamMsgReq);
        System.out.println(getUpstreamMsgRes.getBody());
        assertTrue(getUpstreamMsgRes.getErrcode() == 0);
    }
    
    /**
     * 测试获取消息分送分时数据
     */
    public void testGetUpstreamMsgHourReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        GetUpstreamMsgHourRequest getUpstreamMsgHourReq = new GetUpstreamMsgHourRequest("2017-09-20", "2017-09-20");
        GetUpstreamMsgHourRespone getUpstreamMsgHourRes  = wxClient.excute(getUpstreamMsgHourReq);
        System.out.println(getUpstreamMsgHourRes.getBody());
        assertTrue(getUpstreamMsgHourRes.getErrcode() == 0);
    }
    
    /**
     * 测试获取消息发送周数据
     */
    public void testGetUpstreamMsgWeekReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        GetUpstreamMsgWeekRequest getUpstreamMsgWeekReq = new GetUpstreamMsgWeekRequest("2017-09-20", "2017-09-30");
        GetUpstreamMsgWeekRespone getUpstreamMsgWeekRes  = wxClient.excute(getUpstreamMsgWeekReq);
        System.out.println(getUpstreamMsgWeekRes.getBody());
        assertTrue(getUpstreamMsgWeekRes.getErrcode() == 0);
    }
    
    /**
     * 测试获取消息发送月数据
     */
    public void testGetUpstreamMsgMonthReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        GetUpstreamMsgMonthRequest getUpstreamMsgMonthReq = new GetUpstreamMsgMonthRequest("2017-09-20", "2017-09-30");
        GetUpstreamMsgMonthRespone getUpstreamMsgMonthRes  = wxClient.excute(getUpstreamMsgMonthReq);
        System.out.println(getUpstreamMsgMonthRes.getBody());
        assertTrue(getUpstreamMsgMonthRes.getErrcode() == 0);
    }
    
    /**
     * 测试获取消息发送分布数据
     */
    public void testGetUpstreamMsgDistReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        GetUpstreamMsgDistRequest getUpstreamMsgDistReq = new GetUpstreamMsgDistRequest("2017-09-20", "2017-09-27");
        GetUpstreamMsgDistRespone getUpstreamMsgDistRes  = wxClient.excute(getUpstreamMsgDistReq);
        System.out.println(getUpstreamMsgDistRes.getBody());
        assertTrue(getUpstreamMsgDistRes.getErrcode() == 0);
    }
    
    /**
     * 测试获取消息发送分布周数据
     */
    public void testGetUpstreamMsgDistWeekReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        GetUpstreamMsgDistWeekRequest getUpstreamMsgDistWeekReq = new GetUpstreamMsgDistWeekRequest("2017-09-20", "2017-09-30");
        GetUpstreamMsgDistWeekRespone getUpstreamMsgDistWeekRes  = wxClient.excute(getUpstreamMsgDistWeekReq);
        System.out.println(getUpstreamMsgDistWeekRes.getBody());
        assertTrue(getUpstreamMsgDistWeekRes.getErrcode() == 0);
    }
    
    /**
     * 测试获取消息发送分布月数据
     */
    public void testGetUpstreamMsgDistMonthReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        GetUpstreamMsgDistMonthRequest getUpstreamMsgDistMonthReq = new GetUpstreamMsgDistMonthRequest("2017-09-20", "2017-09-30");
        GetUpstreamMsgDistMonthRespone getUpstreamMsgDistMonthRes  = wxClient.excute(getUpstreamMsgDistMonthReq);
        System.out.println(getUpstreamMsgDistMonthRes.getBody());
        assertTrue(getUpstreamMsgDistMonthRes.getErrcode() == 0);
    }
    
    /**
     * 测试获取接口分析数据
     */
    public void testGetInterfaceSummaryReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        GetInterfaceSummaryRequest getInterfaceSummaryReq = new GetInterfaceSummaryRequest("2017-09-20", "2017-09-30");
        GetInterfaceSummaryRespone getInterfaceSummaryRes  = wxClient.excute(getInterfaceSummaryReq);
        System.out.println(getInterfaceSummaryRes.getBody());
        assertTrue(getInterfaceSummaryRes.getErrcode() == 0);
    }
    
    /**
     * 测试获取接口分析分时数据
     */
    public void testGetInterfaceSummaryHourReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        GetInterfaceSummaryHourRequest getInterfaceSummaryHourReq = new GetInterfaceSummaryHourRequest("2017-09-20", "2017-09-20");
        GetInterfaceSummaryHourRespone getInterfaceSummaryHourRes  = wxClient.excute(getInterfaceSummaryHourReq);
        System.out.println(getInterfaceSummaryHourRes.getBody());
        assertTrue(getInterfaceSummaryHourRes.getErrcode() == 0);
    }
    
}
