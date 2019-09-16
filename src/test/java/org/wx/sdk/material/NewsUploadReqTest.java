package org.wx.sdk.material;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.wx.sdk.WxClient;
import org.wx.sdk.base.Const;
import org.wx.sdk.material.object.News;
import org.wx.sdk.material.request.NewsInnerImgAddRequest;
import org.wx.sdk.material.request.NewsUploadRequest;
import org.wx.sdk.material.request.TempMaterialAddRequest;
import org.wx.sdk.material.response.NewsInnerImgAddRespone;
import org.wx.sdk.material.response.NewsUploadRespone;
import org.wx.sdk.material.response.TempMaterialAddRespone;
import org.wx.sdk.token.RedisAccessToken;

public class NewsUploadReqTest {

    /**
     * 测试上传高级群发里面的图文素材
     */
    @Test
    public void testPerpetualNewsUploadReq() {
        WxClient wxClient = new WxClient(new RedisAccessToken(Const.APPID, Const.APPSERCT));
        
//        //群发接口上传图文无法用永久缩略图ID
//        PerpetualMaterialAddRequest materialAddReq = new PerpetualMaterialAddRequest("thumb", "D:/Rocye/Pictures/460.jpg");
//        PerpetualMaterialAddRespone materialAddRes = wxClient.excute(materialAddReq);
//        System.out.println(materialAddRes.getBody());
//        String thumbMediaId = materialAddRes.getMedia_id();
        
        //临时缩略图ID测试成功
        TempMaterialAddRequest tempMaterialAddReq = new TempMaterialAddRequest("thumb", "D:/Rocye/Pictures/460.jpg");
        TempMaterialAddRespone tempMaterialAddRes = wxClient.excute(tempMaterialAddReq);
        System.out.println(tempMaterialAddRes.getBody());
        String thumbMediaId = tempMaterialAddRes.getThumb_media_id();
        
        NewsInnerImgAddRequest innerImgAddReq = new NewsInnerImgAddRequest("D:/Rocye/Pictures/11.png");
        NewsInnerImgAddRespone innerImgAddRes = wxClient.excute(innerImgAddReq);
        System.out.println(innerImgAddRes.getBody());
        String img = innerImgAddRes.getUrl();
        System.out.println(img);
        
        List<News> newsList = new ArrayList<News>(0);
        newsList.add(new News("测试群发永久缩图图文", thumbMediaId, "Rocye", "测试而已", (short)1, "这只是群发接口图文素材的一个测试<img src=\""+ img +"\"/>", "http://www.baidu.com"));
        NewsUploadRequest newsUploadReq = new NewsUploadRequest(newsList);
        NewsUploadRespone newsUploadRes = wxClient.excute(newsUploadReq);
        //{"type":"news","media_id":"2p3c00r856veThe7hDsedO46AwAZdoxkAitlGYnnb7g4JQFN4Gikc7UlJgn6-iBz","created_at":1475225485}
        System.out.println(newsUploadRes.getBody());
    }
    
}
