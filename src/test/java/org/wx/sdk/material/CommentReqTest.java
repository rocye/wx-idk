package org.wx.sdk.material;

import org.junit.Test;
import org.wx.sdk.WxClient;
import org.wx.sdk.base.Const;
import org.wx.sdk.material.request.CommentCloseRequest;
import org.wx.sdk.material.request.CommentListRequest;
import org.wx.sdk.material.request.CommentOpenRequest;
import org.wx.sdk.material.response.CommentListRespone;
import org.wx.sdk.material.response.CommentRespone;
import org.wx.sdk.token.RedisAccessToken;

public class CommentReqTest {

    /**
     * 测试打开已群发文章评论
     */
    @Test
    public void testCommentOpenReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        CommentOpenRequest commentOpenReq = new CommentOpenRequest(1L, 0);
        CommentRespone commentRes  = wxClient.excute(commentOpenReq);
        System.out.println(commentRes.getBody());
    }
    
    /**
     * 测试关闭已群发文章评论
     */
    @Test
    public void testCommentCloseReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        CommentCloseRequest commentOpenReq = new CommentCloseRequest(1L, 0);
        CommentRespone commentRes  = wxClient.excute(commentOpenReq);
        System.out.println(commentRes.getBody());
    }
    
    /**
     * 测试查看指定文章的评论数据
     */
    @Test
    public void testCommentListReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        CommentListRequest commentListReq = new CommentListRequest(1L, 0, 1, 10, 0);
        CommentListRespone commentRes  = wxClient.excute(commentListReq);
        System.out.println(commentRes.getBody());
    }
    
}
