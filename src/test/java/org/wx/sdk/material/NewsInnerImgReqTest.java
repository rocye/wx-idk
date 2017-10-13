package org.wx.sdk.material;

import org.junit.Test;
import org.wx.sdk.WxClient;
import org.wx.sdk.base.Const;
import org.wx.sdk.token.RedisAccessToken;
import org.wx.sdk.material.request.NewsInnerImgAddRequest;
import org.wx.sdk.material.response.NewsInnerImgAddRespone;

public class NewsInnerImgReqTest {

    /**
     * 测试添加图文内图片
     */
    @Test
    public void testTempMediaAddReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        
        String filePath = "D:\\Rocye\\Pictures\\1.JPG";
        NewsInnerImgAddRequest newsInnerImgAddReq = new NewsInnerImgAddRequest(filePath);
        NewsInnerImgAddRespone newsInnerImgAddRes = wxClient.excute(newsInnerImgAddReq);

        System.out.println(newsInnerImgAddRes.getBody());
        System.out.println(newsInnerImgAddRes.getUrl());
    }
    
}
