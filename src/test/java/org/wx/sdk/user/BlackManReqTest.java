package org.wx.sdk.user;

import org.junit.Test;
import org.wx.sdk.WxClient;
import org.wx.sdk.base.Const;
import org.wx.sdk.token.RedisAccessToken;
import org.wx.sdk.user.request.BatchblackListRequest;
import org.wx.sdk.user.request.BatchunblackListRequest;
import org.wx.sdk.user.request.BlackListGetRequest;
import org.wx.sdk.user.response.BatchblackListRespone;
import org.wx.sdk.user.response.BatchunblackListRespone;
import org.wx.sdk.user.response.BlackListGetRespone;
import java.util.ArrayList;
import java.util.List;

public class BlackManReqTest {

    /**
     * 测试获取公众号的黑名单列表
     */
    @Test
    public void testBlackListGetReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        BlackListGetRequest blackListGetReq = new BlackListGetRequest();
        BlackListGetRespone blackListGetRes  = wxClient.excute(blackListGetReq);
        System.out.println(blackListGetRes.getBody());
        //{"total":0,"count":0}
    }
    
    /**
     * 测试拉黑用户
     */
    @Test
    public void testBatchblackListReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        List<String> openIdList = new ArrayList<>();
        openIdList.add("oFYHLviCatnBPDs1XxcXoOePNows");
        BatchblackListRequest batchblackListReq = new BatchblackListRequest(openIdList);
        BatchblackListRespone batchblackListRes  = wxClient.excute(batchblackListReq);
        System.out.println(batchblackListRes.getBody());
        //{"errcode":0,"errmsg":"ok"}
    }
    
    /**
     * 测试取消拉黑用户
     */
    @Test
    public void testBatchunblackListReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        List<String> openIdList = new ArrayList<>();
        openIdList.add("oFYHLviCatnBPDs1XxcXoOePNows");
        BatchunblackListRequest batchunblackListReq = new BatchunblackListRequest(openIdList);
        BatchunblackListRespone batchunblackListRes  = wxClient.excute(batchunblackListReq);
        System.out.println(batchunblackListRes.getBody());
        //{"errcode":0,"errmsg":"ok"}
    }
    
}
