package org.wx.sdk.user;

import org.junit.Test;
import org.wx.sdk.WxClient;
import org.wx.sdk.base.Const;
import org.wx.sdk.token.RedisAccessToken;
import org.wx.sdk.user.object.OpenidObj;
import org.wx.sdk.user.request.UserInfoBatchGetRequest;
import org.wx.sdk.user.request.UserInfoRequest;
import org.wx.sdk.user.request.UserListGetRequest;
import org.wx.sdk.user.request.UserUpdateRemarkRequest;
import org.wx.sdk.user.response.UserInfoBatchGetRespone;
import org.wx.sdk.user.response.UserInfoRespone;
import org.wx.sdk.user.response.UserListGetRespone;
import org.wx.sdk.user.response.UserUpdateRemarkRespone;
import java.util.ArrayList;
import java.util.List;

public class UserManReqTest {

    /**
     * 测试设置备注名
     */
    @Test
    public void testGroupCreateReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        UserUpdateRemarkRequest userUpdateRemarkReq = new UserUpdateRemarkRequest(Const.OPENID, "一器古");
        UserUpdateRemarkRespone userUpdateRemarkRes  = wxClient.excute(userUpdateRemarkReq);
        System.out.println(userUpdateRemarkRes.getBody());
        //{"errcode":0,"errmsg":"ok"}
    }
    
    /**
     * 测试获取用户基本信息（包括UnionID机制）
     */
    @Test
    public void testUserInfoReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        UserInfoRequest userInfoReq = new UserInfoRequest(Const.OPENID);
        UserInfoRespone userInfoRes  = wxClient.excute(userInfoReq);
        System.out.println(userInfoRes.getBody());
        //{"subscribe":1,"openid":"oFYHLvkzNC8P_uZKPS7ppSuHiYwk","nickname":"Rocye","sex":1,"language":"zh_CN","city":"武汉","province":"湖北","country":"中国","headimgurl":"http:\/\/wx.qlogo.cn\/mmopen\/pKWS5HxRzuJAyw4RTVcbdWQ8x0UaRBJec17p3XVjhz3lZicz4p2ia8I3iaUI1lCONKcoED7V9r1sE9TJdaOh1oEetu7C747TLXW\/0","subscribe_time":1476437212,"remark":"一器古","groupid":2,"tagid_list":[2]}
    }
    
    /**
     * 测试批量获取用户基本信息
     */
    @Test
    public void testUserInfoBatchGetReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        List<OpenidObj> openIdList = new ArrayList<OpenidObj>();
        openIdList.add(new OpenidObj(Const.OPENID));
        openIdList.add(new OpenidObj("oFYHLviCatnBPDs1XxcXoOePNows"));
        openIdList.add(new OpenidObj("oFYHLvsyY1M3XaOJF9qJLvlb3TEE"));
        
        UserInfoBatchGetRequest userInfoBatchGetReq = new UserInfoBatchGetRequest(openIdList);
        UserInfoBatchGetRespone userInfoBatchGetRes = wxClient.excute(userInfoBatchGetReq);
        System.out.println(userInfoBatchGetRes.getBody());
        //{"user_info_list":[{"subscribe":1,"openid":"oFYHLvkzNC8P_uZKPS7ppSuHiYwk","nickname":"Rocye","sex":1,"language":"zh_CN","city":"武汉","province":"湖北","country":"中国","headimgurl":"http:\/\/wx.qlogo.cn\/mmopen\/pKWS5HxRzuJAyw4RTVcbdWQ8x0UaRBJec17p3XVjhz3lZicz4p2ia8I3iaUI1lCONKcoED7V9r1sE9TJdaOh1oEetu7C747TLXW\/0","subscribe_time":1476437212,"remark":"一器古","groupid":2,"tagid_list":[2]},{"subscribe":1,"openid":"oFYHLviCatnBPDs1XxcXoOePNows","nickname":"1⃣气骨","sex":2,"language":"zh_CN","city":"武汉","province":"湖北","country":"中国","headimgurl":"http:\/\/wx.qlogo.cn\/mmopen\/pKWS5HxRzuLxAaUibxKrichTzeIFUmicggJiabZfic6YDIBJ1u9OhWnwJ796lBRicibByeDpF2E15eUIL4oNu0qYyXXU7FK7MhiakAwG\/0","subscribe_time":1472885656,"remark":"","groupid":2,"tagid_list":[2]},{"subscribe":0,"openid":"oFYHLvsyY1M3XaOJF9qJLvlb3TEE","tagid_list":[]}]}
    }
    
    /**
     * 测试获取用户列表
     */
    @Test
    public void testUserListGetReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        UserListGetRequest userListGetReq = new UserListGetRequest();
        UserListGetRespone userListGetRes = wxClient.excute(userListGetReq);
        System.out.println(userListGetRes.getBody());
        //{"total":3,"count":3,"data":{"openid":["oFYHLvox9VTMoeEbDVAJucOOeViI","oFYHLviCatnBPDs1XxcXoOePNows","oFYHLvkzNC8P_uZKPS7ppSuHiYwk"]},"next_openid":"oFYHLvkzNC8P_uZKPS7ppSuHiYwk"}
    }
    
}
