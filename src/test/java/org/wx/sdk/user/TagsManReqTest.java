package org.wx.sdk.user;

import org.junit.Test;
import org.wx.sdk.WxClient;
import org.wx.sdk.base.Const;
import org.wx.sdk.token.RedisAccessToken;
import org.wx.sdk.user.request.*;
import org.wx.sdk.user.response.*;
import java.util.ArrayList;
import java.util.List;

public class TagsManReqTest {
	/**
     * 测试创建标签
     */
    @Test
    public void testTagsCreateReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        TagsCreateRequest tagsCreateReq = new TagsCreateRequest("标签1");
        TagsCreateRespone tagsCreateRes  = wxClient.excute(tagsCreateReq);
        //{"tag":{"id":108,"name":"标签1"}}
        System.out.println(tagsCreateRes.getBody());
    }
    
    /**
     * 测试获取公众号已创建的标签
     */
    @Test
    public void testTagsGetReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        TagsGetRequest tagsGetReq = new TagsGetRequest();
        TagsGetRespone tagsGetRes  = wxClient.excute(tagsGetReq);
        //{"tags":[{"id":2,"name":"星标组","count":0},{"id":101,"name":"java组","count":0},{"id":103,"name":"修改后组","count":0},{"id":105,"name":"测试组2","count":0},{"id":106,"name":"测试组2","count":0},{"id":107,"name":"测试组2","count":0},{"id":108,"name":"标签1","count":0}]}
        System.out.println(tagsGetRes.getBody());
    }
    
    /**
     * 测试编辑标签
     */
    @Test
    public void testTagsUpdateReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        TagsUpdateRequest tagsUpdateReq = new TagsUpdateRequest(105, "修改后标签");
        TagsUpdateRespone tagsUpdateRes  = wxClient.excute(tagsUpdateReq);
        //{"errcode":0,"errmsg":"ok"}
        System.out.println(tagsUpdateRes.getBody());
    }
    
    /**
     * 测试删除分组
     */
    @Test
    public void testTagsDeleteReq() {
    	WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
    	TagsDeleteRequest tagsDeleteReq = new TagsDeleteRequest(103);
    	TagsDeleteRespone tagsDeleteRes  = wxClient.excute(tagsDeleteReq);
    	System.out.println(tagsDeleteRes.getBody());
    	//{"errcode":0,"errmsg":"ok"}
    }
    
    /**
     * 测试获取标签下粉丝列表
     */
    @Test
    public void testTagUserListGetReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        TagUserListGetRequest tagUserListGetReq = new TagUserListGetRequest(105);
        TagUserListGetRespone tagUserListGetRes  = wxClient.excute(tagUserListGetReq);
        //{"count":1,"data":{"openid":["oFYHLvkzNC8P_uZKPS7ppSuHiYwk"]},"next_openid":"oFYHLvkzNC8P_uZKPS7ppSuHiYwk"}
        System.out.println(tagUserListGetRes.getBody());
    }
    
    /**
     * 测试批量为用户打标签
     */
    @Test
    public void testTagsMemberBatchTagReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        List<String> openidList = new ArrayList<String>();
        openidList.add(Const.OPENID);
        TagsMemberBatchTagRequest tagsMemberBatchTagReq = new TagsMemberBatchTagRequest(openidList, 103);
        TagsMemberBatchTagRespone tagsMemberBatchTagRes  = wxClient.excute(tagsMemberBatchTagReq);
        System.out.println(tagsMemberBatchTagRes.getBody());
        //{"errcode":0,"errmsg":"ok"}
    }
    
    /**
     * 测试批量为用户取消标签
     */
    @Test
    public void testTagsMemberBatchUnTagReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        List<String> openidList = new ArrayList<String>();
        openidList.add(Const.OPENID);
        TagsMemberBatchUntagRequest tagsMemberBatchUntagReq = new TagsMemberBatchUntagRequest(openidList, 103);
        TagsMemberBatchUntagRespone tagsMemberBatchUntagRes  = wxClient.excute(tagsMemberBatchUntagReq);
        System.out.println(tagsMemberBatchUntagRes.getBody());
        //{"errcode":0,"errmsg":"ok"}
    }
    
    /**
     * 测试获取用户身上的标签列表
     */
    @Test
    public void testTagsGetidListGetReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        TagsGetidListRequest tagsGetidListReq = new TagsGetidListRequest(Const.OPENID);
        TagsGetidListRespone tagsGetidListRes  = wxClient.excute(tagsGetidListReq);
        //{"tagid_list":[108,103]}
        System.out.println(tagsGetidListRes.getBody());
    }
}
