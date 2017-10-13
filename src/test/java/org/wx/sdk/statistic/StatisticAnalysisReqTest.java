package org.wx.sdk.statistic;

import org.junit.Test;
import org.wx.sdk.WxClient;
import org.wx.sdk.base.Const;
import org.wx.sdk.statistic.request.*;
import org.wx.sdk.statistic.response.*;
import org.wx.sdk.token.RedisAccessToken;

/**
 * 数据统计接口测试
 * @author Rocye
 * @version 2017.09.30
 */
public class StatisticAnalysisReqTest {

    /**
     * 测试获取用户增减数据
     */
    @Test
    public void testGetUserSummaryReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        GetUserSummaryRequest getUserSummaryReq = new GetUserSummaryRequest("2017-09-20", "2017-09-25");
        GetUserSummaryRespone getUserSummaryRes  = wxClient.excute(getUserSummaryReq);
        System.out.println(getUserSummaryRes.getBody());
    }
    
    /**
     * 测试获取累计用户数据
     */
    @Test
    public void testGetUserCumulateReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        GetUserCumulateRequest getUserCumulateReq = new GetUserCumulateRequest("2017-09-20", "2017-09-25");
        GetUserCumulateRespone getUserCumulateRes  = wxClient.excute(getUserCumulateReq);
        System.out.println(getUserCumulateRes.getBody());
    }
    
    /**
     * 测试获取图文群发每日数据
     */
    @Test
    public void testGetArticleSummaryReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        GetArticleSummaryRequest getArticleSummaryReq = new GetArticleSummaryRequest("2017-09-20", "2017-09-20");
        GetArticleSummaryRespone getArticleSummaryRes  = wxClient.excute(getArticleSummaryReq);
        System.out.println(getArticleSummaryRes.getBody());
    }
    
    /**
     * 测试获取图文群发总数据
     */
    @Test
    public void testGetArticleTotalReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        GetArticleTotalRequest getArticleTotalReq = new GetArticleTotalRequest("2017-09-20", "2017-09-20");
        GetArticleTotalRespone getArticleTotalRes  = wxClient.excute(getArticleTotalReq);
        System.out.println(getArticleTotalRes.getBody());
    }
    
    /**
     * 测试获取图文统计数据
     */
    @Test
    public void testGetUserReadReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        GetUserReadRequest getUserReadReq = new GetUserReadRequest("2017-09-20", "2017-09-22");
        GetUserReadRespone getUserReadRes  = wxClient.excute(getUserReadReq);
        System.out.println(getUserReadRes.getBody());
    }
    
    /**
     * 测试获取图文统计分时数据
     */
    @Test
    public void testGetUserReadHourReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        GetUserReadHourRequest getUserReadHourReq = new GetUserReadHourRequest("2017-09-20", "2017-09-20");
        GetUserReadHourRespone getUserReadHourRes  = wxClient.excute(getUserReadHourReq);
        System.out.println(getUserReadHourRes.getBody());
    }
    
    /**
     * 测试获取图文分享转发数据
     */
    @Test
    public void testGetUserShareReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        GetUserShareRequest getUserShareReq = new GetUserShareRequest("2017-09-20", "2017-09-26");
        GetUserShareRespone getUserShareRes  = wxClient.excute(getUserShareReq);
        System.out.println(getUserShareRes.getBody());
    }
    
    /**
     * 测试获取图文分享转发分时数据
     */
    @Test
    public void testGetUserShareHourReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        GetUserShareHourRequest getUserShareHourReq = new GetUserShareHourRequest("2017-09-20", "2017-09-20");
        GetUserShareHourRespone getUserShareHourRes  = wxClient.excute(getUserShareHourReq);
        System.out.println(getUserShareHourRes.getBody());
    }
    
    /**
     * 测试获取消息发送概况数据
     */
    @Test
    public void testGetUpstreamMsgReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        GetUpstreamMsgRequest getUpstreamMsgReq = new GetUpstreamMsgRequest("2017-09-20", "2017-09-25");
        GetUpstreamMsgRespone getUpstreamMsgRes  = wxClient.excute(getUpstreamMsgReq);
        System.out.println(getUpstreamMsgRes.getBody());
    }
    
    /**
     * 测试获取消息分送分时数据
     */
    @Test
    public void testGetUpstreamMsgHourReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        GetUpstreamMsgHourRequest getUpstreamMsgHourReq = new GetUpstreamMsgHourRequest("2017-09-20", "2017-09-20");
        GetUpstreamMsgHourRespone getUpstreamMsgHourRes  = wxClient.excute(getUpstreamMsgHourReq);
        System.out.println(getUpstreamMsgHourRes.getBody());
    }
    
    /**
     * 测试获取消息发送周数据
     */
    @Test
    public void testGetUpstreamMsgWeekReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        GetUpstreamMsgWeekRequest getUpstreamMsgWeekReq = new GetUpstreamMsgWeekRequest("2017-09-20", "2017-09-30");
        GetUpstreamMsgWeekRespone getUpstreamMsgWeekRes  = wxClient.excute(getUpstreamMsgWeekReq);
        System.out.println(getUpstreamMsgWeekRes.getBody());
    }
    
    /**
     * 测试获取消息发送月数据
     */
    @Test
    public void testGetUpstreamMsgMonthReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        GetUpstreamMsgMonthRequest getUpstreamMsgMonthReq = new GetUpstreamMsgMonthRequest("2017-09-20", "2017-09-30");
        GetUpstreamMsgMonthRespone getUpstreamMsgMonthRes  = wxClient.excute(getUpstreamMsgMonthReq);
        System.out.println(getUpstreamMsgMonthRes.getBody());
    }
    
    /**
     * 测试获取消息发送分布数据
     */
    @Test
    public void testGetUpstreamMsgDistReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        GetUpstreamMsgDistRequest getUpstreamMsgDistReq = new GetUpstreamMsgDistRequest("2017-09-20", "2017-09-27");
        GetUpstreamMsgDistRespone getUpstreamMsgDistRes  = wxClient.excute(getUpstreamMsgDistReq);
        System.out.println(getUpstreamMsgDistRes.getBody());
    }
    
    /**
     * 测试获取消息发送分布周数据
     */
    @Test
    public void testGetUpstreamMsgDistWeekReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        GetUpstreamMsgDistWeekRequest getUpstreamMsgDistWeekReq = new GetUpstreamMsgDistWeekRequest("2017-09-20", "2017-09-30");
        GetUpstreamMsgDistWeekRespone getUpstreamMsgDistWeekRes  = wxClient.excute(getUpstreamMsgDistWeekReq);
        System.out.println(getUpstreamMsgDistWeekRes.getBody());
    }
    
    /**
     * 测试获取消息发送分布月数据
     */
    @Test
    public void testGetUpstreamMsgDistMonthReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        GetUpstreamMsgDistMonthRequest getUpstreamMsgDistMonthReq = new GetUpstreamMsgDistMonthRequest("2017-09-20", "2017-09-30");
        GetUpstreamMsgDistMonthRespone getUpstreamMsgDistMonthRes  = wxClient.excute(getUpstreamMsgDistMonthReq);
        System.out.println(getUpstreamMsgDistMonthRes.getBody());
    }
    
    /**
     * 测试获取接口分析数据
     */
    @Test
    public void testGetInterfaceSummaryReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        GetInterfaceSummaryRequest getInterfaceSummaryReq = new GetInterfaceSummaryRequest("2017-09-20", "2017-09-30");
        GetInterfaceSummaryRespone getInterfaceSummaryRes  = wxClient.excute(getInterfaceSummaryReq);
        System.out.println(getInterfaceSummaryRes.getBody());
    }
    
    /**
     * 测试获取接口分析分时数据
     */
    @Test
    public void testGetInterfaceSummaryHourReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        GetInterfaceSummaryHourRequest getInterfaceSummaryHourReq = new GetInterfaceSummaryHourRequest("2017-09-20", "2017-09-20");
        GetInterfaceSummaryHourRespone getInterfaceSummaryHourRes  = wxClient.excute(getInterfaceSummaryHourReq);
        System.out.println(getInterfaceSummaryHourRes.getBody());
    }
    
}
